package org.eclipse.sirius.lwc25.questionnaire.starter.services;

import com.google.common.collect.Streams;
import org.eclipse.sirius.qlstyle.QLStyle;
import org.eclipse.sirius.questionnaire.Form;
import org.eclipse.sirius.questionnaire.IntegerType;

import java.util.List;
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
