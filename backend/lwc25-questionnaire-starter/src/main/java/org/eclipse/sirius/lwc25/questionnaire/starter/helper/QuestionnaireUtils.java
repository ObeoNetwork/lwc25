package org.eclipse.sirius.lwc25.questionnaire.starter.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.questionnaire.ConditionalGroup;
import org.eclipse.sirius.questionnaire.Question;
import org.eclipse.sirius.questionnaire.QuestionReuse;

import java.util.LinkedList;
import java.util.List;

public class QuestionnaireUtils {

    public static List<Question> getScopedVariables(EObject obj) {
        var iterator = EcoreUtil.getRootContainer(obj).eAllContents();
        var questions = new LinkedList<Question>();

        while(iterator.hasNext()) {
            var current = iterator.next();
            if(current == obj) {
                break;
            } else if(current instanceof Question question) {
                questions.add(question);
            } else if(current instanceof ConditionalGroup group && !EcoreUtil.isAncestor(group, obj)) {
                iterator.prune();
            } else if(current instanceof QuestionReuse reuse && !questions.contains(reuse.getQuestion())) {
                questions.add(reuse.getQuestion());
            }
        }
        return questions;
    }
}
