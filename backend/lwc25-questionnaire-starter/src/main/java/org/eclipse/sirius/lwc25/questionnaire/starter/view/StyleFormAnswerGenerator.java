package org.eclipse.sirius.lwc25.questionnaire.starter.view;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.sirius.components.view.Operation;
import org.eclipse.sirius.components.view.builder.generated.form.FormBuilders;
import org.eclipse.sirius.components.view.form.FormElementDescription;
import org.eclipse.sirius.components.view.form.FormElementFor;
import org.eclipse.sirius.components.view.form.FormElementIf;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Supplier;

@Component
@Order(0)
public class StyleFormAnswerGenerator implements IFormAnswerGenerator {

    private final FormBuilders formBuilderHelper = new FormBuilders();
    private final ViewUtils viewUtils = new ViewUtils();

    @Override
    public String canHandle() {
        return "self.eContainer().form.getStyle() <> null";
    }

    @Override
    public List<FormElementDescription> generateIntegerWidget(String elementExpression, String currentQuestionExpression) {
        var valueExpression = "aql: let result = self.answers->any(answer | answer.question = " + currentQuestionExpression + ").answer in if result.matches('\\\\d+') then result.toInteger() else null endif";
        Supplier<Operation> body = () -> viewUtils.textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestionExpression + ")", "answer");
        var diagnosticExpression = "aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").validateValue()";
        var candidateExpression = "aql: " + currentQuestionExpression + ".type.generateIntList()";

        var ifIsTextfield = formBuilderHelper.newFormElementIf()
                .name("If Integer Textfield")
                .predicateExpression("aql: " + elementExpression + ".widget = qlstyle::Widget::Textfield")
                .build();

        var textfield = formBuilderHelper.newTextfieldDescription()
                .name("Integer Textfield Question")
                .labelExpression("aql: " + currentQuestionExpression + ".label")
                .valueExpression(valueExpression)
                .body(body.get())
                .diagnosticsExpression(diagnosticExpression)
                .helpExpression("aql: " + elementExpression + ".helpText")
                .build();

        var ifIsSelect = formBuilderHelper.newFormElementIf()
                .name("If Integer Select")
                .predicateExpression("aql: " + elementExpression + ".widget = qlstyle::Widget::Select")
                .build();

        var select = formBuilderHelper.newSelectDescription()
                .name("Integer Select Question")
                .labelExpression("aql: " + currentQuestionExpression + ".label")
                .valueExpression(valueExpression)
                .candidatesExpression(candidateExpression)
                .candidateLabelExpression("aql: candidate")
                .body(body.get())
                .helpExpression("aql: " + elementExpression + ".helpText")
                .build();

        var ifIsRadio = formBuilderHelper.newFormElementIf()
                .name("If Integer Radio")
                .predicateExpression("aql: " + elementExpression + ".widget = qlstyle::Widget::Radio")
                .build();

        var radio = formBuilderHelper.newRadioDescription()
                .name("Integer Radio Question")
                .labelExpression("aql: " + currentQuestionExpression + ".label")
                .valueExpression(valueExpression)
                .candidatesExpression(candidateExpression)
                .candidateLabelExpression("aql: candidate")
                .body(body.get())
                .helpExpression("aql: " + elementExpression + ".helpText")
                .build();

        var ifIsSlider = formBuilderHelper.newFormElementIf()
                .name("If Integer Slider")
                .predicateExpression("aql: " + elementExpression + ".widget = qlstyle::Widget::Slider")
                .build();

        var slider = formBuilderHelper.newSliderDescription()
                .name("Integer Slider Question")
                .labelExpression("aql: " + currentQuestionExpression + ".label")
                .currentValueExpression(valueExpression)
                .maxValueExpression("aql:" + currentQuestionExpression + ".type.max")
                .minValueExpression("aql:" + currentQuestionExpression + ".type.min")
                .body(body.get())
                .diagnosticsExpression(diagnosticExpression)
                .helpExpression("aql: " + elementExpression + ".helpText")
                .build();

        ifIsTextfield.getChildren().add(textfield);
        ifIsSelect.getChildren().add(select);
        ifIsRadio.getChildren().add(radio);
        ifIsSlider.getChildren().add(slider);
        return List.of(ifIsTextfield, ifIsSelect, ifIsRadio, ifIsSlider);
    }

    @Override
    public List<FormElementDescription> generateBooleanWidget(String elementExpression, String currentQuestionExpression) {
        var valueExpression = "aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").answer";
        Supplier<Operation> body = () -> viewUtils.textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestionExpression + ")", "answer");
        var candidateExpression = "aql: Sequence{ 'true', 'false' }";

        var ifIsCheckbox = formBuilderHelper.newFormElementIf()
                .name("If Boolean Checkbox")
                .predicateExpression("aql: " + elementExpression + ".widget = qlstyle::Widget::Checkbox")
                .build();

        var checkbox = formBuilderHelper.newCheckboxDescription()
                .name("Boolean Question")
                .labelExpression("aql: " + currentQuestionExpression + ".label")
                .valueExpression(valueExpression + ".toBoolean()")
                .body(body.get())
                .build();

        var ifIsSelect = formBuilderHelper.newFormElementIf()
                .name("If Boolean Select")
                .predicateExpression("aql: " + elementExpression + ".widget = qlstyle::Widget::Select")
                .build();

        var select = formBuilderHelper.newSelectDescription()
                .name("Boolean Select Question")
                .labelExpression("aql: " + currentQuestionExpression + ".label")
                .valueExpression(valueExpression)
                .candidatesExpression(candidateExpression)
                .candidateLabelExpression("aql: candidate")
                .body(body.get())
                .helpExpression("aql: " + elementExpression + ".helpText")
                .build();

        var ifIsRadio = formBuilderHelper.newFormElementIf()
                .name("If Boolean Radio")
                .predicateExpression("aql: " + elementExpression + ".widget = qlstyle::Widget::Radio")
                .build();

        var radio = formBuilderHelper.newRadioDescription()
                .name("Boolean Radio Question")
                .labelExpression("aql: " + currentQuestionExpression + ".label")
                .valueExpression(valueExpression)
                .candidatesExpression(candidateExpression)
                .candidateLabelExpression("aql: candidate")
                .body(body.get())
                .helpExpression("aql: " + elementExpression + ".helpText")
                .build();

        ifIsCheckbox.getChildren().add(checkbox);
        ifIsSelect.getChildren().add(select);
        ifIsRadio.getChildren().add(radio);

        return List.of(ifIsCheckbox, ifIsSelect, ifIsRadio);
    }

    @Override
    public List<FormElementDescription> generateDateWidget(String elementExpression, String currentQuestionExpression) {
        return List.of(formBuilderHelper.newDateTimeDescription()
                .name("Date Question")
                .labelExpression("aql: " + currentQuestionExpression + ".label")
                .stringValueExpression("aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").answer")
                .body(viewUtils.textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestionExpression + ")", "answer", "aql:newValue"))
                .helpExpression("aql: " + elementExpression + ".helpText")
                .build());
    }

    @Override
    public List<FormElementDescription> generateDecimalWidget(String elementExpression, String currentQuestionExpression) {
        return List.of(formBuilderHelper.newTextfieldDescription()
                .name("Decimal Question")
                .labelExpression("aql: " + currentQuestionExpression + ".label")
                .valueExpression("aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").answer")
                .body(viewUtils.textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestionExpression + ")", "answer", "aql:newValue"))
                .diagnosticsExpression("aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").validateValue()")
                .helpExpression("aql: " + elementExpression + ".helpText")
                .build());
    }

    @Override
    public List<FormElementDescription> generateEnumerationWidget(String elementExpression, String currentQuestionExpression) {
        var valueExpression = "aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").answer";
        var candidatesExpression = "aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").question.type.enumerationliteral.name";
        Supplier<Operation> body = () -> viewUtils.textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestionExpression + ")", "answer", "aql:newValue");
        var diagnosticExpression = "aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").validateValue()";

        var ifIsSelect = formBuilderHelper.newFormElementIf()
                .name("If Enumeration Select")
                .predicateExpression("aql: " + elementExpression + ".widget = qlstyle::Widget::Select")
                .build();

        var select = formBuilderHelper.newSelectDescription()
                .name("Enumeration Question")
                .labelExpression("aql: " + currentQuestionExpression + ".label")
                .valueExpression(valueExpression)
                .candidatesExpression(candidatesExpression)
                .body(body.get())
                .candidateLabelExpression("aql: candidate")
                .diagnosticsExpression(diagnosticExpression)
                .helpExpression("aql: " + elementExpression + ".helpText")
                .build();

        var ifIsRadio = formBuilderHelper.newFormElementIf()
                .name("If Enumeration Radio")
                .predicateExpression("aql: " + elementExpression + ".widget = qlstyle::Widget::Radio")
                .build();

        var radio = formBuilderHelper.newRadioDescription()
                .name("Enumeration Question")
                .labelExpression("aql: " + currentQuestionExpression + ".label")
                .valueExpression(valueExpression)
                .candidatesExpression(candidatesExpression)
                .body(body.get())
                .candidateLabelExpression("aql: candidate")
                .diagnosticsExpression(diagnosticExpression)
                .helpExpression("aql: " + elementExpression + ".helpText")
                .build();

        ifIsSelect.getChildren().add(select);
        ifIsRadio.getChildren().add(radio);

        return List.of(ifIsSelect, ifIsRadio);
    }

    @Override
    public List<FormElementDescription> generateStringWidget(String elementExpression, String currentQuestionExpression) {
        return List.of(formBuilderHelper.newTextfieldDescription()
                .name("String Question")
                .labelExpression("aql: " + currentQuestionExpression + ".label")
                .valueExpression("aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").answer")
                .body(viewUtils.textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestionExpression + ")", "answer", "aql:newValue"))
                .helpExpression("aql: " + elementExpression + ".helpText")
                .build());
    }

    @Override
    public List<FormElementDescription> generateMoneyWidget(String elementExpression, String currentQuestionExpression) {
        return List.of(formBuilderHelper.newTextfieldDescription()
                .name("Money Question")
                .labelExpression("aql: " + currentQuestionExpression + ".label")
                .valueExpression("aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").answer + '€'")
                .body(viewUtils.textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestionExpression + ")", "answer", "aql:newValue.toString().replaceAll('€', '')"))
                .diagnosticsExpression("aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").validateValue()")
                .helpExpression("aql: " + elementExpression + ".helpText")
                .build());
    }

    @Override
    public FormElementFor generateLoop() {
        return formBuilderHelper.newFormElementFor()
                .name("For Each Questions")
                .iterableExpression("aql: self.eContainer().form.getStyle().elements")
                .iterator("it")
                .build();
    }

    @Override
    public String getQuestionFromIteratorExpression() {
        return "it.question";
    }

    @Override
    public FormElementIf generateDisplayCondition(String elementExpression) {
        return formBuilderHelper.newFormElementIf()
                .name("If The Condition Of The Group Is Valid")
                .predicateExpression("aql: not " + elementExpression + ".mustBeHidden(self)")
                .build();
    }

    @Override
    public List<FormElementDescription> dispatchType(EClass clazz, String elementExpression, String currentQuestionExpression, boolean isReuse) {
        // We search the style of the reused question to reuse it too
        elementExpression = isReuse ? elementExpression + ".eContainer(qlstyle::QLStyle).eAllContents()->any(style | style.question = " + currentQuestionExpression + ")" : elementExpression;
        return IFormAnswerGenerator.super.dispatchType(clazz, elementExpression, currentQuestionExpression, isReuse);
    }
}
