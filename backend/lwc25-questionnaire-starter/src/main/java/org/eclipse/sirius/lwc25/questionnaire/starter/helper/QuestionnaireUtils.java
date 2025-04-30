package org.eclipse.sirius.lwc25.questionnaire.starter.helper;

import com.google.common.collect.Streams;
import org.eclipse.acceleo.query.ast.VarRef;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine;
import org.eclipse.acceleo.query.runtime.QueryParsing;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.components.view.Conditional;
import org.eclipse.sirius.questionnaire.ConditionalGroup;
import org.eclipse.sirius.questionnaire.Question;
import org.eclipse.sirius.questionnaire.QuestionReuse;
import org.eclipse.sirius.questionnaire.QuestionnaireElement;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuestionnaireUtils {

    public static List<Question> getScopedVariables(EObject obj) {
        return Streams.stream(EcoreUtil.getRootContainer(obj).eAllContents())
                .filter(Question.class::isInstance)
                .map(Question.class::cast)
                .filter(question -> obj != question)
                .toList();
//        var questions = new LinkedList<Question>();
//
//        while(iterator.hasNext()) {
//            var current = iterator.next();
//            if(current == obj) {
//                break;
//            } else if(current instanceof Question question) {
//                questions.add(question);
//            } else if(current instanceof ConditionalGroup group && !EcoreUtil.isAncestor(group, obj)) {
//                iterator.prune();
//            } else if(current instanceof QuestionReuse reuse && !questions.contains(reuse.getQuestion())) {
//                questions.add(reuse.getQuestion());
//            }
//        }
//        return questions;
    }

//    public static Map<String, List<String>> getDependencies() {
//
//    }

    public static Optional<BasicDiagnostic> hasCycle(QuestionnaireElement origin) {
        var allQuestions = Streams.stream(EcoreUtil.getRootContainer(origin).eAllContents())
                .filter(Question.class::isInstance)
                .map(Question.class::cast)
                .collect(Collectors.toMap(Question::getName, Function.identity()));

        return hasCycle(origin, allQuestions, new LinkedList<>(), List.of());
    }

    public static Optional<BasicDiagnostic> hasCycle(QuestionnaireElement current, Map<String, Question> allQuestions, List<String> browsedQuestions, List<String> path) {
        var usedVariables = new LinkedList<String>();

        var newPath = new LinkedList<>(path);

        if(current instanceof Question question) {
            if(question.getComputedExpression() != null && !question.getComputedExpression().isBlank()) {
                usedVariables.addAll(getVariables(question.getComputedExpression()));
            }
            browsedQuestions.add(question.getName());
            newPath.add(question.getName());
        } else if(current instanceof ConditionalGroup group && group.getCondition() != null && !group.getCondition().isBlank()) {
            usedVariables.addAll(getVariables(group.getCondition()));
            newPath.add("if(" + group.getCondition() + ")");
        }

        if(!newPath.isEmpty() && usedVariables.contains(newPath.get(0))) {
            var result = String.join(" → ", newPath) + " → " + newPath.get(0);
            return Optional.of(new BasicDiagnostic(Diagnostic.ERROR, newPath.get(0), 0, "Cycle detected: " + result, null));
        }

        var toBrowse = getQuestions(usedVariables, allQuestions).stream().map(QuestionnaireElement.class::cast).collect(Collectors.toCollection(LinkedList::new));
        if(current.eContainer() instanceof ConditionalGroup group) {
            toBrowse.add(group);
        }
        return toBrowse.stream()
                .filter(q -> !(q instanceof Question question) || !browsedQuestions.contains(question.getName()))
                .map(question -> hasCycle(question, allQuestions, browsedQuestions, newPath))
                .flatMap(Optional::stream)
                .reduce((diag1, diag2) -> { diag1.add(diag2); return diag1; });
    }

    private static List<String> getVariables(String aqlExpression) {
        IQueryBuilderEngine builder = QueryParsing.newBuilder();
        var astResult = builder.build(aqlExpression.replace("aql:", ""));
        return Streams.stream(astResult.getAst().eAllContents())
                .filter(VarRef.class::isInstance)
                .map(VarRef.class::cast)
                .map(VarRef::getVariableName)
                .toList();
    }

    private static List<Question> getQuestions(List<String> variables, Map<String, Question> questions) {
        return questions.entrySet().stream()
                .filter(question -> variables.contains(question.getKey()))
                .map(Map.Entry::getValue)
                .toList();
    }

}
