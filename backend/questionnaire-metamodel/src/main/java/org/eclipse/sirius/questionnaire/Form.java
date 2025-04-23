/**
 */
package org.eclipse.sirius.questionnaire;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Form</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.questionnaire.Form#getElements
 * <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.questionnaire.QuestionnairePackage#getForm()
 * @model
 * @generated
 */
public interface Form extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link org.eclipse.sirius.questionnaire.QuestionnaireElement}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.eclipse.sirius.questionnaire.QuestionnairePackage#getForm_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<QuestionnaireElement> getElements();

} // Form
