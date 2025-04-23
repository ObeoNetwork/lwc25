package org.eclipse.sirius.lwc25.questionnaire.starter.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.answer.Answer;
import org.eclipse.sirius.answer.AnswerFactory;
import org.eclipse.sirius.answer.FormAnswers;
import org.eclipse.sirius.answer.UserAnswers;
import org.eclipse.sirius.components.collaborative.api.ChangeDescription;
import org.eclipse.sirius.components.collaborative.dto.CreateRepresentationInput;
import org.eclipse.sirius.components.collaborative.forms.handlers.CreateFormEventHandler;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.core.api.IIdentityService;
import org.eclipse.sirius.components.graphql.api.IEditingContextDispatcher;
import org.eclipse.sirius.components.graphql.api.IExceptionWrapper;
import org.eclipse.sirius.ecore.extender.business.internal.accessor.ecore.EcoreIntrinsicExtender;
import org.eclipse.sirius.questionnaire.ConditionalGroup;
import org.eclipse.sirius.questionnaire.Question;
import org.eclipse.sirius.questionnaire.QuestionnaireElement;
import reactor.core.publisher.Sinks;

import java.util.List;
import java.util.UUID;

public class FormAnswersService {

    private final IExceptionWrapper exceptionWrapper;
    private final IEditingContextDispatcher editingContextDispatcher;
    private final IIdentityService idService;
    private final CreateFormEventHandler handler;

    public FormAnswersService(IExceptionWrapper exceptionWrapper, IEditingContextDispatcher editingContextDispatcher, IIdentityService idService, CreateFormEventHandler handler) {
        this.exceptionWrapper = exceptionWrapper;
        this.editingContextDispatcher = editingContextDispatcher;
        this.idService = idService;
        this.handler = handler;
    }

    public EObject start(FormAnswers formAnswers, IEditingContext editingContext) {
        var answers = formAnswers.getUserAnswers().stream().filter(userAns -> userAns.getName().equals(formAnswers.getUserId())).findFirst().orElse(null);
        if(answers == null) {
            answers = AnswerFactory.eINSTANCE.createUserAnswers();
            answers.setName(formAnswers.getUserId());
            generateEmptyAnswers(formAnswers.getForm().getElements(), answers.getAnswers());
            new EcoreIntrinsicExtender().eAdd(formAnswers, "userAnswers", answers);
            var creationRepInput = new CreateRepresentationInput(UUID.randomUUID(),
                    editingContext.getId(),
                    UUID.nameUUIDFromBytes("UserAnswerView".getBytes()).toString(),
                    idService.getId(answers),
                    formAnswers.getUserId() + " answers");
            handler.handle(Sinks.one(), Sinks.many().unicast().onBackpressureBuffer(), editingContext, creationRepInput);
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

}
