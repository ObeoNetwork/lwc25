/**
 */
package org.eclipse.sirius.questionnaire;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Question</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.questionnaire.Question#getLabel
 * <em>Label</em>}</li>
 * <li>{@link org.eclipse.sirius.questionnaire.Question#getType
 * <em>Type</em>}</li>
 * <li>{@link org.eclipse.sirius.questionnaire.Question#getComputedExpression
 * <em>Computed Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.questionnaire.Question#isRequired
 * <em>Required</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.questionnaire.QuestionnairePackage#getQuestion()
 * @model
 * @generated
 */
public interface Question extends QuestionnaireElement, NamedElement {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipse.sirius.questionnaire.QuestionnairePackage#getQuestion_Label()
	 * @model required="true"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the
	 * '{@link org.eclipse.sirius.questionnaire.Question#getLabel <em>Label</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(Type)
	 * @see org.eclipse.sirius.questionnaire.QuestionnairePackage#getQuestion_Type()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the
	 * '{@link org.eclipse.sirius.questionnaire.Question#getType <em>Type</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Computed Expression</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Computed Expression</em>' attribute.
	 * @see #setComputedExpression(String)
	 * @see org.eclipse.sirius.questionnaire.QuestionnairePackage#getQuestion_ComputedExpression()
	 * @model
	 * @generated
	 */
	String getComputedExpression();

	/**
	 * Sets the value of the
	 * '{@link org.eclipse.sirius.questionnaire.Question#getComputedExpression
	 * <em>Computed Expression</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @param value the new value of the '<em>Computed Expression</em>' attribute.
	 * @see #getComputedExpression()
	 * @generated
	 */
	void setComputedExpression(String value);

	/**
	 * Returns the value of the '<em><b>Required</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Required</em>' attribute.
	 * @see #setRequired(boolean)
	 * @see org.eclipse.sirius.questionnaire.QuestionnairePackage#getQuestion_Required()
	 * @model
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Sets the value of the
	 * '{@link org.eclipse.sirius.questionnaire.Question#isRequired
	 * <em>Required</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #isRequired()
	 * @generated
	 */
	void setRequired(boolean value);

} // Question
