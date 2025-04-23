package org.eclipse.sirius.lwc25.questionnaire.starter.services;

import com.google.common.collect.Streams;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.answer.Answer;
import org.eclipse.sirius.answer.AnswerPackage;
import org.eclipse.sirius.answer.UserAnswers;
import org.eclipse.sirius.components.interpreter.AQLInterpreter;
import org.eclipse.sirius.components.representations.VariableManager;
import org.eclipse.sirius.questionnaire.*;
import org.springframework.util.StreamUtils;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class UserAnswersService {

    public boolean isUndefined(Object obj) {
        return obj == null;
    }

    public boolean isValid(ConditionalGroup eObject, UserAnswers answers) {
//        var manager = new VariableManager();
//        manager.put(VariableManager.SELF, eObject);
//        eObject.eContainer();
//        var elements = (List<QuestionnaireElement>) eObject.eContainer().eGet(eObject.eContainingFeature());
//
//        QuestionnaireElement element = null;
//        for(var elem: elements) {
//            if(elem == eObject) {
//                break;
//            }
//            if(elem instanceof Question question) {
//                getCorrespondingAnswer(question, answers)
//                    .flatMap(this::convertAnswerValue)
//                    .ifPresentOrElse(value -> manager.put(question.getName(), value), () -> manager.put(question.getName(), null));
//            }
//        }

        var manager = getScopedVariables(eObject, answers);
        AQLInterpreter interpreter = new AQLInterpreter(List.of(), List.of(), List.of(AnswerPackage.eINSTANCE, QuestionnairePackage.eINSTANCE));
        var result = interpreter.evaluateExpression(manager.getVariables(), eObject.getCondition());
        return result.asBoolean().orElse(false);
    }

    public String evaluate(Question question, UserAnswers answers) {
        var manager = getScopedVariables(question, answers);
        AQLInterpreter interpreter = new AQLInterpreter(List.of(), List.of(), List.of(AnswerPackage.eINSTANCE, QuestionnairePackage.eINSTANCE));
        var result = interpreter.evaluateExpression(manager.getVariables(), question.getComputedExpression());
        return result.asString().orElse("");
    }

    public VariableManager getScopedVariables(EObject obj, UserAnswers answers) {
        var manager = new VariableManager();
        manager.put(VariableManager.SELF, obj);
        var elements = Streams.stream(((Form) EcoreUtil.getRootContainer(obj)).eAllContents()).toList();

        EObject element = null;
        for(var elem: elements) {
            if(elem == obj) {
                break;
            }
            if(elem instanceof Question question) {
                getCorrespondingAnswer(question, answers)
                        .flatMap(this::convertAnswerValue)
                        .ifPresentOrElse(value -> manager.put(question.getName(), value), () -> manager.put(question.getName(), null));
            }
        }
        return manager;
    }

    private Optional<Answer> getCorrespondingAnswer(Question question, UserAnswers answer) {
        return answer.getAnswers().stream().filter(ans -> ans.getQuestion() == question).findFirst();
    }

    private Optional<Object> convertAnswerValue(Answer answer) {
        Object result = null;
        if(answer.getQuestion().getType() instanceof StringType) {
            result = answer.getAnswer();
        } else if(answer.getQuestion().getType() instanceof BooleanType) {
            result = Boolean.parseBoolean(answer.getAnswer());
        } else if(answer.getQuestion().getType() instanceof IntegerType) {
            result = Integer.parseInt(answer.getAnswer());
        } else if(answer.getQuestion().getType() instanceof DecimalType || answer.getQuestion() instanceof MoneyType) {
            result = Float.parseFloat(answer.getAnswer());
        } else if(answer.getQuestion().getType() instanceof DateType) {
            result = Date.valueOf(answer.getAnswer());
        }
        return Optional.ofNullable(result);
    }

}
