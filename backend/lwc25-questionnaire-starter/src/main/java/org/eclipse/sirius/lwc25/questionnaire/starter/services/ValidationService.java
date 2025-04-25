package org.eclipse.sirius.lwc25.questionnaire.starter.services;

import jakarta.annotation.Nullable;
import org.eclipse.acceleo.query.validation.type.ClassType;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.answer.Answer;
import org.eclipse.sirius.answer.AnswerPackage;
import org.eclipse.sirius.lwc25.questionnaire.starter.helper.Utils;
import org.eclipse.sirius.questionnaire.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ValidationService {

    private Diagnostic newDiagnostic(String text, EObject object, String feature) {
        return new BasicDiagnostic(org.eclipse.emf.common.util.Diagnostic.ERROR,
                "sirius-web-application",
                0,
                text,
                new Object[]{
                        object,
                        object.eClass().getEStructuralFeature(feature),
                });
    }

    public Optional<Diagnostic> validateIntType(IntegerType type) {
        if(Optional.ofNullable(type.getMin()).orElse(Integer.MIN_VALUE) >= Optional.ofNullable(type.getMax()).orElse(Integer.MAX_VALUE))
            return Optional.of(newDiagnostic("The min bound must be lower than the max bound.", type, "min"));
        return Optional.empty();
    }

    public Optional<Diagnostic> validateQuestionName(Question question) {
        var scopedQuestions = Utils.getScopedVariables(question);
        // Name format
        if (question.getName() == null || !question.getName().matches("[a-zA-Z0-9\\-_]+")) {
            return Optional.of(newDiagnostic("Invalid name. The name should match '[a-zA-Z0-9-_]+'.", question, "name"));
        }
        // Name uniqueness
        if (scopedQuestions.stream().anyMatch(q -> Objects.equals(q.getName(), question.getName()) && question != q)) {
            return Optional.of(newDiagnostic(String.format("Question '%s' is already defined in the scope.", question.getName()), question, "name"));
        }
        return Optional.empty();
    }

    public List<Diagnostic> validateAqlExpression(QuestionnaireElement element, String expression, String feature, @Nullable String expectedType) {
        var aqlValidator = new AQLValidator(List.of(new UserAnswersService(this)), List.of(AnswerPackage.eINSTANCE, QuestionnairePackage.eINSTANCE));
        var diagnostics = new LinkedList<Diagnostic>();
        var scopedQuestions = Utils.getScopedVariables(element);

        // Computed expression format
        var resultOpt = aqlValidator.validate(expression, scopedQuestions);
        if (resultOpt.isPresent()) {
            var result = resultOpt.get();
            result.getMessages().forEach(mess -> diagnostics.add(newDiagnostic(mess.getMessage(), element, feature)));

            if (expectedType != null) {
                var possibleResultTypes = result.getPossibleTypes(result.getAstResult().getAst());
                // If the result is not well typed
                var isWellTyped = possibleResultTypes.stream()
                        .filter(ClassType.class::isInstance)
                        .map(ClassType.class::cast)
                        .anyMatch(clazz -> clazz.getType().getSimpleName().equals(expectedType));
                if (!isWellTyped) {
                    diagnostics.add(newDiagnostic("The expression must be a " + expectedType.toLowerCase() + " expression.", element, feature));
                }
            }
        } else {
            diagnostics.add(newDiagnostic("The expression must not be empty.", element, feature));
        }
        return diagnostics;
    }

    public Optional<Diagnostic> validateAnswer(Answer answer) {
        var question = answer.getQuestion();
        var type = question.getType();
        var answerStr = answer.getAnswer();

        if (type instanceof IntegerType integer) {
            var min = type.eIsSet(type.eClass().getEStructuralFeature("min")) ? integer.getMin() : Integer.MIN_VALUE;
            var max = type.eIsSet(type.eClass().getEStructuralFeature("max")) ? integer.getMax() : Integer.MAX_VALUE;
            return validateInteger(answerStr, answer, "answer", min, max);
        } else if (type instanceof DecimalType || type instanceof MoneyType) {
            return validateDecimal(answerStr, answer, "answer");
        } else if (type instanceof BooleanType) {
            return validateBoolean(answerStr, answer, "answer");
        } else if (type instanceof EnumerationType enumeration) {
            return validateEnumeration(answerStr, enumeration, answer, "answer");
        } else if (type instanceof DateType) {
            return validateDate(answerStr, answer, "answer");
        }
        return Optional.empty();
    }

    public Optional<Diagnostic> validateInteger(String value, EObject container, String featureName, int min, int max) {
        try {
            var parsedInt = Integer.parseInt(value);
            if (parsedInt > max || parsedInt < min) {
                var minStr = min != Integer.MIN_VALUE ? Integer.toString(min) : "-∞";
                var maxStr = max != Integer.MAX_VALUE ? Integer.toString(max) : "+∞";
                return Optional.of(newDiagnostic(String.format("'%s' is not a in bound [%s, %s].", value, minStr, maxStr), container, featureName));
            }
        } catch (NumberFormatException exception) {
            return Optional.of(newDiagnostic(String.format("'%s' is not an integer.", value), container, featureName));
        }
        return Optional.empty();
    }

    public Optional<Diagnostic> validateDecimal(String value, EObject container, String featureName) {
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException exception) {
            return Optional.of(newDiagnostic(String.format("'%s' is not a decimal number.", value), container, featureName));
        }
        return Optional.empty();
    }

    public Optional<Diagnostic> validateBoolean(String value, EObject container, String featureName) {
        if (!value.equals("true") && !value.equals("false")) {
            return Optional.of(newDiagnostic(String.format("'%s' is not a boolean value.", value), container, featureName));
        }
        return Optional.empty();
    }

    public Optional<Diagnostic> validateEnumeration(String value, EnumerationType type, EObject container, String featureName) {
        var result = type.getEnumerationliteral().stream().anyMatch(literal -> literal.getName().equals(value));
        if (!result) {
            return Optional.of(newDiagnostic(String.format("'%s' is not a valid value. Expected: %s.", value,
                    String.join(", ", type.getEnumerationliteral().stream().map(EnumerationLiteral::getName).toList())), container, featureName));
        }
        return Optional.empty();
    }

    public Optional<Diagnostic> validateDate(String value, EObject container, String featureName) {
        try {
            Instant.parse(value);
        } catch (DateTimeParseException exception) {
            return Optional.of(newDiagnostic(String.format("'%s' is not a valid date.", value), container, featureName));
        }
        return Optional.empty();
    }
}
