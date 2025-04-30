package org.eclipse.sirius.lwc25.questionnaire.starter.services;

import com.google.common.collect.Streams;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.answer.Answer;
import org.eclipse.sirius.answer.AnswerFactory;
import org.eclipse.sirius.answer.FormAnswers;
import org.eclipse.sirius.components.collaborative.dto.CreateRepresentationInput;
import org.eclipse.sirius.components.collaborative.forms.handlers.CreateFormEventHandler;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.core.api.IIdentityService;
import org.eclipse.sirius.ecore.extender.business.internal.accessor.ecore.EcoreIntrinsicExtender;
import org.eclipse.sirius.lwc25.questionnaire.starter.view.UserAnswerFormDescriptionProvider;
import org.eclipse.sirius.questionnaire.*;
import org.eclipse.sirius.web.application.editingcontext.EditingContext;
import reactor.core.publisher.Sinks;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class FormAnswersAqlService {

    private final IIdentityService idService;
    private final CreateFormEventHandler handler;

    public FormAnswersAqlService(IIdentityService idService, CreateFormEventHandler handler) {
        this.idService = idService;
        this.handler = handler;
    }

    public EObject start(FormAnswers formAnswers, IEditingContext editingContext) {
        var answers = formAnswers.getUserAnswers().stream().filter(userAns -> userAns.getName().equals(formAnswers.getUserId())).findFirst().orElse(null);
        if(answers == null && editingContext instanceof EditingContext emfEditingContext) {
            var repOpt = emfEditingContext.getRepresentationDescriptions().values().stream()
                    .filter(value -> value.getLabel().equals(UserAnswerFormDescriptionProvider.LABEL))
                    .findFirst();
            if(repOpt.isPresent()) {
                answers = AnswerFactory.eINSTANCE.createUserAnswers();
                answers.setName(formAnswers.getUserId());
                generateEmptyAnswers(formAnswers.getForm().getElements(), answers.getAnswers());
                new EcoreIntrinsicExtender().eAdd(formAnswers, "userAnswers", answers);
                var creationRepInput = new CreateRepresentationInput(UUID.randomUUID(),
                        editingContext.getId(),
                        repOpt.get().getId(),
                        idService.getId(answers),
                        formAnswers.getUserId() + " answers");
                handler.handle(Sinks.one(), Sinks.many().unicast().onBackpressureBuffer(), editingContext, creationRepInput);
            }
        }
        return formAnswers;
    }

    private void generateEmptyAnswers(List<QuestionnaireElement> elements, List<Answer> answers) {
        for(var element: elements) {
            if(element instanceof Question question) {
                var answer = AnswerFactory.eINSTANCE.createAnswer();
                answer.setQuestion(question);
                answers.add(answer);
            } else if (element instanceof ConditionalGroup group) {
                generateEmptyAnswers(group.getElements(), answers);
            }
        }
    }

    public List<String> getKeys(EnumerationType enumeration) {
        return enumeration.getEnumerationliteral().stream().map(EnumerationLiteral::getName).sorted().toList();
    }

    public List<Long> getValues(EnumerationType enumeration, FormAnswers answers) {
        return List.copyOf(Streams.stream(answers.eAllContents())
                .filter(Answer.class::isInstance)
                .map(Answer.class::cast)
                .filter(answer -> answer.getQuestion().getType() == enumeration && answer.getAnswer() != null)
                .collect(Collectors.groupingBy(Answer::getAnswer, Collectors.counting()))
                .entrySet())
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
//                .map(lon -> Long.)
                .toList();
    }

}
