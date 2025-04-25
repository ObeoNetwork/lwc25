package org.eclipse.sirius.lwc25.questionnaire.starter.validation;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.sirius.answer.Answer;
import org.eclipse.sirius.lwc25.questionnaire.starter.services.ValidationService;

import java.util.Map;

public class UserAnswerValidator implements EValidator {

    private final ValidationService validator;

    public UserAnswerValidator(ValidationService validator) {
        this.validator = validator;
    }

    @Override
    public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return false;
    }

    @Override
    public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean isValid = true;
        if (eObject instanceof Answer answer) {
            isValid = this.validateUserAnswer(answer, diagnostics);
        }
        return isValid;
    }

    @Override
    public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return false;
    }


    public boolean validateUserAnswer(Answer answer, DiagnosticChain diagnostics) {
        var result = validator.validateAnswer(answer);
        result.ifPresent(diagnostics::add);
        return result.isEmpty();
    }
}
