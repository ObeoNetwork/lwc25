/**
 */
package org.eclipse.sirius.qlstyle.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.sirius.qlstyle.QLStylePackage;
import org.eclipse.sirius.qlstyle.QuestionCustomization;
import org.eclipse.sirius.qlstyle.Widget;
import org.eclipse.sirius.questionnaire.QuestionnaireElement;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Question Customization</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.qlstyle.impl.QuestionCustomizationImpl#getHelpText
 * <em>Help Text</em>}</li>
 * <li>{@link org.eclipse.sirius.qlstyle.impl.QuestionCustomizationImpl#getWidget
 * <em>Widget</em>}</li>
 * <li>{@link org.eclipse.sirius.qlstyle.impl.QuestionCustomizationImpl#getQuestion
 * <em>Question</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QuestionCustomizationImpl extends MinimalEObjectImpl.Container implements QuestionCustomization {
	/**
	 * The default value of the '{@link #getHelpText() <em>Help Text</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getHelpText()
	 * @generated
	 * @ordered
	 */
	protected static final String HELP_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHelpText() <em>Help Text</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getHelpText()
	 * @generated
	 * @ordered
	 */
	protected String helpText = HELP_TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidget() <em>Widget</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getWidget()
	 * @generated
	 * @ordered
	 */
	protected static final Widget WIDGET_EDEFAULT = Widget.TEXTFIELD;

	/**
	 * The cached value of the '{@link #getWidget() <em>Widget</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getWidget()
	 * @generated
	 * @ordered
	 */
	protected Widget widget = WIDGET_EDEFAULT;

	/**
	 * The cached value of the '{@link #getQuestion() <em>Question</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getQuestion()
	 * @generated
	 * @ordered
	 */
	protected QuestionnaireElement question;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected QuestionCustomizationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QLStylePackage.Literals.QUESTION_CUSTOMIZATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getHelpText() {
		return helpText;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setHelpText(String newHelpText) {
		String oldHelpText = helpText;
		helpText = newHelpText;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, QLStylePackage.QUESTION_CUSTOMIZATION__HELP_TEXT,
					oldHelpText, helpText));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Widget getWidget() {
		return widget;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setWidget(Widget newWidget) {
		Widget oldWidget = widget;
		widget = newWidget == null ? WIDGET_EDEFAULT : newWidget;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, QLStylePackage.QUESTION_CUSTOMIZATION__WIDGET,
					oldWidget, widget));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public QuestionnaireElement getQuestion() {
		if (question != null && question.eIsProxy()) {
			InternalEObject oldQuestion = (InternalEObject) question;
			question = (QuestionnaireElement) eResolveProxy(oldQuestion);
			if (question != oldQuestion) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							QLStylePackage.QUESTION_CUSTOMIZATION__QUESTION, oldQuestion, question));
				}
			}
		}
		return question;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public QuestionnaireElement basicGetQuestion() {
		return question;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setQuestion(QuestionnaireElement newQuestion) {
		QuestionnaireElement oldQuestion = question;
		question = newQuestion;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, QLStylePackage.QUESTION_CUSTOMIZATION__QUESTION,
					oldQuestion, question));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case QLStylePackage.QUESTION_CUSTOMIZATION__HELP_TEXT:
			return getHelpText();
		case QLStylePackage.QUESTION_CUSTOMIZATION__WIDGET:
			return getWidget();
		case QLStylePackage.QUESTION_CUSTOMIZATION__QUESTION:
			if (resolve) {
				return getQuestion();
			}
			return basicGetQuestion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case QLStylePackage.QUESTION_CUSTOMIZATION__HELP_TEXT:
			setHelpText((String) newValue);
			return;
		case QLStylePackage.QUESTION_CUSTOMIZATION__WIDGET:
			setWidget((Widget) newValue);
			return;
		case QLStylePackage.QUESTION_CUSTOMIZATION__QUESTION:
			setQuestion((QuestionnaireElement) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case QLStylePackage.QUESTION_CUSTOMIZATION__HELP_TEXT:
			setHelpText(HELP_TEXT_EDEFAULT);
			return;
		case QLStylePackage.QUESTION_CUSTOMIZATION__WIDGET:
			setWidget(WIDGET_EDEFAULT);
			return;
		case QLStylePackage.QUESTION_CUSTOMIZATION__QUESTION:
			setQuestion((QuestionnaireElement) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case QLStylePackage.QUESTION_CUSTOMIZATION__HELP_TEXT:
			return HELP_TEXT_EDEFAULT == null ? helpText != null : !HELP_TEXT_EDEFAULT.equals(helpText);
		case QLStylePackage.QUESTION_CUSTOMIZATION__WIDGET:
			return widget != WIDGET_EDEFAULT;
		case QLStylePackage.QUESTION_CUSTOMIZATION__QUESTION:
			return question != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (helpText: ");
		result.append(helpText);
		result.append(", widget: ");
		result.append(widget);
		result.append(')');
		return result.toString();
	}

} // QuestionCustomizationImpl
