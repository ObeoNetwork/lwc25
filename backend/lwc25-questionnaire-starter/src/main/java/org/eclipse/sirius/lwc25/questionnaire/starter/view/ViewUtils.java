package org.eclipse.sirius.lwc25.questionnaire.starter.view;

import org.eclipse.sirius.components.view.Operation;
import org.eclipse.sirius.components.view.builder.generated.form.FormBuilders;
import org.eclipse.sirius.components.view.builder.generated.view.ViewBuilders;
import org.eclipse.sirius.components.view.form.FormElementDescription;

import java.util.List;

public class ViewUtils {

    private final ViewBuilders viewBuilderHelper = new ViewBuilders();
    private final FormBuilders formBuilderHelper = new FormBuilders();

    public Operation textfieldSetter(String self, String resultRef, String valueExpression) {
        return this.viewBuilderHelper.newChangeContext()
                .expression("aql:" + self)
                .children(this.viewBuilderHelper.newSetValue()
                        .valueExpression(valueExpression)
                        .featureName(resultRef)
                        .build()
                )
                .build();
    }

    public Operation textfieldSetter(String self, String resultRef) {
        return textfieldSetter(self, resultRef, "aql:newValue.toString()");
    }

    public FormElementDescription getComputedQuestionDescription(String currentQuestion) {
        var ifIsComputed = formBuilderHelper.newFormElementIf()
                .name("If Question Is Computed")
                .predicateExpression("aql: " + currentQuestion + ".computedExpression.size() > 0")
                .build();

        var displayComputedQuestion = formBuilderHelper.newLabelDescription()
                .name("Computed Expression")
                .labelExpression("aql:" + currentQuestion + ".label")
                .valueExpression("aql: " + currentQuestion + ".evaluate(self)")
                .build();

        ifIsComputed.getChildren().add(displayComputedQuestion);

        return ifIsComputed;
    }

    public FormElementDescription getQuestionDescriptions(String currentQuestion) {
        var ifIsNotComputed = formBuilderHelper.newFormElementIf()
                .name("If Question Is Not Computed")
                .predicateExpression("aql: " + currentQuestion + ".computedExpression.size() = 0")
                .build();

        var ifThereIsAnAnswer = formBuilderHelper.newFormElementIf()
                .name("If There Is An Answer For The Question")
                .predicateExpression("aql: self.answers->exists(answer | answer.question = " + currentQuestion + ")")
                .build();

        var ifIsString = formBuilderHelper.newFormElementIf()
                .name("If Element Is String Question")
                .predicateExpression("aql: " + currentQuestion + ".type.oclIsKindOf(questionnaire::StringType)")
                .build();

        var stringTextfieldDescription = formBuilderHelper.newTextfieldDescription()
                .name("String Question")
                .labelExpression("aql: " + currentQuestion + ".label")
                .valueExpression("aql: self.answers->any(answer | answer.question = " + currentQuestion + ").answer")
                .body(textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestion + ")", "answer"))
                .build();

        var ifIsBoolean = formBuilderHelper.newFormElementIf()
                .name("If Element Is Boolean Question")
                .predicateExpression("aql: " + currentQuestion + ".type.oclIsKindOf(questionnaire::BooleanType)")
                .build();

        var booleanCheckboxDescription = formBuilderHelper.newCheckboxDescription()
                .name("Boolean Question")
                .labelExpression("aql: " + currentQuestion + ".label")
                .valueExpression("aql: self.answers->any(answer | answer.question = " + currentQuestion + ").answer")
                .body(textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestion + ")", "answer"))
                .build();

        var ifIsInteger = formBuilderHelper.newFormElementIf()
                .name("If Element Is Integer Question")
                .predicateExpression("aql: " + currentQuestion + ".type.oclIsKindOf(questionnaire::IntegerType)")
                .build();

        var integerTextfieldDescription = formBuilderHelper.newTextfieldDescription()
                .name("Integer Question")
                .labelExpression("aql: " + currentQuestion + ".label")
                .valueExpression("aql: self.answers->any(answer | answer.question = " + currentQuestion + ").answer")
                .body(textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestion + ")", "answer"))
                .diagnosticsExpression("aql: self.answers->any(answer | answer.question = " + currentQuestion + ").validateValue()")
                .build();

        var ifIsDecimal = formBuilderHelper.newFormElementIf()
                .name("If Element Is Decimal Question")
                .predicateExpression("aql: " + currentQuestion + ".type.oclIsKindOf(questionnaire::DecimalType)")
                .build();

        var decimalTextfieldDescription = formBuilderHelper.newTextfieldDescription()
                .name("Decimal Question")
                .labelExpression("aql: " + currentQuestion + ".label")
                .valueExpression("aql: self.answers->any(answer | answer.question = " + currentQuestion + ").answer")
                .body(textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestion + ")", "answer"))
                .diagnosticsExpression("aql: self.answers->any(answer | answer.question = " + currentQuestion + ").validateValue()")
                .build();

        var ifIsDate = formBuilderHelper.newFormElementIf()
                .name("If Element Is Date Question")
                .predicateExpression("aql: " + currentQuestion + ".type.oclIsKindOf(questionnaire::DateType)")
                .build();

        var dateDatePickerDescription = formBuilderHelper.newDateTimeDescription()
                .name("Date Question")
                .labelExpression("aql: " + currentQuestion + ".label")
                .stringValueExpression("aql: self.answers->any(answer | answer.question = " + currentQuestion + ").answer")
                .body(textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestion + ")", "answer"))
                .build();

        var ifIsMoney = formBuilderHelper.newFormElementIf()
                .name("If Element Is Money Question")
                .predicateExpression("aql: " + currentQuestion + ".type.oclIsKindOf(questionnaire::MoneyType)")
                .build();

        var moneyTextfieldDescription = formBuilderHelper.newTextfieldDescription()
                .name("Money Question")
                .labelExpression("aql: " + currentQuestion + ".label")
                .valueExpression("aql: self.answers->any(answer | answer.question = " + currentQuestion + ").answer + '€'")
                .body(textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestion + ")", "answer", "aql:newValue.toString().replaceAll('€', '')"))
                .diagnosticsExpression("aql: self.answers->any(answer | answer.question = " + currentQuestion + ").validateValue()")
                .build();

        var ifIsEnumeration = formBuilderHelper.newFormElementIf()
                .name("If Element Is Enumeration Question")
                .predicateExpression("aql: " + currentQuestion + ".type.oclIsKindOf(questionnaire::EnumerationType)")
                .build();

        var enumerationSelectDescription = formBuilderHelper.newSelectDescription()
                .name("Enumeration Question")
                .labelExpression("aql: " + currentQuestion + ".label")
                .valueExpression("aql: self.answers->any(answer | answer.question = " + currentQuestion + ").answer")
                .candidatesExpression("aql: self.answers->any(answer | answer.question = " + currentQuestion + ").question.type.enumerationliteral.name")
                .body(textfieldSetter("self.answers->any(answer | answer.question = " + currentQuestion + ")", "answer"))
                .candidateLabelExpression("aql: candidate")
                .diagnosticsExpression("aql: self.answers->any(answer | answer.question = " + currentQuestion + ").validateValue()")
                .build();

        ifIsString.getChildren().add(stringTextfieldDescription);
        ifIsBoolean.getChildren().add(booleanCheckboxDescription);
        ifIsInteger.getChildren().add(integerTextfieldDescription);
        ifIsDecimal.getChildren().add(decimalTextfieldDescription);
        ifIsDate.getChildren().add(dateDatePickerDescription);
        ifIsMoney.getChildren().add(moneyTextfieldDescription);
        ifIsEnumeration.getChildren().add(enumerationSelectDescription);
        ifThereIsAnAnswer.getChildren().add(ifIsString);
        ifThereIsAnAnswer.getChildren().add(ifIsBoolean);
        ifThereIsAnAnswer.getChildren().add(ifIsInteger);
        ifThereIsAnAnswer.getChildren().add(ifIsDecimal);
        ifThereIsAnAnswer.getChildren().add(ifIsDate);
        ifThereIsAnAnswer.getChildren().add(ifIsMoney);
        ifThereIsAnAnswer.getChildren().add(ifIsEnumeration);
        ifIsNotComputed.getChildren().add(ifThereIsAnAnswer);

        return ifThereIsAnAnswer;
    }

}
