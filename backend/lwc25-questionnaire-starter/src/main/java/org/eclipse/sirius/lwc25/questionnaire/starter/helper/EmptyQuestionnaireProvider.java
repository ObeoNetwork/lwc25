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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.sirius.answer.AnswerFactory;
import org.eclipse.sirius.components.emf.ResourceMetadataAdapter;
import org.eclipse.sirius.components.emf.migration.MigrationService;
import org.eclipse.sirius.components.emf.migration.api.IMigrationParticipant;
import org.eclipse.sirius.components.emf.services.JSONResourceFactory;
import org.eclipse.sirius.lwc25.questionnaire.starter.helper.api.IEmptyQuestionnaireProvider;
import org.eclipse.sirius.questionnaire.QuestionnaireFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class EmptyQuestionnaireProvider implements IEmptyQuestionnaireProvider {

    private final List<IMigrationParticipant> migrationParticipants;

    public EmptyQuestionnaireProvider(List<IMigrationParticipant> migrationParticipants) {
        this.migrationParticipants = Objects.requireNonNull(migrationParticipants);
    }

    @Override
    public UUID addEmptyQuestionnaire(ResourceSet resourceSet, String resourceName) {
        return addEmptyModel(resourceSet, resourceName, QuestionnaireFactory.eINSTANCE::createForm);
    }

    @Override
    public UUID addEmptyAnswer(ResourceSet resourceSet, String resourceName) {
        return addEmptyModel(resourceSet, resourceName, AnswerFactory.eINSTANCE::createFormAnswers);
    }

    private UUID addEmptyModel(ResourceSet resourceSet, String resourceName, Supplier<EObject> producer) {
        var documentId = UUID.randomUUID();
        var resource = new JSONResourceFactory().createResourceFromPath(documentId.toString());

        var resourceMetadataAdapter = new ResourceMetadataAdapter(resourceName);
        var migrationService = new MigrationService(this.migrationParticipants);

        resourceMetadataAdapter.setMigrationData(migrationService.getMostRecentParticipantMigrationData());

        resource.eAdapters().add(resourceMetadataAdapter);
        resourceSet.getResources().add(resource);

        var model = producer.get();

        resource.getContents().add(model);

        return documentId;
    }
}
