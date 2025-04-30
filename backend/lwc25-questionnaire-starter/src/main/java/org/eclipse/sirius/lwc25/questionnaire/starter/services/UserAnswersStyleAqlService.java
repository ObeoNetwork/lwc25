package org.eclipse.sirius.lwc25.questionnaire.starter.services;

import com.google.common.collect.Streams;
import org.apache.catalina.User;
import org.eclipse.acceleo.query.ast.VarRef;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine;
import org.eclipse.acceleo.query.runtime.QueryParsing;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.answer.*;
import org.eclipse.sirius.components.core.api.IIdentityService;
import org.eclipse.sirius.components.interpreter.AQLInterpreter;
import org.eclipse.sirius.components.representations.VariableManager;
import org.eclipse.sirius.ecore.extender.business.internal.accessor.ecore.EcoreIntrinsicExtender;
import org.eclipse.sirius.lwc25.questionnaire.starter.helper.QuestionnaireUtils;
import org.eclipse.sirius.qlstyle.QLStyle;
import org.eclipse.sirius.questionnaire.*;

import java.sql.Date;
import java.util.*;
import java.util.stream.IntStream;

public class UserAnswersStyleAqlService {

    public QLStyle getStyle(Form form) {
       return Streams.stream(form.eResource().getResourceSet().getAllContents())
                .filter(QLStyle.class::isInstance)
                .map(QLStyle.class::cast)
                .filter(qlStyle -> qlStyle.getForm() == form)
                .findFirst()
                .orElse(null);
    }

    public List<Integer> generateIntList(IntegerType integer) {
        return IntStream.range(integer.getMin(), integer.getMax() + 1).boxed().toList();
    }
}
