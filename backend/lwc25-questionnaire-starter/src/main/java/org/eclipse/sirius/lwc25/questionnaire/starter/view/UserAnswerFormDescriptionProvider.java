package org.eclipse.sirius.lwc25.questionnaire.starter.view;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.sirius.components.view.RepresentationDescription;
import org.eclipse.sirius.components.view.builder.generated.form.FormBuilders;
import org.eclipse.sirius.components.view.builder.generated.view.ViewBuilders;
import org.eclipse.sirius.components.view.builder.providers.IColorProvider;
import org.eclipse.sirius.components.view.builder.providers.IRepresentationDescriptionProvider;
import org.eclipse.sirius.components.view.form.FormElementDescription;
import org.eclipse.sirius.questionnaire.QuestionnairePackage;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class UserAnswerFormDescriptionProvider implements IRepresentationDescriptionProvider {

    public static String LABEL = "User Answer Form Description";

    private final FormBuilders formBuilderHelper = new FormBuilders();
    private final ViewUtils viewUtils = new ViewUtils();
    private final ViewBuilders viewBuilderHelper = new ViewBuilders();

    private final List<IFormAnswerGenerator> generators;

    public UserAnswerFormDescriptionProvider(List<IFormAnswerGenerator> generators) {
        this.generators = generators;
    }

    @Override
    public RepresentationDescription create(IColorProvider colorProvider) {
        var formDescription = formBuilderHelper.newFormDescription()
                .name(LABEL)
                .domainType("answer::UserAnswers")
                .titleExpression("aql:self.name + ' answer form'")
                .build();

        var pageDescription = formBuilderHelper.newPageDescription()
                .name("Page Description")
                .domainType("answer::UserAnswers")
                .semanticCandidatesExpression("aql:self")
                .labelExpression("aql:self.name")
                .build();

        var title = formBuilderHelper.newLabelDescription()
                .valueExpression("aql: self.eContainer().form.name")
                .name("Form Title")
                .style(formBuilderHelper.newLabelDescriptionStyle().fontSize(20).bold(true).build())
                .build();

        var renderGroupDescription = formBuilderHelper.newGroupDescription()
                .name("Render Group Description")
                .semanticCandidatesExpression("aql:self")
                .children(title)
                .build();

        var ifNotLinked = formBuilderHelper.newFormElementIf()
                .predicateExpression("aql: self.name = null or self.name.size() = 0 or self.answers->isEmpty()")
                .build();

        var formReferenceWidget = formBuilderHelper.newTextfieldDescription()
                .labelExpression("Your Name")
                .name("Your name")
                .valueExpression("aql: self.name")
                .body(viewUtils.textfieldSetter("self", "name"))
                .build();

        var initButton = formBuilderHelper.newButtonDescription()
                .name("Next Button")
                .buttonLabelExpression("Next")
                .isEnabledExpression("aql: self.name <> null and self.name.size() > 0")
                .body(viewBuilderHelper.newChangeContext().expression("aql: self.init()").build())
                .build();

        ifNotLinked.getChildren().add(formReferenceWidget);
        ifNotLinked.getChildren().add(initButton);

        var ifLinked = formBuilderHelper.newFormElementIf()
                .predicateExpression("aql: self.name <> null and self.name.size() > 0 and not self.answers->isEmpty()")
                .build();

        formDescription.getPages().add(pageDescription);
        pageDescription.getGroups().add(renderGroupDescription);
        renderGroupDescription.getChildren().add(ifNotLinked);
        renderGroupDescription.getChildren().add(ifLinked);
        ifLinked.getChildren().addAll(generateMainLoop());

        return formDescription;
    }

    private List<FormElementDescription> generateMainLoop() {
        var previousHandleExpressions = new LinkedList<String>();
        var result = new LinkedList<FormElementDescription>();
        for(var generator: generators) {
            var query = "aql: " + previousHandleExpressions.stream().map(expr -> "not (" + expr + ") and ")
                    .collect(Collectors.joining()) + generator.canHandle();
            previousHandleExpressions.add(generator.canHandle());

            var ifCanHandleAndNotRendered = formBuilderHelper.newFormElementIf()
                    .predicateExpression(query)
                    .build();

            var loop = generator.generateLoop();
            var questionExpression = generator.getQuestionFromIteratorExpression();

            BiFunction<String, Boolean, FormElementDescription> questionWithDisplayConditionDesc = (questionExpr, isReuse) -> {
                var description = generator.generateDisplayCondition(questionExpr);
                description.getChildren().addAll(getQuestionDescriptions(questionExpr, generator, isReuse));
                return description;
            };

            var ifAnswerExistForQuestion = formBuilderHelper.newFormElementIf()
                    .name("If An Answer Element Exists For Question")
                    .predicateExpression("aql: " + questionExpression + ".oclIsKindOf(questionnaire::Question) and (" + questionExpression + ".computedExpression.size() > 0 or self.answers->exists(answer | answer.question = " + questionExpression + "))")
                    .children(questionWithDisplayConditionDesc.apply(questionExpression, false))
                    .build();

            var ifAnswerExistForQuestionReuse = formBuilderHelper.newFormElementIf()
                    .name("If An Answer Element Exists For Question Reuse")
                    .predicateExpression("aql: " + questionExpression + ".oclIsKindOf(questionnaire::QuestionReuse) and (" + questionExpression + ".question.computedExpression.size() > 0 or self.answers->exists(answer | answer.question = " + questionExpression + ".question))")
                    .children(questionWithDisplayConditionDesc.apply(questionExpression + ".question", true))
                    .build();

            loop.getChildren().addAll(List.of(ifAnswerExistForQuestionReuse, ifAnswerExistForQuestion));
            ifCanHandleAndNotRendered.getChildren().add(loop);
            result.add(ifCanHandleAndNotRendered);
        }
        return result;
    }

    private List<FormElementDescription> getQuestionDescriptions(String currentQuestionExpression, IFormAnswerGenerator generator, boolean isReuse) {
        var ifIsNotComputed = formBuilderHelper.newFormElementIf()
                .name("If Question Is Not Computed")
                .predicateExpression("aql: " + currentQuestionExpression + ".computedExpression.size() = 0")
                .build();

        var typeEclass = QuestionnairePackage.eINSTANCE.getType();
        ifIsNotComputed.getChildren().addAll(QuestionnairePackage.eINSTANCE.getEClassifiers().stream()
                .filter(EClass.class::isInstance)
                .map(EClass.class::cast)
                .filter(typeEclass::isSuperTypeOf)
                .filter(type -> type != typeEclass)
                .map(type -> (FormElementDescription) formBuilderHelper.newFormElementIf()
                        .name("If Element Is " + type.getName() + " Question")
                        .predicateExpression("aql: " + currentQuestionExpression + ".type.oclIsKindOf(questionnaire::" + type.getName() + ")")
                        .children(generator.dispatchType(type, "it", currentQuestionExpression, isReuse).toArray(FormElementDescription[]::new))
                        .build())
                .toList());

        var ifIsComputed = formBuilderHelper.newFormElementIf()
                .name("If Question Is Computed")
                .predicateExpression("aql: " + currentQuestionExpression + ".computedExpression.size() > 0")
                .build();

        var displayComputedQuestion = formBuilderHelper.newLabelDescription()
                .name("Computed Expression")
                .labelExpression("aql:" + currentQuestionExpression + ".label")
                .valueExpression("aql: " + currentQuestionExpression + ".evaluate(self)")
                .build();

        ifIsComputed.getChildren().add(displayComputedQuestion);

        return List.of(ifIsComputed, ifIsNotComputed);
    }
}
