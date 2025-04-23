package org.eclipse.sirius.lwc25.questionnaire.starter.services;

import org.eclipse.sirius.components.view.View;
import org.eclipse.sirius.components.view.emf.IJavaServiceProvider;
import org.eclipse.sirius.components.view.form.FormDescription;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.function.Function;

@Service
public class ServicesProvider implements IJavaServiceProvider {
    @Override
    public List<Class<?>> getServiceClasses(View view) {
        Function<String, Boolean> isSpeciticType = (String type) -> view.getDescriptions().stream()
                .filter(FormDescription.class::isInstance)
                .map(FormDescription.class::cast)
                .anyMatch(formDesc -> formDesc.getDomainType().equals(type));

        if(isSpeciticType.apply("answer::UserAnswers")) {
            return List.of(UserAnswersService.class);
        } else if(isSpeciticType.apply("answer::FormAnswers")) {
            return List.of(FormAnswersService.class);
        } else if(isSpeciticType.apply("questionnaire::Form")) {
            return List.of(FormService.class);
        }
        return List.of();
    }
}
