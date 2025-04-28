package org.eclipse.sirius.lwc25.questionnaire.starter.services;

import com.google.common.collect.Streams;
import org.eclipse.acceleo.query.ast.VarRef;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine;
import org.eclipse.acceleo.query.runtime.QueryParsing;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.answer.Answer;
import org.eclipse.sirius.answer.AnswerPackage;
import org.eclipse.sirius.answer.UserAnswers;
import org.eclipse.sirius.components.interpreter.AQLInterpreter;
import org.eclipse.sirius.components.representations.VariableManager;
import org.eclipse.sirius.ecore.extender.business.internal.accessor.ecore.EcoreIntrinsicExtender;
import org.eclipse.sirius.lwc25.questionnaire.starter.helper.QuestionnaireUtils;
import org.eclipse.sirius.questionnaire.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class UserAnswersService {

    private final ValidationService validator;

    public UserAnswersService(ValidationService validator) {
        this.validator = validator;
    }

    public boolean mustBeHidden(ConditionalGroup eObject, UserAnswers answers) {
        boolean result = eObject.getCondition() != null;
        var manager = getScopedVariables(eObject, answers);
        result &= !hasUndefinedVariables(eObject.getCondition(), manager);

        if(result) {
            AQLInterpreter interpreter = new AQLInterpreter(List.of(), List.of(this), List.of(AnswerPackage.eINSTANCE, QuestionnairePackage.eINSTANCE));
            result = interpreter.evaluateExpression(manager.getVariables(), eObject.getCondition()).asBoolean().orElse(false);
        }

        // If the group must be hidden, we reset the result of each hidden answer
        if(!result) {
            Streams.stream(eObject.eAllContents())
                    .filter(Question.class::isInstance)
                    .map(Question.class::cast)
                    .map(question -> getCorrespondingAnswer(question, answers))
                    .flatMap(Optional::stream)
                    .forEach(answer -> new EcoreIntrinsicExtender().eSet(answer, "answer", null));
        }

        return result;
    }

    public String evaluate(Question question, UserAnswers answers) {
        var manager = getScopedVariables(question, answers);
        if(hasUndefinedVariables(question.getComputedExpression(), manager)) {
            return "";
        }
        AQLInterpreter interpreter = new AQLInterpreter(List.of(), List.of(this), List.of(AnswerPackage.eINSTANCE, QuestionnairePackage.eINSTANCE));
        var result = interpreter.evaluateExpression(manager.getVariables(), question.getComputedExpression());
        return result.asString().orElse("");
    }

    public Diagnostic validateValue(Answer answer) {
        return validator.validateAnswer(answer).orElse(null);
    }

    private VariableManager getScopedVariables(EObject obj, UserAnswers answers) {
        var manager = new VariableManager();
        manager.put(VariableManager.SELF, obj);
        manager.put("undefined", null);
        for(var question: QuestionnaireUtils.getScopedVariables(obj)) {
                getCorrespondingAnswer(question, answers)
                    .flatMap(this::convertAnswerValue)
                    .ifPresentOrElse(value -> manager.put(question.getName(), value), () -> manager.put(question.getName(), null));
            }
        return manager;
    }

    private Optional<Answer> getCorrespondingAnswer(Question question, UserAnswers answer) {
        return answer.getAnswers().stream().filter(ans -> ans.getQuestion() == question).findFirst();
    }

    private Optional<Object> convertAnswerValue(Answer answer) {
        Object result = null;
        if(answer.getAnswer() != null) {
            try {
                if ((answer.getQuestion().getType() instanceof StringType || answer.getQuestion().getType() instanceof EnumerationType) && !answer.getAnswer().isBlank()) {
                    result = answer.getAnswer();
                } else if (answer.getQuestion().getType() instanceof BooleanType) {
                    result = Boolean.parseBoolean(answer.getAnswer());
                } else if (answer.getQuestion().getType() instanceof IntegerType) {
                    result = Integer.parseInt(answer.getAnswer());
                } else if (answer.getQuestion().getType() instanceof DecimalType || answer.getQuestion() instanceof MoneyType) {
                    result = Float.parseFloat(answer.getAnswer());
                } else if (answer.getQuestion().getType() instanceof DateType) {
                    result = Date.valueOf(answer.getAnswer());
                }
            } catch (Exception ignored) {
            }
        }
        return Optional.ofNullable(result);
    }

    private boolean hasUndefinedVariables(String query, VariableManager manager) {
        IQueryBuilderEngine builder = QueryParsing.newBuilder();
        var astResult = builder.build(query.replace("aql:", ""));
        return Streams.stream(astResult.getAst().eAllContents())
                .filter(VarRef.class::isInstance)
                .map(VarRef.class::cast)
                .filter(var -> manager.hasVariable(var.getVariableName()))
                .filter(var -> !var.getVariableName().equals("undefined"))
                .anyMatch(var -> manager.get(var.getVariableName(), Object.class).isEmpty());
    }

}
