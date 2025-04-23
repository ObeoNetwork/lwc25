package org.eclipse.sirius.lwc25.questionnaire.starter.view;

import org.eclipse.sirius.components.view.RepresentationDescription;
import org.eclipse.sirius.components.view.builder.generated.form.FormBuilders;
import org.eclipse.sirius.components.view.builder.generated.view.ViewBuilders;
import org.eclipse.sirius.components.view.builder.providers.IColorProvider;
import org.eclipse.sirius.components.view.builder.providers.IRepresentationDescriptionProvider;
import org.eclipse.sirius.components.view.form.ContainerBorderLineStyle;
import org.eclipse.sirius.components.view.form.FlexDirection;
import org.eclipse.sirius.components.view.form.FormElementDescription;
import org.eclipse.sirius.components.view.form.TextfieldDescription;

public class QuestionnaireFormDescriptionProvider implements IRepresentationDescriptionProvider {

    private final FormBuilders formBuilderHelper = new FormBuilders();
    private final ViewBuilders viewBuilderHelper = new ViewBuilders();
    private final ViewUtils viewUtils = new ViewUtils();

    @Override
    public RepresentationDescription create(IColorProvider colorProvider) {
        var formDescription = formBuilderHelper.newFormDescription()
                .name("Form Form Description")
                .domainType("questionnaire::Form")
                .titleExpression("aql:self.name + ' form'")
                .build();

        var pageDescription = formBuilderHelper.newPageDescription()
                .name("Page Description")
                .domainType("questionnaire::Form")
                .semanticCandidatesExpression("aql:self")
                .labelExpression("aql:self.name")
                .build();

        var renderGroupDescription = formBuilderHelper.newGroupDescription()
                .name("Render Group Description")
                .semanticCandidatesExpression("aql:self")
                .build();

        var forEachQuestionDescription = formBuilderHelper.newFormElementFor()
                .iterableExpression("aql:self.elements")
                .iterator("element")
                .name("For Each Elements")
                .build();

        var ifIsQuestionDescription = formBuilderHelper.newFormElementIf()
                .name("If Is Question")
                .predicateExpression("aql:element.oclIsKindOf(questionnaire::Question)")
                .children(getElementDescription(colorProvider, "element", "self"))
                .build();

        var ifIsConditionalGroupDescription = formBuilderHelper.newFormElementIf()
                .name("If Is Conditional Group Description")
                .predicateExpression("aql:element.oclIsKindOf(questionnaire::ConditionalGroup)")
                .children(getFormGroupDescription(colorProvider))
                .build();

        formDescription.getPages().add(pageDescription);
        pageDescription.getGroups().add(renderGroupDescription);
        renderGroupDescription.getChildren().add(forEachQuestionDescription);
        forEachQuestionDescription.getChildren().add(ifIsQuestionDescription);
        forEachQuestionDescription.getChildren().add(ifIsConditionalGroupDescription);
        renderGroupDescription.getChildren().add(this.createButtonDescription("self", true));

        return formDescription;
    }

    public FormElementDescription getElementDescription(IColorProvider colorProvider, String variable, String parent) {
        var questionContainer = formBuilderHelper.newFlexboxContainerDescription()
                .flexDirection(FlexDirection.COLUMN)
                .borderStyle(formBuilderHelper.newContainerBorderStyle()
                        .borderLineStyle(ContainerBorderLineStyle.DASHED)
                        .borderColor(colorProvider.getColor("Questionnaire_Gray"))
                        .build())
                .labelExpression("aql: 'Question ' + " + parent + ".elements->indexOf(" + variable + ") + if " + variable + ".name.size() == 0 then '' else ': ' + " + variable + ".name endif")
                .build();

        var questionNameDescription = formBuilderHelper.newTextfieldDescription()
                .name("Question Name Description")
                .labelExpression("Name")
                .body(viewUtils.textfieldSetter(variable, "name"))
                .valueExpression("aql:" + variable + ".name")
                .diagnosticsExpression("aql: " + variable + ".validateQuestionName()")
                .build();

        var questionTitleDescription = formBuilderHelper.newTextfieldDescription()
                .name("Question Title Description")
                .labelExpression("Title")
                .body(viewUtils.textfieldSetter(variable, "label"))
                .valueExpression("aql:" + variable + ".label")
                .build();

        var isComputedDescription = formBuilderHelper.newCheckboxDescription()
                .name("Is It A Computed Question?")
                .labelExpression("Is it a computed question?")
                .valueExpression("aql: " + variable + ".computedExpression.size() > 0")
                .body(this.viewBuilderHelper.newChangeContext()
                    .expression("aql:" + variable)
                    .children(this.viewBuilderHelper.newSetValue()
                            .valueExpression("aql: if newValue then 'aql: ' else '' endif")
                            .featureName("computedExpression")
                            .build()
                    ).build())
                .build();

        var ifIsComputed = formBuilderHelper.newFormElementIf()
                .name("If Computed Question")
                .predicateExpression("aql: " + variable + ".computedExpression.size() > 0")
                .build();

        var computedExpressionDescription = getAqlField(colorProvider, "Computed expression", "aql: " + variable + ".computedExpression", variable, "computedExpression");
        ifIsComputed.getChildren().add(computedExpressionDescription);

        var selectTypeDescription = formBuilderHelper.newSelectDescription()
                        .name("Type Selector Description")
                        .labelExpression("Type")
                        .candidatesExpression("aql:questionnaire::Form.eContainer().eContents()->select(clazz | clazz.eSuperTypes->includes(questionnaire::Type))")
                        .candidateLabelExpression("aql: candidate.name.replace('Type', '')")
                        .valueExpression("aql: " + variable + ".type.eClass()")
                        .body(viewBuilderHelper.newChangeContext().expression("aql: " + variable + ".newInstance(newValue)").build())
                        .build();

        questionContainer.getChildren().add(questionNameDescription);
        questionContainer.getChildren().add(questionTitleDescription);
        questionContainer.getChildren().add(isComputedDescription);
        questionContainer.getChildren().add(ifIsComputed);
        questionContainer.getChildren().add(selectTypeDescription);
        return questionContainer;
    }

    public FormElementDescription getFormGroupDescription(IColorProvider colorProvider) {
        var conditionalGroupGroupDescription = formBuilderHelper.newFlexboxContainerDescription()
                .flexDirection(FlexDirection.COLUMN)
                .borderStyle(formBuilderHelper.newContainerBorderStyle()
                        .borderLineStyle(ContainerBorderLineStyle.SOLID)
                        .borderColor(colorProvider.getColor("Questionnaire_Black"))
                        .build())
                .labelExpression("aql:'If ' + element.condition")
                .build();

        var conditionDescription = getAqlField(colorProvider, "Group condition", "aql:element.condition", "element", "condition");
//        var conditionDescription = formBuilderHelper.newTextfieldDescription()
//                .name("Condition expression")
//                .labelExpression("Group condition")
//                .valueExpression("aql:element.condition")
//                .body(viewUtils.textfieldSetter("element", "condition"))
//                .style(formBuilderHelper.newTextfieldDescriptionStyle()
//                        .backgroundColor(colorProvider.getColor("Questionnaire_AQL"))
//                        .build())
//                .build();

        var forEachQuestionDescription = formBuilderHelper.newFormElementFor()
                .iterableExpression("aql:element.elements")
                .iterator("element2")
                .name("For Each Elements of a group")
                .children(this.getElementDescription(colorProvider, "element2", "element"))
                .build();

        conditionalGroupGroupDescription.getChildren().add(conditionDescription);
        conditionalGroupGroupDescription.getChildren().add(forEachQuestionDescription);
        conditionalGroupGroupDescription.getChildren().add(this.createButtonDescription("element", false));

        return conditionalGroupGroupDescription;
    }

    public TextfieldDescription getAqlField(IColorProvider colorProvider, String label, String value, String variable, String resultField) {
        return formBuilderHelper.newTextfieldDescription()
                .name(label)
                .labelExpression(label)
                .valueExpression(value)
                .diagnosticsExpression("aql: " + variable + ".validateAqlExpression()")
                .body(viewUtils.textfieldSetter(variable, resultField))
                .style(formBuilderHelper.newTextfieldDescriptionStyle()
                        .backgroundColor(colorProvider.getColor("Questionnaire_AQL"))
                        .build())
                .build();
    }

    public FormElementDescription createButtonDescription(String self, boolean addConditionalGroup) {
        var group = formBuilderHelper.newFlexboxContainerDescription()
                .name("Creation Button Group")
                .flexDirection(FlexDirection.ROW)
                .build();

        var createQuestionButton = formBuilderHelper.newButtonDescription()
                .name("Create Question Button")
                .buttonLabelExpression("new question")
                .body(viewBuilderHelper
                        .newChangeContext()
                        .expression("aql:" + self)
                        .children(
                                viewBuilderHelper
                                    .newCreateInstance()
                                    .referenceName("elements")
                                    .typeName("questionnaire::Question")
                                    .variableName("newQuestion")
                                    .children(viewBuilderHelper
                                            .newChangeContext()
                                            .expression("aql:newQuestion")
                                            .children(viewBuilderHelper
                                                    .newSetValue()
                                                    .featureName("label")
                                                    .valueExpression("New question")
                                                    .build(),
                                                    viewBuilderHelper.newCreateInstance()
                                                    .typeName("questionnaire::StringType")
                                                    .referenceName("type")
                                                    .build())
                                            .build())
                                    .build())
                        .build())
                .build();

        if(addConditionalGroup) {
            var createConditionalGroupButton = formBuilderHelper.newButtonDescription()
                    .name("Create Conditional Group Button")
                    .buttonLabelExpression("new conditional group")
                    .body(viewBuilderHelper
                            .newCreateInstance()
                            .referenceName("elements")
                            .typeName("questionnaire::ConditionalGroup")
                            .build())
                    .build();
            group.getChildren().add(createConditionalGroupButton);
        }

        group.getChildren().add(createQuestionButton);
        return group;
    }

}
