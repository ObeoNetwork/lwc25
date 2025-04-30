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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.answer.AnswerPackage;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.core.api.IEditingContextProcessor;
import org.eclipse.sirius.components.emf.ResourceMetadataAdapter;
import org.eclipse.sirius.components.emf.services.IDAdapter;
import org.eclipse.sirius.components.emf.services.JSONResourceFactory;
import org.eclipse.sirius.components.view.ColorPalette;
import org.eclipse.sirius.components.view.FixedColor;
import org.eclipse.sirius.components.view.View;
import org.eclipse.sirius.components.view.ViewFactory;
import org.eclipse.sirius.components.view.builder.generated.view.ViewBuilder;
import org.eclipse.sirius.components.view.builder.providers.IColorProvider;
import org.eclipse.sirius.components.view.builder.providers.IRepresentationDescriptionProvider;
import org.eclipse.sirius.emfjson.resource.JsonResource;
import org.eclipse.sirius.lwc25.questionnaire.starter.view.*;
import org.eclipse.sirius.qlstyle.QLStylePackage;
import org.eclipse.sirius.questionnaire.QuestionnairePackage;
import org.eclipse.sirius.web.application.UUIDParser;
import org.eclipse.sirius.web.application.editingcontext.EditingContext;
import org.eclipse.sirius.web.domain.boundedcontexts.project.Nature;
import org.eclipse.sirius.web.domain.boundedcontexts.project.services.api.IProjectSearchService;
import org.eclipse.sirius.web.domain.boundedcontexts.projectsemanticdata.ProjectSemanticData;
import org.eclipse.sirius.web.domain.boundedcontexts.projectsemanticdata.services.api.IProjectSemanticDataSearchService;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class QuestionnaireEditingContextInitializer implements IEditingContextProcessor {

    private final IProjectSearchService projectSearchService;

    private final IProjectSemanticDataSearchService projectSemanticDataSearchService;
    private final List<IFormAnswerGenerator> generators;

    public QuestionnaireEditingContextInitializer(IProjectSearchService projectSearchService, IProjectSemanticDataSearchService projectSemanticDataSearchService, List<IFormAnswerGenerator> generators) {
        this.projectSearchService = Objects.requireNonNull(projectSearchService);
        this.projectSemanticDataSearchService = Objects.requireNonNull(projectSemanticDataSearchService);
        this.generators = generators;
    }

    @Override
    public void preProcess(IEditingContext editingContext) {
        var isQuestionnaireProject = new UUIDParser().parse(editingContext.getId())
                .flatMap(semanticDataId -> this.projectSemanticDataSearchService.findBySemanticDataId(AggregateReference.to(semanticDataId)))
                .map(ProjectSemanticData::getProject)
                .map(AggregateReference::getId)
                .flatMap(this.projectSearchService::findById)
                .filter(project -> project.getNatures().stream()
                        .map(Nature::name)
                        .anyMatch(QuestionnaireProjectTemplatesProvider.QUESTIONNAIRE_NATURE::equals))
                .isPresent();

        if (isQuestionnaireProject && editingContext instanceof EditingContext emfEditingContext) {
            var packageRegistry = emfEditingContext.getDomain().getResourceSet().getPackageRegistry();
            packageRegistry.put(QuestionnairePackage.eNS_URI, QuestionnairePackage.eINSTANCE);
            packageRegistry.put(AnswerPackage.eNS_URI, AnswerPackage.eINSTANCE);
            packageRegistry.put(QLStylePackage.eNS_URI, QLStylePackage.eINSTANCE);

            emfEditingContext.getViews().add(getView("QuestionnaireView", QuestionnaireFormDescriptionProvider::new));
            emfEditingContext.getViews().add(getView("UserAnswerView", () -> new UserAnswerFormDescriptionProvider(generators)));
            emfEditingContext.getViews().add(getView("StatisticsView", StatisticsFormProvider::new));
            emfEditingContext.getViews().add(getView("QLStyleView", QLStyleFormDescriptionProvider::new));
        }
    }

    private View getView(String viewName, Supplier<IRepresentationDescriptionProvider> provider) {
        ViewBuilder viewBuilder = new ViewBuilder();
        View view = viewBuilder.build();

        view.getColorPalettes().add(this.createColorPalette());
        IColorProvider colorProvider = new ColorProvider(view);

        view.getDescriptions().add(provider.get().create(colorProvider));

        view.eAllContents().forEachRemaining(eObject -> {
            eObject.eAdapters().add(new IDAdapter(UUID.nameUUIDFromBytes(EcoreUtil.getURI(eObject).toString().getBytes())));
        });

        String resourcePath = UUID.nameUUIDFromBytes(viewName.getBytes()).toString();
        JsonResource resource = new JSONResourceFactory().createResourceFromPath(resourcePath);
        resource.eAdapters().add(new ResourceMetadataAdapter(viewName));
        resource.getContents().add(view);

        return view;
    }

    private ColorPalette createColorPalette() {
        var colorPalette = ViewFactory.eINSTANCE.createColorPalette();

        colorPalette.getColors().add(this.createFixedColor("Questionnaire_White", "#FFFFFF"));
        colorPalette.getColors().add(this.createFixedColor("Questionnaire_Gray", "#B1BCBE"));
        colorPalette.getColors().add(this.createFixedColor("Questionnaire_Orange", "#FBA600"));
        colorPalette.getColors().add(this.createFixedColor("Questionnaire_Red", "#DE1000"));
        colorPalette.getColors().add(this.createFixedColor("Questionnaire_Black", "#002B3C"));
        colorPalette.getColors().add(this.createFixedColor("Questionnaire_LightGray", "#F0F0F0"));
        colorPalette.getColors().add(this.createFixedColor("Questionnaire_AQL", "#FEF8E4"));

        return colorPalette;
    }

    private FixedColor createFixedColor(String name, String value) {
        var fixedColor = ViewFactory.eINSTANCE.createFixedColor();
        fixedColor.setName(name);
        fixedColor.setValue(value);

        return fixedColor;
    }
}
