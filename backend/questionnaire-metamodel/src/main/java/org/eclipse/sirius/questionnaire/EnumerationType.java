/**
 */
package org.eclipse.sirius.questionnaire;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Enumeration Type</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.questionnaire.EnumerationType#getEnumerationliteral
 * <em>Enumerationliteral</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.questionnaire.QuestionnairePackage#getEnumerationType()
 * @model
 * @generated
 */
public interface EnumerationType extends Type {
	/**
	 * Returns the value of the '<em><b>Enumerationliteral</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link org.eclipse.sirius.questionnaire.EnumerationLiteral}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Enumerationliteral</em>' containment reference
	 *         list.
	 * @see org.eclipse.sirius.questionnaire.QuestionnairePackage#getEnumerationType_Enumerationliteral()
	 * @model containment="true"
	 * @generated
	 */
	EList<EnumerationLiteral> getEnumerationliteral();

} // EnumerationType
