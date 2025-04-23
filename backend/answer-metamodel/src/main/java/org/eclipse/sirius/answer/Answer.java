/**
 */
package org.eclipse.sirius.answer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.questionnaire.Question;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Answer</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.answer.Answer#getAnswer <em>Answer</em>}</li>
 * <li>{@link org.eclipse.sirius.answer.Answer#getQuestion
 * <em>Question</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.answer.AnswerPackage#getAnswer()
 * @model
 * @generated
 */
public interface Answer extends EObject {
	/**
	 * Returns the value of the '<em><b>Answer</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Answer</em>' attribute.
	 * @see #setAnswer(String)
	 * @see org.eclipse.sirius.answer.AnswerPackage#getAnswer_Answer()
	 * @model
	 * @generated
	 */
	String getAnswer();

	/**
	 * Sets the value of the '{@link org.eclipse.sirius.answer.Answer#getAnswer
	 * <em>Answer</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Answer</em>' attribute.
	 * @see #getAnswer()
	 * @generated
	 */
	void setAnswer(String value);

	/**
	 * Returns the value of the '<em><b>Question</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Question</em>' reference.
	 * @see #setQuestion(Question)
	 * @see org.eclipse.sirius.answer.AnswerPackage#getAnswer_Question()
	 * @model required="true"
	 * @generated
	 */
	Question getQuestion();

	/**
	 * Sets the value of the '{@link org.eclipse.sirius.answer.Answer#getQuestion
	 * <em>Question</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Question</em>' reference.
	 * @see #getQuestion()
	 * @generated
	 */
	void setQuestion(Question value);

} // Answer
