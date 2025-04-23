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
package org.eclipse.sirius.lwc25.questionnaire.starter.helper.api;

import org.eclipse.emf.ecore.resource.ResourceSet;

import java.util.UUID;

public interface IEmptyQuestionnaireProvider {
    UUID addEmptyQuestionnaire(ResourceSet resourceSet, String resourceName);
    UUID addEmptyAnswer(ResourceSet resourceSet, String resourceName);
}
