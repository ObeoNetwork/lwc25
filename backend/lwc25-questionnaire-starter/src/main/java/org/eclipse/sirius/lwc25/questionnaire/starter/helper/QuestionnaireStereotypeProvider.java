/*******************************************************************************
 * Copyright (c) 2024, 2025 Obeo.
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
import org.eclipse.sirius.web.application.UUIDParser;
import org.eclipse.sirius.web.application.document.dto.Stereotype;
import org.eclipse.sirius.web.application.document.services.api.IStereotypeProvider;
import org.eclipse.sirius.web.domain.boundedcontexts.project.Nature;
import org.eclipse.sirius.web.domain.boundedcontexts.project.services.api.IProjectSearchService;
import org.eclipse.sirius.web.domain.boundedcontexts.projectsemanticdata.ProjectSemanticData;
import org.eclipse.sirius.web.domain.boundedcontexts.projectsemanticdata.services.api.IProjectSemanticDataSearchService;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Used to return the list of stereotypes to create documents.
 *
 * @author sbegaudeau
 */
@Service
public class QuestionnaireStereotypeProvider implements IStereotypeProvider {

    public static final String EMPTY_QUESTIONNAIRE = "empty_questionnaire";
    public static final String EMPTY_ANSWERS = "empty_answers";
    public static final String EMPTY_STYLE = "empty_qlstyle";

    private final IProjectSearchService projectSearchService;

    private final IProjectSemanticDataSearchService projectSemanticDataSearchService;

    public QuestionnaireStereotypeProvider(IProjectSearchService projectSearchService, IProjectSemanticDataSearchService projectSemanticDataSearchService) {
        this.projectSearchService = Objects.requireNonNull(projectSearchService);
        this.projectSemanticDataSearchService = Objects.requireNonNull(projectSemanticDataSearchService);
    }

    @Override
    public List<Stereotype> getStereotypes(IEditingContext editingContext) {
        var isQuestionnaireProject = new UUIDParser().parse(editingContext.getId())
                .flatMap(semanticDataId -> this.projectSemanticDataSearchService.findBySemanticDataId(AggregateReference.to(semanticDataId)))
                .map(ProjectSemanticData::getProject)
                .map(AggregateReference::getId)
                .flatMap(this.projectSearchService::findById)
                .filter(project -> project.getNatures().stream()
                        .map(Nature::name)
                        .anyMatch(QuestionnaireProjectTemplatesProvider.QUESTIONNAIRE_NATURE::equals))
                .isPresent();

        if (isQuestionnaireProject) {
            return List.of(
                    new Stereotype(EMPTY_QUESTIONNAIRE, "Questionnaire"),
                    new Stereotype(EMPTY_ANSWERS, "Questionnaire Answers"),
                    new Stereotype(EMPTY_ANSWERS, "Questionnaire Style")
            );
        }
        return List.of();
    }
}
