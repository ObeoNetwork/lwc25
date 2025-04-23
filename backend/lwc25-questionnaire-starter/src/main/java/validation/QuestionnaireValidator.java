package validation;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.sirius.answer.Answer;
import org.eclipse.sirius.lwc25.questionnaire.starter.services.ValidationService;
import org.eclipse.sirius.questionnaire.Question;

import java.util.Map;

public class QuestionnaireValidator implements EValidator {

    private final ValidationService validator;

    public QuestionnaireValidator(ValidationService validator) {
        this.validator = validator;
    }

    @Override
    public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return false;
    }

    @Override
    public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean isValid = true;
        if (eObject instanceof Question question) {
            isValid = this.validateQuestion(question, diagnostics);
        }
        return isValid;
    }

    @Override
    public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return false;
    }

    public boolean validateQuestion(Question question, DiagnosticChain diagnostics) {
        var result = validator.validateQuestionName(question);
        result.ifPresent(diagnostics::add);
        var aqlResult = validator.validateAqlExpression(question, question.getComputedExpression(), "computedExpression");
        aqlResult.forEach(diagnostics::add);
        return result.isEmpty() && aqlResult.isEmpty();
    }
}
