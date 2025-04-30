package org.eclipse.sirius.lwc25.questionnaire.starter.view;

import org.eclipse.sirius.components.view.builder.generated.form.FormBuilders;
import org.eclipse.sirius.components.view.form.FormElementDescription;
import org.eclipse.sirius.components.view.form.FormElementFor;
import org.eclipse.sirius.components.view.form.FormElementIf;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultFormAnswerGenerator implements IFormAnswerGenerator {

    private final FormBuilders formBuilderHelper = new FormBuilders();
    private final ViewUtils viewUtils = new ViewUtils();

    @Override
    public String canHandle() {
        return "true";
    }

    @Override
    public List<FormElementDescription> generateIntegerWidget(String elementExpression, String currentQuestionExpression) {
        return List.of(formBuilderHelper.newTextfieldDescription()
                .name("Integer Question")
                .labelExpression("aql: " + currentQuestionExpression + ".label")
                .valueExpression("aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").answer")
                .body(viewUtils.textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestionExpression + ")", "answer"))
                .diagnosticsExpression("aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").validateValue()")
                .build());
    }

    @Override
    public List<FormElementDescription> generateBooleanWidget(String elementExpression, String currentQuestionExpression) {
        return List.of(formBuilderHelper.newCheckboxDescription()
                .name("Boolean Question")
                .labelExpression("aql: " + currentQuestionExpression + ".label")
                .valueExpression("aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").answer")
                .body(viewUtils.textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestionExpression + ")", "answer"))
                .build());
    }

    @Override
    public List<FormElementDescription> generateDateWidget(String elementExpression, String currentQuestionExpression) {
        return List.of(formBuilderHelper.newDateTimeDescription()
                .name("Date Question")
                .labelExpression("aql: " + currentQuestionExpression + ".label")
                .stringValueExpression("aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").answer")
                .body(viewUtils.textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestionExpression + ")", "answer"))
                .build());
    }

    @Override
    public List<FormElementDescription> generateDecimalWidget(String elementExpression, String currentQuestionExpression) {
        return List.of(formBuilderHelper.newTextfieldDescription()
                .name("Decimal Question")
                .labelExpression("aql: " + currentQuestionExpression + ".label")
                .valueExpression("aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").answer")
                .body(viewUtils.textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestionExpression + ")", "answer"))
                .diagnosticsExpression("aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").validateValue()")
                .build());
    }

    @Override
    public List<FormElementDescription> generateEnumerationWidget(String elementExpression, String currentQuestionExpression) {
        return List.of(formBuilderHelper.newSelectDescription()
                .name("Enumeration Question")
                .labelExpression("aql: " + currentQuestionExpression + ".label")
                .valueExpression("aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").answer")
                .candidatesExpression("aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").question.type.enumerationliteral.name")
                .body(viewUtils.textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestionExpression + ")", "answer"))
                .candidateLabelExpression("aql: candidate")
                .diagnosticsExpression("aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").validateValue()")
                .build());
    }

    @Override
    public List<FormElementDescription> generateStringWidget(String elementExpression, String currentQuestionExpression) {
        return List.of(formBuilderHelper.newTextfieldDescription()
                .name("String Question")
                .labelExpression("aql: " + currentQuestionExpression + ".label")
                .valueExpression("aql: self.answers->any(answer | answer.question = " + currentQuestionExpression + ").answer")
                .body(viewUtils.textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestionExpression + ")", "answer"))
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
                .build());
    }

    @Override
    public FormElementFor generateLoop() {
        return formBuilderHelper.newFormElementFor()
                .name("For Each Questions")
                .iterableExpression("aql: self.eContainer().form.eAllContents()")
                .iterator("it")
                .build();
    }

    @Override
    public String getQuestionFromIteratorExpression() {
        return "it";
    }

    @Override
    public FormElementIf generateDisplayCondition(String elementExpression) {
        return formBuilderHelper.newFormElementIf()
                .name("If The Condition Of The Group Is Valid")
                .predicateExpression("aql: not " + elementExpression + ".mustBeHidden(self)")
                .build();
    }
}
