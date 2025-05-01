package org.eclipse.sirius.lwc25.questionnaire.starter.services;

import com.google.common.collect.Streams;
import org.eclipse.acceleo.query.ast.VarRef;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine;
import org.eclipse.acceleo.query.runtime.QueryParsing;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.answer.*;
import org.eclipse.sirius.components.interpreter.AQLInterpreter;
import org.eclipse.sirius.components.representations.VariableManager;
import org.eclipse.sirius.ecore.extender.business.internal.accessor.ecore.EcoreIntrinsicExtender;
import org.eclipse.sirius.lwc25.questionnaire.starter.helper.QuestionnaireUtils;
import org.eclipse.sirius.questionnaire.*;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserAnswersAqlService {

    private final ValidationService validator;

    public UserAnswersAqlService(ValidationService validator) {
        this.validator = validator;
    }

    public boolean mustBeHidden(QuestionnaireElement question, UserAnswers answers) {
        var parent = question.eContainer();
        boolean result = false;
        if(parent instanceof ConditionalGroup group) {
            result = mustBeHidden(group, answers);
            if(result) {
                resetAnswer(question, answers);
            }
        }

        return result;
    }

    private boolean mustBeHidden(ConditionalGroup group, UserAnswers answers) {
        var result = group.getCondition() == null;
        var manager = getScopedVariables(group, answers);
        result |= hasUndefinedVariables(group.getCondition(), manager);

        if (!result) {
            AQLInterpreter interpreter = new AQLInterpreter(List.of(), List.of(this), List.of(AnswerPackage.eINSTANCE, QuestionnairePackage.eINSTANCE));
            result = interpreter.evaluateExpression(manager.getVariables(), group.getCondition()).asString().map(r -> r.isEmpty() || r.equals("false")).orElse(true);
        }
        return result;
    }

    private void resetAnswer(QuestionnaireElement element, UserAnswers answers) {
        List<QuestionnaireElement> dependencies = Streams.stream(EcoreUtil.getRootContainer(element).eAllContents())
                    .filter(elem -> elem instanceof QuestionReuse reuse && reuse.getQuestion() == element)
                    .filter(elem -> element != elem)
                    .map(QuestionnaireElement.class::cast)
                    .collect(Collectors.toCollection(LinkedList::new));

        if(element instanceof QuestionReuse reuse) {
            dependencies.add(reuse.getQuestion());
        }

        var shouldResetAnswer = true;

        for(var dependency: dependencies) {
            if(dependency.eContainer() instanceof ConditionalGroup group) {
                shouldResetAnswer &= mustBeHidden(group, answers);
            } else {
                shouldResetAnswer = false;
            }
        }

        // If at least one reuse of the question is displayed, we don't reset the value of the answer
        if(shouldResetAnswer) {
            getCorrespondingAnswer(element instanceof QuestionReuse reuse ? reuse.getQuestion() : (Question) element, answers)
                    .ifPresent(answer -> new EcoreIntrinsicExtender().eSet(answer, "answer", null));
        }
    }

    public String evaluateAndSave(Question question, UserAnswers answers) {
        var result = evaluate(question, answers);
        answers.getAnswers().stream()
                .filter(answer -> answer.getQuestion() == question)
                .findFirst()
                .ifPresent(answer -> new EcoreIntrinsicExtender().eSet(answer, "answer", result));
        return convertToString(result, question);
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
                } else if (answer.getQuestion().getType() instanceof DecimalType || answer.getQuestion().getType() instanceof MoneyType) {
                    result = Float.parseFloat(answer.getAnswer());
                } else if (answer.getQuestion().getType() instanceof DateType) {
                    result = Date.valueOf(answer.getAnswer());
                }
            } catch (Exception ignored) {
            }
        }
        return Optional.ofNullable(result);
    }

    private String convertToString(String value, Question question) {
        if(question.getType() instanceof MoneyType) {
            return value + "€";
        }
        return value;
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

    public EObject init(UserAnswers userAnswers) {
        var container = (FormAnswers) userAnswers.eContainer();
        var answers = new LinkedList<Answer>();
        generateEmptyAnswers(container.getForm().getElements(), answers);
        new EcoreIntrinsicExtender().eAdd(userAnswers, "answers", answers);
        return userAnswers;
    }

    private void generateEmptyAnswers(List<QuestionnaireElement> elements, List<Answer> answers) {
        for(var element: elements) {
            if(element instanceof Question question) {
                var answer = AnswerFactory.eINSTANCE.createAnswer();
                answer.setQuestion(question);
                answers.add(answer);
            } else if (element instanceof ConditionalGroup group) {
                generateEmptyAnswers(group.getElements(), answers);
            }
        }
    }

}
