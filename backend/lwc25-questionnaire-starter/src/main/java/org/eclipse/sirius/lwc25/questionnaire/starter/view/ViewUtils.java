package org.eclipse.sirius.lwc25.questionnaire.starter.view;

import org.eclipse.sirius.components.view.Operation;
import org.eclipse.sirius.components.view.builder.generated.view.ViewBuilders;

public class ViewUtils {

    private final ViewBuilders viewBuilderHelper = new ViewBuilders();

    public Operation textfieldSetter(String self, String resultRef, String valueExpression) {
        return this.viewBuilderHelper.newChangeContext()
                .expression("aql:" + self)
                .children(this.viewBuilderHelper.newSetValue()
                        .valueExpression(valueExpression)
                        .featureName(resultRef)
                        .build()
                )
                .build();
    }

    public Operation textfieldSetter(String self, String resultRef) {
        return textfieldSetter(self, resultRef, "aql:newValue.toString()");
    }

}
