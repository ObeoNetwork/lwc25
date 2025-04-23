/*******************************************************************************
 * Copyright (c) 2023, 2025 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.lwc25.questionnaire.starter.helper;

import io.micrometer.core.instrument.MeterRegistry;
import org.eclipse.sirius.components.collaborative.api.IRepresentationMetadataPersistenceService;
import org.eclipse.sirius.components.collaborative.api.IRepresentationPersistenceService;
import org.eclipse.sirius.components.core.RepresentationMetadata;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.core.api.IIdentityService;
import org.eclipse.sirius.components.core.api.IRepresentationDescriptionSearchService;
import org.eclipse.sirius.components.diagrams.description.DiagramDescription;
import org.eclipse.sirius.components.emf.ResourceMetadataAdapter;
import org.eclipse.sirius.components.emf.services.JSONResourceFactory;
import org.eclipse.sirius.components.emf.services.api.IEMFEditingContext;
import org.eclipse.sirius.components.events.ICause;
import org.eclipse.sirius.components.forms.description.FormDescription;
import org.eclipse.sirius.components.representations.VariableManager;
import org.eclipse.sirius.questionnaire.Form;
import org.eclipse.sirius.questionnaire.Question;
import org.eclipse.sirius.questionnaire.QuestionnaireFactory;
import org.eclipse.sirius.web.application.project.services.api.IProjectTemplateInitializer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuestionnaireProjectTemplatesInitializer implements IProjectTemplateInitializer {

    private static final String QUESTIONNAIRE_VIEW_DESCRIPTION_ID = "siriusComponents://representationDescription?kind=formDescription&sourceKind=view&sourceId=942b5891-9b51-3fba-90ab-f5e49ccf345e&sourceElementId=bce2748b-a1e5-39e6-ad86-a29323589b38";

    private final IRepresentationDescriptionSearchService representationDescriptionSearchService;

    private final FormCreationService formCreationService;

    private final IRepresentationMetadataPersistenceService representationMetadataPersistenceService;

    private final IRepresentationPersistenceService representationPersistenceService;

    private final IIdentityService idService;

    public QuestionnaireProjectTemplatesInitializer(IRepresentationDescriptionSearchService representationDescriptionSearchService,
                                                    FormCreationService formCreationService, IRepresentationPersistenceService representationPersistenceService, MeterRegistry meterRegistry,
                                                    IRepresentationMetadataPersistenceService representationMetadataPersistenceService, IIdentityService idService) {
        this.representationDescriptionSearchService = Objects.requireNonNull(representationDescriptionSearchService);
        this.formCreationService = Objects.requireNonNull(formCreationService);
        this.representationPersistenceService = Objects.requireNonNull(representationPersistenceService);
        this.representationMetadataPersistenceService = Objects.requireNonNull(representationMetadataPersistenceService);
        this.idService = idService;
    }

    @Override
    public boolean canHandle(String templateId) {
        return QuestionnaireProjectTemplatesProvider.QUESTIONNAIRE_TEMPLATE_ID.equals(templateId);
    }

    @Override
    public Optional<RepresentationMetadata> handle(ICause cause, String templateId, IEditingContext editingContext) {
        if (QuestionnaireProjectTemplatesProvider.QUESTIONNAIRE_TEMPLATE_ID.equals(templateId)) {
            return this.initializeQuestionnaireProject(cause, editingContext);
        }
        return Optional.empty();
    }

    private Optional<RepresentationMetadata> initializeQuestionnaireProject(ICause cause, IEditingContext editingContext) {
        Optional<RepresentationMetadata> result = Optional.empty();
        if (editingContext instanceof IEMFEditingContext emfEditingContext) {
            var documentId = UUID.randomUUID();
            var resource = new JSONResourceFactory().createResourceFromPath(documentId.toString());
            var resourceMetadataAdapter = new ResourceMetadataAdapter("Questionnaire");
            resource.eAdapters().add(resourceMetadataAdapter);
            emfEditingContext.getDomain().getResourceSet().getResources().add(resource);

            resource.getContents().add(this.getQuestionnaireContent());

            var optionalFormDesc = this.representationDescriptionSearchService.findById(editingContext, QUESTIONNAIRE_VIEW_DESCRIPTION_ID)
                    .filter(FormDescription.class::isInstance)
                    .map(FormDescription.class::cast);

            if (optionalFormDesc.isPresent()) {
                FormDescription formDescription = optionalFormDesc.get();
                Object semanticTarget = resource.getContents().get(0);

                var variableManager = new VariableManager();
                variableManager.put(VariableManager.SELF, semanticTarget);
                variableManager.put(DiagramDescription.LABEL, formDescription.getLabel());
                String label = formDescription.getLabelProvider().apply(variableManager);
                List<String> iconURLs = formDescription.getIconURLsProvider().apply(variableManager);


                org.eclipse.sirius.components.forms.Form form = org.eclipse.sirius.components.forms.Form.newForm(UUID.randomUUID().toString())
                        .targetObjectId(idService.getId(semanticTarget))
                        .descriptionId(formDescription.getId())
                        .pages(List.of()) // We don't store form pages, it will be re-render by the FormProcessor.
                        .build();

                org.eclipse.sirius.components.forms.Form newForm = this.formCreationService.create(semanticTarget, formDescription, editingContext);

                var representationMetadata = RepresentationMetadata.newRepresentationMetadata(newForm.getId())
                        .kind(newForm.getKind())
                        .label(label)
                        .descriptionId(newForm.getDescriptionId())
                        .iconURLs(iconURLs)
                        .build();

                this.representationMetadataPersistenceService.save(cause, editingContext, representationMetadata, newForm.getTargetObjectId());
                this.representationPersistenceService.save(cause, editingContext, newForm);

                result = Optional.of(representationMetadata);
            }
        }
        return result;
    }

    private Form getQuestionnaireContent() {
        Form form = QuestionnaireFactory.eINSTANCE.createForm();
        form.setName("NewQuestionnaire");

        Question question = QuestionnaireFactory.eINSTANCE.createQuestion();
        question.setName("email_address");
        question.setLabel("Your email address");
        question.setType(QuestionnaireFactory.eINSTANCE.createStringType());
        form.getElements().add(question);

        return form;
    }
}
