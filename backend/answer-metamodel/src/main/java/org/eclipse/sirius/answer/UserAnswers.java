/**
 */
package org.eclipse.sirius.answer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>User
 * Answers</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.answer.UserAnswers#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.sirius.answer.UserAnswers#getAnswers
 * <em>Answers</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.answer.AnswerPackage#getUserAnswers()
 * @model
 * @generated
 */
public interface UserAnswers extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.sirius.answer.AnswerPackage#getUserAnswers_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.sirius.answer.UserAnswers#getName
	 * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Answers</b></em>' containment reference
	 * list. The list contents are of type {@link org.eclipse.sirius.answer.Answer}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Answers</em>' containment reference list.
	 * @see org.eclipse.sirius.answer.AnswerPackage#getUserAnswers_Answers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Answer> getAnswers();

} // UserAnswers
