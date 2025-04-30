/**
 */
package org.eclipse.sirius.qlstyle;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.questionnaire.Form;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>QL
 * Style</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.qlstyle.QLStyle#getForm <em>Form</em>}</li>
 * <li>{@link org.eclipse.sirius.qlstyle.QLStyle#getElements
 * <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.qlstyle.QLStylePackage#getQLStyle()
 * @model
 * @generated
 */
public interface QLStyle extends EObject {
	/**
	 * Returns the value of the '<em><b>Form</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Form</em>' reference.
	 * @see #setForm(Form)
	 * @see org.eclipse.sirius.qlstyle.QLStylePackage#getQLStyle_Form()
	 * @model required="true"
	 * @generated
	 */
	Form getForm();

	/**
	 * Sets the value of the '{@link org.eclipse.sirius.qlstyle.QLStyle#getForm
	 * <em>Form</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Form</em>' reference.
	 * @see #getForm()
	 * @generated
	 */
	void setForm(Form value);

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link org.eclipse.sirius.qlstyle.QLStyleElement}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.eclipse.sirius.qlstyle.QLStylePackage#getQLStyle_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<QLStyleElement> getElements();

} // QLStyle
