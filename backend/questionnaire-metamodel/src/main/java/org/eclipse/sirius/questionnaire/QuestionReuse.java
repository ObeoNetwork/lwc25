/**
 */
package org.eclipse.sirius.questionnaire;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Question
 * Reuse</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.questionnaire.QuestionReuse#getQuestion
 * <em>Question</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.questionnaire.QuestionnairePackage#getQuestionReuse()
 * @model
 * @generated
 */
public interface QuestionReuse extends QuestionnaireElement {
	/**
	 * Returns the value of the '<em><b>Question</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Question</em>' reference.
	 * @see #setQuestion(Question)
	 * @see org.eclipse.sirius.questionnaire.QuestionnairePackage#getQuestionReuse_Question()
	 * @model
	 * @generated
	 */
	Question getQuestion();

	/**
	 * Sets the value of the
	 * '{@link org.eclipse.sirius.questionnaire.QuestionReuse#getQuestion
	 * <em>Question</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Question</em>' reference.
	 * @see #getQuestion()
	 * @generated
	 */
	void setQuestion(Question value);

} // QuestionReuse
