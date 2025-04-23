/*******************************************************************************
 * Copyright (c) 2023, 2024 Obeo.
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

import org.eclipse.sirius.web.application.project.services.api.IProjectTemplateProvider;
import org.eclipse.sirius.web.application.project.services.api.ProjectTemplate;
import org.eclipse.sirius.web.application.project.services.api.ProjectTemplateNature;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireProjectTemplatesProvider implements IProjectTemplateProvider {

    public static final String QUESTIONNAIRE_TEMPLATE_ID = "questionnaire-template";

    public static final String QUESTIONNAIRE_NATURE = "siriusWeb://nature?kind=questionnaire";

    @Override
    public List<ProjectTemplate> getProjectTemplates() {
        var flowTemplate = new ProjectTemplate(QUESTIONNAIRE_TEMPLATE_ID, "Questionnaire", "/project-templates/Questionnaire-Template.svg", List.of(new ProjectTemplateNature(QUESTIONNAIRE_NATURE)));
        return List.of(flowTemplate);
    }

}
