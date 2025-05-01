package org.eclipse.sirius.lwc25.questionnaire.starter.configuration;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.sirius.answer.provider.AnswerItemProviderAdapterFactory;
import org.eclipse.sirius.qlstyle.provider.QLStyleItemProviderAdapterFactory;
import org.eclipse.sirius.questionnaire.provider.QuestionnaireItemProviderAdapterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuestionnaireEMFConfiguration {

    @Bean
    public AdapterFactory questionnaireAdapterFactory() {
        return new QuestionnaireItemProviderAdapterFactory();
    }

    @Bean
    public AdapterFactory answerAdapterFactory() {
        return new AnswerItemProviderAdapterFactory();
    }

    @Bean
    public AdapterFactory qlstyleAdapterFactory() {
        return new QLStyleItemProviderAdapterFactory();
    }
}
