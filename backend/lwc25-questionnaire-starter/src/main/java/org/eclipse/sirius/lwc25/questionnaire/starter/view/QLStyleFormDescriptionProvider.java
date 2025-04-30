package org.eclipse.sirius.lwc25.questionnaire.starter.view;

import org.eclipse.sirius.components.view.RepresentationDescription;
import org.eclipse.sirius.components.view.builder.generated.form.FormBuilders;
import org.eclipse.sirius.components.view.builder.generated.reference.ReferenceWidgetDescriptionBuilder;
import org.eclipse.sirius.components.view.builder.generated.reference.ReferenceWidgetDescriptionStyleBuilder;
import org.eclipse.sirius.components.view.builder.generated.view.ViewBuilders;
import org.eclipse.sirius.components.view.builder.providers.IColorProvider;
import org.eclipse.sirius.components.view.builder.providers.IRepresentationDescriptionProvider;
import org.eclipse.sirius.components.view.form.ContainerBorderLineStyle;
import org.eclipse.sirius.components.view.form.FlexDirection;
import org.eclipse.sirius.components.view.form.FormElementDescription;

public class QLStyleFormDescriptionProvider implements IRepresentationDescriptionProvider {

    public static String LABEL = "Questionnaire Style Form Description";

    private final FormBuilders formBuilderHelper = new FormBuilders();
    private final ViewBuilders viewBuilderHelper = new ViewBuilders();
    private final ViewUtils viewUtils = new ViewUtils();

    @Override
    public RepresentationDescription create(IColorProvider colorProvider) {
        var formDescription = formBuilderHelper.newFormDescription()
                .name(LABEL)
                .domainType("qlstyle::QLStyle")
                .titleExpression("aql:self.form.name + ' answer form'")
                .build();

        var pageDescription = formBuilderHelper.newPageDescription()
                .name("Page Description")
                .domainType("qlstyle::QLStyle")
                .semanticCandidatesExpression("aql:self")
                .labelExpression("aql:self.form.name")
                .build();

        var renderGroupDescription = formBuilderHelper.newGroupDescription()
                .name("Render Group Description")
                .semanticCandidatesExpression("aql:self")
                .build();

        var ifNotLinked = formBuilderHelper.newFormElementIf()
                .predicateExpression("aql: self.form = null or self.elements->isEmpty()")
                .build();

        var formReferenceWidget = new ReferenceWidgetDescriptionBuilder()
                .labelExpression("Questionnaire to stylize")
                .referenceNameExpression("form")
                .referenceOwnerExpression("aql: self")
                .name("Reference To Form To Stylize")
                .build();

        var initButton = formBuilderHelper.newButtonDescription()
                .name("Init Model")
                .buttonLabelExpression("aql: (if self.elements->isEmpty() then 'Init' else 'Refresh' endif) + ' from questionnaire'")
                .isEnabledExpression("aql: self.form <> null")
                .body(viewBuilderHelper.newChangeContext().expression("aql: self.init()").build())
                .build();

        ifNotLinked.getChildren().add(formReferenceWidget);

        var forQuestionsDescription = formBuilderHelper.newFormElementFor()
                .name("For Each Style")
                .iterableExpression("aql: self.elements")
                .iterator("element")
                .build();

        var ifIsQuestion = formBuilderHelper.newFormElementIf()
                .name("If Element Is Question")
                .predicateExpression("aql: element.oclIsKindOf(qlstyle::QuestionCustomization)")
                .children(getStyleDescriptions("element", colorProvider))
                .build();

        formDescription.getPages().add(pageDescription);
        pageDescription.getGroups().add(renderGroupDescription);
        renderGroupDescription.getChildren().add(ifNotLinked);
        renderGroupDescription.getChildren().add(forQuestionsDescription);
        forQuestionsDescription.getChildren().add(ifIsQuestion);
        renderGroupDescription.getChildren().add(initButton);

        return formDescription;
    }

    private FormElementDescription getStyleDescriptions(String currentStyle, IColorProvider colorProvider) {

        var questionGroup = formBuilderHelper.newFlexboxContainerDescription()
                .labelExpression("aql: 'Style ' + self.elements->indexOf(element)")
                .flexDirection(FlexDirection.COLUMN)
                .borderStyle(formBuilderHelper.newContainerBorderStyle()
                        .borderLineStyle(ContainerBorderLineStyle.DASHED)
                        .borderColor(colorProvider.getColor("Questionnaire_Gray"))
                        .build())
                .build();

        var upButton = formBuilderHelper.newButtonDescription()
                .imageExpression("aql:'/icons/questionnaire/backward.svg'")
                .name("Move Element backward")
                .body(viewBuilderHelper.newChangeContext().expression("aql: " + currentStyle + ".moveBackward()").build())
                .isEnabledExpression("aql: " + currentStyle + ".canMoveBackward()")
                .build();

        var downButton = formBuilderHelper.newButtonDescription()
                .imageExpression("aql:'/icons/questionnaire/forward.svg'")
                .name("Move Element Forward")
                .body(viewBuilderHelper.newChangeContext().expression("aql: " + currentStyle + ".moveForward()").build())
                .isEnabledExpression("aql: " + currentStyle + ".canMoveForward()")
                .build();

        var controlGroup = formBuilderHelper.newFlexboxContainerDescription()
                .flexDirection(FlexDirection.ROW)
                .children(upButton, downButton)
                .build();

        var ifIsQuestion = formBuilderHelper.newFormElementIf()
                .predicateExpression("aql: " + currentStyle + ".question.oclIsKindOf(questionnaire::Question)")
                .children(getQuestionStyleDescription(currentStyle, colorProvider))
                .build();

        var ifIsQuestionReuse = formBuilderHelper.newFormElementIf()
                .predicateExpression("aql: " + currentStyle + ".question.oclIsKindOf(questionnaire::QuestionReuse)")
                .children(getQuestionReuseStyleDescription(currentStyle))
                .build();


        questionGroup.getChildren().add(controlGroup);
        questionGroup.getChildren().add(ifIsQuestion);
        questionGroup.getChildren().add(ifIsQuestionReuse);

        return questionGroup;
    }

    private FormElementDescription getQuestionReuseStyleDescription(String currentStyle) {
        var questionTitle = formBuilderHelper.newLabelDescription()
                .valueExpression("aql: 'Reuse of ' + " + currentStyle + ".question.question.name")
                .style(formBuilderHelper.newLabelDescriptionStyle().bold(true).fontSize(16).build())
                .build();

        return formBuilderHelper.newFlexboxContainerDescription()
                .flexDirection(FlexDirection.COLUMN)
                .children(questionTitle)
                .build();
    }

    private FormElementDescription getQuestionStyleDescription(String currentStyle, IColorProvider colorProvider) {
        var contentGroup = formBuilderHelper.newFlexboxContainerDescription()
                .flexDirection(FlexDirection.COLUMN)
                .build();

        var questionTitle = formBuilderHelper.newLabelDescription()
                .valueExpression("aql: if " + currentStyle + ".question.computedExpression.size() > 0 then 'Computed ' else '' endif + 'Question: ' + " + currentStyle + ".question.name")
                .style(formBuilderHelper.newLabelDescriptionStyle().bold(true).fontSize(16).build())
                .build();

        var helpTextfield = formBuilderHelper.newTextfieldDescription()
                .labelExpression("Tooltip")
                .valueExpression("aql: " + currentStyle + ".helpText")
                .body(viewUtils.textfieldSetter(currentStyle, "helpText"))
                .build();

        contentGroup.getChildren().add(questionTitle);
        contentGroup.getChildren().add(helpTextfield);

        var resultGroup = formBuilderHelper.newFlexboxContainerDescription()
                .flexDirection(FlexDirection.COLUMN)
                .labelExpression("Render")
                .borderStyle(formBuilderHelper.newContainerBorderStyle()
                        .borderLineStyle(ContainerBorderLineStyle.SOLID)
                        .borderColor(colorProvider.getColor("Questionnaire_Gray"))
                        .build())
                .build();

        var ifCanChooseWidget = formBuilderHelper.newFormElementIf()
                .name("If Can Choose Widget")
                .predicateExpression("aql: " + currentStyle + ".question.type.canChangeWidget()")
                .build();

        var widgetSelector = formBuilderHelper.newSelectDescription()
                .valueExpression("aql: " + currentStyle + ".widget")
                .candidatesExpression("aql: " + currentStyle + ".question.type.getAvailableWidgets()")
                .candidateLabelExpression("aql: candidate")
                .body(viewUtils.textfieldSetter(currentStyle, "widget"))
                .labelExpression("aql: 'Select widget for ' + " + currentStyle + ".question.label")
                .build();

        ifCanChooseWidget.getChildren().add(widgetSelector);

        var ifIsNotComputed = formBuilderHelper.newFormElementIf()
                .name("If Question Is Not Computed")
                .predicateExpression("aql: " + currentStyle + ".question.computedExpression.size() = 0")
                .build();

        var ifIsTextfield = formBuilderHelper.newFormElementIf()
                .name("If Element Is Displayed As Textfield")
                .predicateExpression("aql: " + currentStyle + ".widget = qlstyle::Widget::Textfield")
                .build();

        var stringTextfieldDescription = formBuilderHelper.newTextfieldDescription()
                .name("String Question")
                .labelExpression("aql: " + currentStyle + ".question.label")
                .isEnabledExpression("aql: false")
                .build();

        var ifIsCheckbox = formBuilderHelper.newFormElementIf()
                .name("If Element Is Displayed As Checkbox")
                .predicateExpression("aql: " + currentStyle + ".widget = qlstyle::Widget::Checkbox")
                .build();

        var booleanCheckboxDescription = formBuilderHelper.newCheckboxDescription()
                .name("Boolean Question")
                .labelExpression("aql: " + currentStyle + ".question.label")
                .isEnabledExpression("aql: false")
                .build();

        var ifIsSelect = formBuilderHelper.newFormElementIf()
                .name("If Element Is Displayed As Select")
                .predicateExpression("aql: " + currentStyle + ".widget = qlstyle::Widget::Select")
                .build();

        var ifIsEnumeration = formBuilderHelper.newFormElementIf()
                .name("If Element Is Enumeration Question")
                .predicateExpression("aql: " + currentStyle + ".question.type.oclIsKindOf(questionnaire::EnumerationType)")
                .build();

        var enumerationSelectDescription = formBuilderHelper.newSelectDescription()
                .name("Enumeration Question Select")
                .labelExpression("aql: " + currentStyle + ".question.label")
                .candidatesExpression("aql: " + currentStyle + ".question.type.enumerationliteral.name")
                .candidateLabelExpression("aql: candidate")
                .build();

        ifIsEnumeration.getChildren().add(enumerationSelectDescription);

        var ifIsBoolean = formBuilderHelper.newFormElementIf()
                .name("If Element Is Boolean Question")
                .predicateExpression("aql: " + currentStyle + ".question.type.oclIsKindOf(questionnaire::BooleanType)")
                .build();

        var booleanSelectDescription = formBuilderHelper.newSelectDescription()
                .name("Boolean Question Select")
                .labelExpression("aql: " + currentStyle + ".question.label")
                .candidatesExpression("aql: Sequence{'true', 'false'}")
                .candidateLabelExpression("aql: candidate")
                .build();

        ifIsBoolean.getChildren().add(booleanSelectDescription);

        var ifIsBoundedInteger = formBuilderHelper.newFormElementIf()
                .name("If Element Is Bounded Integer Question")
                .predicateExpression("aql: " + currentStyle + ".question.type.oclIsKindOf(questionnaire::IntegerType)")
                .build();

        var boundedIntegerSelectDescription = formBuilderHelper.newSelectDescription()
                .name("Integer Question Select")
                .labelExpression("aql: " + currentStyle + ".question.label")
                .candidatesExpression("aql: " + currentStyle + ".question.type.generateIntList()")
                .candidateLabelExpression("aql: candidate.toString()")
                .build();

        ifIsBoundedInteger.getChildren().add(boundedIntegerSelectDescription);

        ifIsSelect.getChildren().add(ifIsEnumeration);
        ifIsSelect.getChildren().add(ifIsBoolean);
        ifIsSelect.getChildren().add(ifIsBoundedInteger);

        var ifIsRadio = formBuilderHelper.newFormElementIf()
                .name("If Element Is Displayed As Radio")
                .predicateExpression("aql: " + currentStyle + ".widget = qlstyle::Widget::Radio")
                .build();

        var ifIsEnumerationRadio = formBuilderHelper.newFormElementIf()
                .name("If Element Is Enumeration Question Radio")
                .predicateExpression("aql: " + currentStyle + ".question.type.oclIsKindOf(questionnaire::EnumerationType)")
                .build();

        var enumerationRadioDescription = formBuilderHelper.newRadioDescription()
                .name("Enumeration Question Select Radio")
                .labelExpression("aql: " + currentStyle + ".question.label")
                .candidatesExpression("aql: " + currentStyle + ".question.type.enumerationliteral.name")
                .candidateLabelExpression("aql: candidate")
                .build();

        ifIsEnumerationRadio.getChildren().add(enumerationRadioDescription);

        var ifIsBooleanRadio = formBuilderHelper.newFormElementIf()
                .name("If Element Is Boolean Question Radio")
                .predicateExpression("aql: " + currentStyle + ".question.type.oclIsKindOf(questionnaire::BooleanType)")
                .build();

        var booleanRadioDescription = formBuilderHelper.newRadioDescription()
                .name("Boolean Question Select")
                .labelExpression("aql: " + currentStyle + ".question.label")
                .candidatesExpression("aql: Sequence{'true', 'false'}")
                .candidateLabelExpression("aql: candidate")
                .build();

        ifIsBooleanRadio.getChildren().add(booleanRadioDescription);

        var ifIsBoundedIntegerRadio = formBuilderHelper.newFormElementIf()
                .name("If Element Is Bounded Integer Question Radio")
                .predicateExpression("aql: " + currentStyle + ".question.type.oclIsKindOf(questionnaire::IntegerType)")
                .build();

        var boundedIntegerRadioDescription = formBuilderHelper.newRadioDescription()
                .name("Integer Question Select")
                .labelExpression("aql: " + currentStyle + ".question.label")
                .candidatesExpression("aql: " + currentStyle + ".question.type.generateIntList()")
                .candidateLabelExpression("aql: candidate.toString()")
                .isEnabledExpression("aql: false")
                .build();

        ifIsBoundedIntegerRadio.getChildren().add(boundedIntegerRadioDescription);

        ifIsRadio.getChildren().add(ifIsEnumerationRadio);
        ifIsRadio.getChildren().add(ifIsBooleanRadio);
        ifIsRadio.getChildren().add(ifIsBoundedIntegerRadio);

        var ifIsSlider = formBuilderHelper.newFormElementIf()
                .name("If Element Is Displayed As Slider")
                .predicateExpression("aql: " + currentStyle + ".widget = qlstyle::Widget::Slider")
                .build();

        var ifIsBoundedIntegerSlider = formBuilderHelper.newFormElementIf()
                .name("If Element Is Bounded Integer Question Slider")
                .predicateExpression("aql: " + currentStyle + ".question.type.oclIsKindOf(questionnaire::IntegerType)")
                .build();

        var boundedIntegerSliderDescription = formBuilderHelper.newSliderDescription()
                .name("Integer Question Slider")
                .labelExpression("aql: " + currentStyle + ".question.label")
                .minValueExpression("aql: " + currentStyle + ".question.type.min")
                .maxValueExpression("aql: " + currentStyle + ".question.type.max")
                .currentValueExpression("aql: (" + currentStyle + ".question.type.max - " + currentStyle + ".question.type.min) / 2 + " + currentStyle + ".question.type.min")
                .build();

        ifIsBoundedIntegerSlider.getChildren().add(boundedIntegerSliderDescription);

        ifIsSlider.getChildren().add(ifIsBoundedIntegerSlider);

        var ifIsDate = formBuilderHelper.newFormElementIf()
                .name("If Element Is Date Question")
                .predicateExpression("aql: " + currentStyle + ".question.type.oclIsKindOf(questionnaire::DateType)")
                .build();

        var dateDatePickerDescription = formBuilderHelper.newDateTimeDescription()
                .name("Date Question")
                .labelExpression("aql: " + currentStyle + ".question.label")
                .isEnabledExpression("aql: false")
                .build();

        var ifIsComputed = formBuilderHelper.newFormElementIf()
                .name("If Question Is Computed")
                .predicateExpression("aql: " + currentStyle + ".question.computedExpression.size() > 0")
                .build();

        var displayComputedQuestion = formBuilderHelper.newLabelDescription()
                .name("Computed Expression")
                .labelExpression("aql:" + currentStyle + ".label")
                .valueExpression("computed value")
                .build();

        ifIsComputed.getChildren().add(displayComputedQuestion);
        ifIsTextfield.getChildren().add(stringTextfieldDescription);
        ifIsCheckbox.getChildren().add(booleanCheckboxDescription);
        ifIsDate.getChildren().add(dateDatePickerDescription);
        ifIsNotComputed.getChildren().add(ifCanChooseWidget);
        ifIsNotComputed.getChildren().add(resultGroup);
        resultGroup.getChildren().add(ifIsTextfield);
        resultGroup.getChildren().add(ifIsCheckbox);
        resultGroup.getChildren().add(ifIsSelect);
        resultGroup.getChildren().add(ifIsSlider);
        resultGroup.getChildren().add(ifIsRadio);
        resultGroup.getChildren().add(ifIsDate);
        contentGroup.getChildren().add(ifIsNotComputed);

        return contentGroup;
    }
}
