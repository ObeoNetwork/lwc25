package org.eclipse.sirius.lwc25.questionnaire.starter.view;

import org.eclipse.sirius.components.view.RepresentationDescription;
import org.eclipse.sirius.components.view.builder.generated.form.FormBuilders;
import org.eclipse.sirius.components.view.builder.generated.view.ViewBuilders;
import org.eclipse.sirius.components.view.builder.providers.IColorProvider;
import org.eclipse.sirius.components.view.builder.providers.IRepresentationDescriptionProvider;
import org.eclipse.sirius.components.view.form.ContainerBorderLineStyle;
import org.eclipse.sirius.components.view.form.FlexDirection;
import org.eclipse.sirius.components.view.form.PageDescription;

import java.util.List;

public class FormAnswerDescriptionProvider implements IRepresentationDescriptionProvider {

    private final FormBuilders formBuilderHelper = new FormBuilders();
    private final ViewBuilders viewBuilderHelper = new ViewBuilders();
    private final ViewUtils viewUtils = new ViewUtils();

    @Override
    public RepresentationDescription create(IColorProvider colorProvider) {
        var formDescription = formBuilderHelper.newFormDescription()
                .name("Form Answer Description")
                .domainType("answer::FormAnswers")
                .titleExpression("Form Main Page")
                .build();

        var pageDescription = formBuilderHelper.newPageDescription()
                .name("Answer Page Description")
                .domainType("answer::FormAnswers")
                .semanticCandidatesExpression("aql:self")
                .labelExpression("Answers")
                .build();

        var renderGroupDescription = formBuilderHelper.newGroupDescription()
                .name("Render Group Description")
                .semanticCandidatesExpression("aql:self")
                .build();

        var formLabel = formBuilderHelper.newLabelDescription()
                .valueExpression("aql: 'You\\'re about to fill in the form \\'' + self.form.name + '\\''")
                .build();

        var idTextfield = formBuilderHelper.newTextfieldDescription()
                .labelExpression("Your email address")
                .body(viewUtils.textfieldSetter("self", "userId"))
                .valueExpression("aql: self.userId")
                .build();

        var confirmButton = formBuilderHelper.newButtonDescription()
                .buttonLabelExpression("Start")
                .isEnabledExpression("aql:self.userId.size() > 0")
                .body(viewBuilderHelper.newChangeContext()
                        .expression("aql:self.start(editingContext)").build()/*,
                        viewBuilderHelper.newSetValue()
                                .featureName("userId")
                                .valueExpression("")
                                .build()*/)
                    .build();

        formDescription.getPages().addAll(List.of(pageDescription, createStatsPage(colorProvider)));
        pageDescription.getGroups().add(renderGroupDescription);
        renderGroupDescription.getChildren().add(formLabel);
        renderGroupDescription.getChildren().add(idTextfield);
        renderGroupDescription.getChildren().add(confirmButton);

        return formDescription;
    }

    public PageDescription createStatsPage(IColorProvider colorProvider) {
        var pageDescription = formBuilderHelper.newPageDescription()
                .name("Statistics Page Description")
                .domainType("answer::FormAnswers")
                .semanticCandidatesExpression("aql:self")
                .labelExpression("Stats")
                .build();

        var renderGroupDescription = formBuilderHelper.newGroupDescription()
                .name("Render Group Description")
                .semanticCandidatesExpression("aql:self")
                .build();

        var forQuestions = formBuilderHelper.newFormElementFor()
                .iterableExpression("aql:self.form.eAllContents(questionnaire::Question)->select(q | q.computedExpression.size() = 0)")
                .iterator("it")
                .build();

        var answerDisplayContainer = formBuilderHelper.newFlexboxContainerDescription()
                .flexDirection(FlexDirection.COLUMN)
                .borderStyle(formBuilderHelper.newContainerBorderStyle()
                        .borderLineStyle(ContainerBorderLineStyle.DASHED)
                        .borderColor(colorProvider.getColor("Questionnaire_Gray"))
                        .build())
                .labelExpression("aql: it.label")
                .build();

        var nbAnswerLabel = formBuilderHelper.newLabelDescription()
                .name("Display Nb Answers")
                .valueExpression("aql: 'Number of answers: ' + self.userAnswers.answers->select(an | an.question = it and an.answer <> null and an.answer.size() > 0)->size()")
                .build();

        var ifNotEnumQuestion = formBuilderHelper.newFormElementIf()
                .name("If It Is Not Enumeration Question")
                .predicateExpression("aql: not it.type.oclIsKindOf(questionnaire::EnumerationType)")
                .build();

        var notEnumQuestionStats = formBuilderHelper.newListDescription()
                .labelExpression("Answers")
                .valueExpression("aql: self.userAnswers.answers->select(an | an.question = it and an.answer <> null and an.answer.size() > 0)")
                .displayExpression("aql: candidate.answer")
                .isEnabledExpression("aql:false")
                .build();

        var ifEnumerationQuestion = formBuilderHelper.newFormElementIf()
                .name("If It Is Enumeration Question")
                .predicateExpression("aql: it.type.oclIsKindOf(questionnaire::EnumerationType)")
                .build();

        var enumQuestionStats = formBuilderHelper.newPieChartDescription()
                .name("Enumeration Pie Chart Description")
                .labelExpression("Answers")
                .keysExpression("aql: it.type.getKeys()")
                .valuesExpression("aql: it.type.getValues(self)")
                .style(formBuilderHelper.newPieChartDescriptionStyle()
                        .colors("aql: Sequence{ '#1abc9c', '#16a085', '#2ecc71', '#27ae60', '#3498db', '#2980b9', '#9b59b6', '#8e44ad', '#34495e', '#2c3e50', '#f1c40f', '#f39c12', '#e67e22', '#d35400', '#e74c3c', '#c0392b', '#ecf0f1', '#bdc3c7', '#95a5a6', '#7f8c8d' }")
                        .build())
                .build();

        answerDisplayContainer.getChildren().addAll(List.of(nbAnswerLabel, ifNotEnumQuestion, ifEnumerationQuestion));
        ifNotEnumQuestion.getChildren().add(notEnumQuestionStats);
        ifEnumerationQuestion.getChildren().add(enumQuestionStats);

        pageDescription.getGroups().add(renderGroupDescription);
        renderGroupDescription.getChildren().add(forQuestions);
        forQuestions.getChildren().add(answerDisplayContainer);

        return pageDescription;
    }
}
