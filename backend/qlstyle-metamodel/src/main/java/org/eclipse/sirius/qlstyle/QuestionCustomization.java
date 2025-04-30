/**
 */
package org.eclipse.sirius.qlstyle;

import org.eclipse.sirius.questionnaire.QuestionnaireElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Question
 * Customization</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.qlstyle.QuestionCustomization#getHelpText
 * <em>Help Text</em>}</li>
 * <li>{@link org.eclipse.sirius.qlstyle.QuestionCustomization#getWidget
 * <em>Widget</em>}</li>
 * <li>{@link org.eclipse.sirius.qlstyle.QuestionCustomization#getQuestion
 * <em>Question</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.qlstyle.QLStylePackage#getQuestionCustomization()
 * @model
 * @generated
 */
public interface QuestionCustomization extends QLStyleElement {
	/**
	 * Returns the value of the '<em><b>Help Text</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Help Text</em>' attribute.
	 * @see #setHelpText(String)
	 * @see org.eclipse.sirius.qlstyle.QLStylePackage#getQuestionCustomization_HelpText()
	 * @model
	 * @generated
	 */
	String getHelpText();

	/**
	 * Sets the value of the
	 * '{@link org.eclipse.sirius.qlstyle.QuestionCustomization#getHelpText <em>Help
	 * Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Help Text</em>' attribute.
	 * @see #getHelpText()
	 * @generated
	 */
	void setHelpText(String value);

	/**
	 * Returns the value of the '<em><b>Widget</b></em>' attribute. The literals are
	 * from the enumeration {@link org.eclipse.sirius.qlstyle.Widget}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Widget</em>' attribute.
	 * @see org.eclipse.sirius.qlstyle.Widget
	 * @see #setWidget(Widget)
	 * @see org.eclipse.sirius.qlstyle.QLStylePackage#getQuestionCustomization_Widget()
	 * @model required="true"
	 * @generated
	 */
	Widget getWidget();

	/**
	 * Sets the value of the
	 * '{@link org.eclipse.sirius.qlstyle.QuestionCustomization#getWidget
	 * <em>Widget</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Widget</em>' attribute.
	 * @see org.eclipse.sirius.qlstyle.Widget
	 * @see #getWidget()
	 * @generated
	 */
	void setWidget(Widget value);

	/**
	 * Returns the value of the '<em><b>Question</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Question</em>' reference.
	 * @see #setQuestion(QuestionnaireElement)
	 * @see org.eclipse.sirius.qlstyle.QLStylePackage#getQuestionCustomization_Question()
	 * @model required="true"
	 * @generated
	 */
	QuestionnaireElement getQuestion();

	/**
	 * Sets the value of the
	 * '{@link org.eclipse.sirius.qlstyle.QuestionCustomization#getQuestion
	 * <em>Question</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Question</em>' reference.
	 * @see #getQuestion()
	 * @generated
	 */
	void setQuestion(QuestionnaireElement value);

} // QuestionCustomization
