/**
 */
package org.eclipse.sirius.answer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.questionnaire.Form;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Form
 * Answers</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.answer.FormAnswers#getForm <em>Form</em>}</li>
 * <li>{@link org.eclipse.sirius.answer.FormAnswers#getUserAnswers <em>User
 * Answers</em>}</li>
 * <li>{@link org.eclipse.sirius.answer.FormAnswers#getUserId <em>User
 * Id</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.answer.AnswerPackage#getFormAnswers()
 * @model
 * @generated
 */
public interface FormAnswers extends EObject {
	/**
	 * Returns the value of the '<em><b>Form</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Form</em>' reference.
	 * @see #setForm(Form)
	 * @see org.eclipse.sirius.answer.AnswerPackage#getFormAnswers_Form()
	 * @model required="true"
	 * @generated
	 */
	Form getForm();

	/**
	 * Sets the value of the '{@link org.eclipse.sirius.answer.FormAnswers#getForm
	 * <em>Form</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Form</em>' reference.
	 * @see #getForm()
	 * @generated
	 */
	void setForm(Form value);

	/**
	 * Returns the value of the '<em><b>User Answers</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link org.eclipse.sirius.answer.UserAnswers}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @return the value of the '<em>User Answers</em>' containment reference list.
	 * @see org.eclipse.sirius.answer.AnswerPackage#getFormAnswers_UserAnswers()
	 * @model containment="true"
	 * @generated
	 */
	EList<UserAnswers> getUserAnswers();

	/**
	 * Returns the value of the '<em><b>User Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>User Id</em>' attribute.
	 * @see #setUserId(String)
	 * @see org.eclipse.sirius.answer.AnswerPackage#getFormAnswers_UserId()
	 * @model
	 * @generated
	 */
	String getUserId();

	/**
	 * Sets the value of the '{@link org.eclipse.sirius.answer.FormAnswers#getUserId
	 * <em>User Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>User Id</em>' attribute.
	 * @see #getUserId()
	 * @generated
	 */
	void setUserId(String value);

} // FormAnswers
