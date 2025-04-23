package org.eclipse.sirius.lwc25.questionnaire.starter.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@AutoConfiguration
@ComponentScan(basePackages = {
        "org.eclipse.sirius.lwc25.questionnaire.starter"
})
public class QuestionnaireStarterConfiguration {
}
