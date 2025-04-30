package org.eclipse.sirius.lwc25.questionnaire.starter.view;

import org.eclipse.sirius.components.view.RepresentationDescription;
import org.eclipse.sirius.components.view.builder.generated.form.FormBuilders;
import org.eclipse.sirius.components.view.builder.generated.reference.ReferenceWidgetDescriptionBuilder;
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
                .name("Questionnaire Form Description")
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

        var ifIsQuestionReuseDescription = formBuilderHelper.newFormElementIf()
                        .name("If Is Reuse Question Description")
                        .predicateExpression("aql:element.oclIsKindOf(questionnaire::QuestionReuse)")
                        .build();

        var reuseRefDescription = new ReferenceWidgetDescriptionBuilder()
                .referenceOwnerExpression("aql: element")
                .referenceNameExpression("question")
                .body(viewUtils.textfieldSetter("element", "question", "aql:newValue"))
                .labelExpression("aql: 'Question ' + self.elements->indexOf(element) + if element.question.name.size() == 0 then '' else ': reuse of ' + element.question.name endif")
                .build();

        ifIsQuestionReuseDescription.getChildren().add(reuseRefDescription);

        formDescription.getPages().add(pageDescription);
        pageDescription.getGroups().add(renderGroupDescription);
        renderGroupDescription.getChildren().add(forEachQuestionDescription);
        forEachQuestionDescription.getChildren().add(ifIsQuestionDescription);
        forEachQuestionDescription.getChildren().add(ifIsConditionalGroupDescription);
        forEachQuestionDescription.getChildren().add(ifIsQuestionReuseDescription);
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
                .helpExpression("The name of the question. Not displayed to the questionnaire user but can be used in the different expressions as a variable containing the user's answer for this question.")
                .diagnosticsExpression("aql: " + variable + ".validateQuestionName()")
                .build();

        var questionTitleDescription = formBuilderHelper.newTextfieldDescription()
                .name("Question Title Description")
                .labelExpression("Title")
                .body(viewUtils.textfieldSetter(variable, "label"))
                .helpExpression("The label of the question, displayed to the questionnaire user.")
                .valueExpression("aql:" + variable + ".label")
                .build();

        var isComputedDescription = formBuilderHelper.newCheckboxDescription()
                .name("Is It A Computed Question?")
                .labelExpression("Is it a computed question?")
                .valueExpression("aql: " + variable + ".computedExpression.size() > 0")
                .helpExpression("If checked, the question will be displayed as a read-only string resulting of the evaluation of an expression.")
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

        var computedExpressionDescription = getAqlField(colorProvider,
                "Computed expression",
                "aql: " + variable + ".computedExpression", variable,
                "computedExpression",
                "aql: 'An AQL expression to compute the string to display. Available variables: ' + " + variable + ".getScopedVariablesAsString() + '.'"
        );
        ifIsComputed.getChildren().add(computedExpressionDescription);

        var selectTypeDescription = formBuilderHelper.newSelectDescription()
                        .name("Type Selector Description")
                        .labelExpression("Type")
                        .candidatesExpression("aql:questionnaire::Form.eContainer().eContents()->select(clazz | clazz.eSuperTypes->includes(questionnaire::Type))")
                        .candidateLabelExpression("aql: candidate.name.replace('Type', '')")
                        .valueExpression("aql: " + variable + ".type.eClass()")
                        .helpExpression("The type of the expected answer. Enables validations for the answer and determine the widget to use.")
                        .body(viewBuilderHelper.newChangeContext().expression("aql: " + variable + ".newInstance(newValue)").build())
                        .build();

        var ifIsIntegerType = formBuilderHelper.newFormElementIf()
                        .name("If Is Integer Question")
                        .predicateExpression("aql: " + variable + ".type.oclIsKindOf(questionnaire::IntegerType)")
                        .build();

        var minBoundDescription = formBuilderHelper.newTextfieldDescription()
                        .name("Min Bound Description")
                        .labelExpression("Min bound")
                        .valueExpression("aql: " + variable + ".type.min.toString()")
                        .helpExpression("The user's answer must be greater than or equal to this number.")
                        .diagnosticsExpression("aql: " + variable + ".type.validateIntType()")
                        .body(viewBuilderHelper.newIf()
                                .conditionExpression("aql: newValue.size() = 0")
                                .children(viewBuilderHelper.newChangeContext()
                                        .expression("aql: " + variable + ".type")
                                            .children(viewBuilderHelper.newUnsetValue()
                                            .featureName("min")
                                            .elementExpression("aql: self.min")
                                        .build())
                                .build())
                                .build(),
                                viewBuilderHelper.newIf()
                                        .conditionExpression("aql: newValue.size() > 0")
                                        .children(viewUtils.textfieldSetter(variable + ".type", "min", "aql: newValue.toInteger()"))
                                        .build())
                        .build();

        var maxBoundDescription = formBuilderHelper.newTextfieldDescription()
                .name("Max Bound Description")
                .labelExpression("Max bound")
                .valueExpression("aql: " + variable + ".type.max.toString()")
                .helpExpression("The user's answer must be lower than or equal to this number.")
                .body(viewBuilderHelper.newIf()
                                .conditionExpression("aql: newValue.size() = 0")
                                .children(viewBuilderHelper.newChangeContext()
                                        .expression("aql: " + variable + ".type")
                                        .children(viewBuilderHelper.newUnsetValue()
                                                .featureName("max")
                                                .elementExpression("aql: self.max")
                                                .build())
                                        .build())
                                .build(),
                        viewBuilderHelper.newIf()
                                .conditionExpression("aql: newValue.size() > 0")
                                .children(viewUtils.textfieldSetter(variable + ".type", "max", "aql: newValue.toInteger()"))
                                .build())
                .build();

        ifIsIntegerType.getChildren().add(minBoundDescription);
        ifIsIntegerType.getChildren().add(maxBoundDescription);

        var ifIsEnumerationType = formBuilderHelper.newFormElementIf()
                .name("If Is Enumeration Question")
                .predicateExpression("aql: " + variable + ".type.oclIsKindOf(questionnaire::EnumerationType)")
                .build();

        var literalsLabelDescription = formBuilderHelper.newLabelDescription()
                .labelExpression("Possible values:")
                .build();

        var forEachLiteral = formBuilderHelper.newFormElementFor()
                .name("For Each Literal")
                .iterableExpression("aql: " + variable + ".type.enumerationliteral")
                .iterator("literal")
                .build();

        var literalFlexbox = formBuilderHelper.newFlexboxContainerDescription()
                .labelExpression("aql: 'Literal ' + literal.eContainer().enumerationliteral->indexOf(literal)")
                .name("Horizontal Layout")
                .build();

        var literalTextFieldDescription = formBuilderHelper.newTextfieldDescription()
                .name("Literal Description")
                .valueExpression("aql: literal.name")
                .body(viewUtils.textfieldSetter("literal", "name"))
                .build();

        var deleteLiteralDescription = formBuilderHelper.newButtonDescription()
                .name("Delete Literal")
                .imageExpression("aql:'/icons/questionnaire/trash.svg'")
                .body(viewBuilderHelper.newChangeContext()
                        .expression("aql: literal.eContainer()")
                        .children(viewBuilderHelper.newUnsetValue()
                                .featureName("enumerationliteral")
                                .elementExpression("aql: literal")
                                .build())
                        .build())
                .style(formBuilderHelper.newButtonDescriptionStyle()
                        .backgroundColor(colorProvider.getColor("Questionnaire_White"))
                        .build())
                .build();

        literalFlexbox.getChildren().add(literalTextFieldDescription);
        literalFlexbox.getChildren().add(deleteLiteralDescription);

        var newLiteralButtonDescription = formBuilderHelper.newButtonDescription()
                        .name("New Literal")
                        .buttonLabelExpression("Add value")
                                .body(viewBuilderHelper.newChangeContext()
                                        .expression("aql: " + variable + ".type")
                                        .children(viewBuilderHelper.newCreateInstance()
                                                .typeName("questionnaire::EnumerationLiteral")
                                                .referenceName("enumerationliteral")
                                                .build())
                                        .build())
                        .build();

        ifIsEnumerationType.getChildren().add(literalsLabelDescription);
        ifIsEnumerationType.getChildren().add(forEachLiteral);
        forEachLiteral.getChildren().add(literalFlexbox);
        ifIsEnumerationType.getChildren().add(newLiteralButtonDescription);

        var deleteQuestionButtonDescription = formBuilderHelper.newButtonDescription()
                .name("Delete question")
                .imageExpression("aql:'/icons/questionnaire/trash.svg'")
                .body(viewBuilderHelper.newChangeContext()
                        .expression("aql: " + variable + ".eContainer()")
                        .children(viewBuilderHelper.newUnsetValue()
                                .featureName("elements")
                                .elementExpression("aql: " + variable)
                                .build())
                        .build())
                .style(formBuilderHelper.newButtonDescriptionStyle()
                        .backgroundColor(colorProvider.getColor("Questionnaire_White"))
                        .build())
                .build();

        questionContainer.getChildren().add(questionNameDescription);
        questionContainer.getChildren().add(questionTitleDescription);
        questionContainer.getChildren().add(isComputedDescription);
        questionContainer.getChildren().add(ifIsComputed);
        questionContainer.getChildren().add(selectTypeDescription);
        questionContainer.getChildren().add(ifIsIntegerType);
        questionContainer.getChildren().add(ifIsEnumerationType);
        questionContainer.getChildren().add(deleteQuestionButtonDescription);
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

        var conditionDescription = getAqlField(colorProvider,
                "Group condition",
                "aql:element.condition",
                "element",
                "condition",
                "aql: 'An AQL expression determining whether the questions of the block are displayed to the questionnaire user. Available variables: ' + element.getScopedVariablesAsString() + '.'"
        );

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

    public TextfieldDescription getAqlField(IColorProvider colorProvider, String label, String value, String variable, String resultField, String helpExpression) {
        return formBuilderHelper.newTextfieldDescription()
                .name(label)
                .labelExpression(label)
                .valueExpression(value)
                .helpExpression(helpExpression)
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

        group.getChildren().add(createQuestionButton);

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

        var createQuestionReuseButton = formBuilderHelper.newButtonDescription()
                .name("Create Question Reuse Button")
                .buttonLabelExpression("reuse question")
                .body(viewBuilderHelper
                        .newCreateInstance()
                        .referenceName("elements")
                        .typeName("questionnaire::QuestionReuse")
                        .build())
                .build();
        group.getChildren().add(createQuestionReuseButton);

        return group;
    }

}
