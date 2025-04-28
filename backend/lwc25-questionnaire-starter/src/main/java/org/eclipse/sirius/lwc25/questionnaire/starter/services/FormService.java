package org.eclipse.sirius.lwc25.questionnaire.starter.services;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.sirius.ecore.extender.business.internal.accessor.ecore.EcoreIntrinsicExtender;
import org.eclipse.sirius.lwc25.questionnaire.starter.helper.QuestionnaireUtils;
import org.eclipse.sirius.questionnaire.ConditionalGroup;
import org.eclipse.sirius.questionnaire.IntegerType;
import org.eclipse.sirius.questionnaire.Question;
import org.eclipse.sirius.questionnaire.QuestionnaireElement;

import java.util.stream.Collectors;

public class FormService {

    private final ValidationService validator;

    public FormService(ValidationService validator) {
        this.validator = validator;
    }

    public Question newInstance(Question question, EClass type) {
        var extender = new EcoreIntrinsicExtender();
        var newInstance = extender.createInstance(type);
        extender.eAdd(question, "type", newInstance);
        return question;
    }

    public Diagnostic validateQuestionName(Question question) {
        return validator.validateQuestionName(question).orElse(null);
    }

    public String getScopedVariablesAsString(QuestionnaireElement element) {
        return QuestionnaireUtils.getScopedVariables(element).stream().map(Question::getName).collect(Collectors.joining(", "));
    }

    public Diagnostic validateAqlExpression(QuestionnaireElement element) {
        String expression = null;
        String feature = null;
        String expectedType = null;
        if(element instanceof Question question) {
            expression = question.getComputedExpression();
            feature = "computedExpression";
        } else if(element instanceof ConditionalGroup group) {
            expression = group.getCondition();
            feature = "condition";
            expectedType = Boolean.class.getSimpleName();
        }
        return validator.validateAqlExpression(element, expression, feature, expectedType)
                .stream().reduce((diag1, diag2) -> { diag1.getChildren().add(diag2); return diag1; }).orElse(null);
    }

    public Diagnostic validateIntType(IntegerType type) {
        return validator.validateIntType(type).orElse(null);
    }
}
