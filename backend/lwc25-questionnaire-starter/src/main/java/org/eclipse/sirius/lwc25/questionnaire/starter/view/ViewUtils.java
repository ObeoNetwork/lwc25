package org.eclipse.sirius.lwc25.questionnaire.starter.view;

import org.eclipse.sirius.components.view.Operation;
import org.eclipse.sirius.components.view.builder.generated.view.ViewBuilders;

public class ViewUtils {

    private final ViewBuilders viewBuilderHelper = new ViewBuilders();

    public Operation textfieldSetter(String self, String resultRef) {
        return this.viewBuilderHelper.newChangeContext()
                .expression("aql:" + self)
                .children(this.viewBuilderHelper.newSetValue()
                        .valueExpression("aql:newValue.toString()")
                        .featureName(resultRef)
                        .build()
                )
                .build();
    }

}
