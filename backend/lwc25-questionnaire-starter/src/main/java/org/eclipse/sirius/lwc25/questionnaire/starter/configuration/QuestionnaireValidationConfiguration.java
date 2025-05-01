package org.eclipse.sirius.lwc25.questionnaire.starter.configuration;

import jakarta.annotation.PostConstruct;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.sirius.answer.AnswerPackage;
import org.eclipse.sirius.lwc25.questionnaire.starter.services.ValidationService;
import org.eclipse.sirius.lwc25.questionnaire.starter.validation.QuestionnaireValidator;
import org.eclipse.sirius.lwc25.questionnaire.starter.validation.UserAnswerValidator;
import org.eclipse.sirius.questionnaire.QuestionnairePackage;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuestionnaireValidationConfiguration {

    private final EValidator.Registry eValidatorRegistry;
    private final ValidationService validator;

    public QuestionnaireValidationConfiguration(EValidator.Registry eValidatorRegistry, ValidationService validator) {
        this.eValidatorRegistry = eValidatorRegistry;
        this.validator = validator;
    }

    @PostConstruct
    public void registerUserAnswerValidator() {
        this.eValidatorRegistry.put(AnswerPackage.eINSTANCE, new UserAnswerValidator(validator));
    }

    @PostConstruct
    public void registerQuestionnaireFormValidator() {
        this.eValidatorRegistry.put(QuestionnairePackage.eINSTANCE, new QuestionnaireValidator(validator));
    }


}
