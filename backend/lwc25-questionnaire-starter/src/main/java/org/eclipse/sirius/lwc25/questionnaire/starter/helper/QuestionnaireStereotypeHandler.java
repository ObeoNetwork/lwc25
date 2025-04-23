/*******************************************************************************
 * Copyright (c) 2024 Obeo.
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

import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.emf.services.api.IEMFEditingContext;
import org.eclipse.sirius.lwc25.questionnaire.starter.helper.api.IEmptyQuestionnaireProvider;
import org.eclipse.sirius.web.application.document.dto.DocumentDTO;
import org.eclipse.sirius.web.application.document.services.api.IStereotypeHandler;
import org.eclipse.sirius.web.application.views.explorer.services.ExplorerDescriptionProvider;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * Used to create documents from a stereotype.
 *
 * @author sbegaudeau
 */
@Service
public class QuestionnaireStereotypeHandler implements IStereotypeHandler {

    private final IEmptyQuestionnaireProvider emptyQuestionnaireProvider;

    public QuestionnaireStereotypeHandler(IEmptyQuestionnaireProvider emptyQuestionnaireProvider) {
        this.emptyQuestionnaireProvider = Objects.requireNonNull(emptyQuestionnaireProvider);
    }

    @Override
    public boolean canHandle(IEditingContext editingContext, String stereotypeId) {
        return Objects.equals(QuestionnaireStereotypeProvider.EMPTY_QUESTIONNAIRE, stereotypeId) ||
                Objects.equals(QuestionnaireStereotypeProvider.EMPTY_ANSWERS, stereotypeId);
    }

    @Override
    public Optional<DocumentDTO> handle(IEditingContext editingContext, String stereotypeId, String name) {
        if (editingContext instanceof IEMFEditingContext emfEditingContext) {
            return switch (stereotypeId) {
                case QuestionnaireStereotypeProvider.EMPTY_QUESTIONNAIRE -> createEmptyQuestionnaireDocument(emfEditingContext, name);
                case QuestionnaireStereotypeProvider.EMPTY_ANSWERS -> createEmptyAnswerDocument(emfEditingContext, name);
                default -> Optional.empty();
            };
        }
        return Optional.empty();
    }

    private Optional<DocumentDTO> createEmptyQuestionnaireDocument(IEMFEditingContext editingContext, String name) {
        var documentId = this.emptyQuestionnaireProvider.addEmptyQuestionnaire(editingContext.getDomain().getResourceSet(), name);
        return Optional.of(new DocumentDTO(documentId, name, ExplorerDescriptionProvider.DOCUMENT_KIND));
    }

    private Optional<DocumentDTO> createEmptyAnswerDocument(IEMFEditingContext editingContext, String name) {
        var documentId = this.emptyQuestionnaireProvider.addEmptyAnswer(editingContext.getDomain().getResourceSet(), name);
        return Optional.of(new DocumentDTO(documentId, name, ExplorerDescriptionProvider.DOCUMENT_KIND));
    }
}
