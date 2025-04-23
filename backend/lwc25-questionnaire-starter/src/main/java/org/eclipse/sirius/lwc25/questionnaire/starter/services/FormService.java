package org.eclipse.sirius.lwc25.questionnaire.starter.services;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.sirius.ecore.extender.business.internal.accessor.ecore.EcoreIntrinsicExtender;
import org.eclipse.sirius.questionnaire.Question;

public class FormService {

    public Question newInstance(Question question, EClass type) {
        var extender = new EcoreIntrinsicExtender();
        var newInstance = extender.createInstance(type);
        extender.eAdd(question, "type", newInstance);
        return question;
    }

}
