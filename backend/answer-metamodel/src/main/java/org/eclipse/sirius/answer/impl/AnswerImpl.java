/**
 */
package org.eclipse.sirius.answer.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.sirius.answer.Answer;
import org.eclipse.sirius.answer.AnswerPackage;
import org.eclipse.sirius.questionnaire.Question;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Answer</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.answer.impl.AnswerImpl#getAnswer
 * <em>Answer</em>}</li>
 * <li>{@link org.eclipse.sirius.answer.impl.AnswerImpl#getQuestion
 * <em>Question</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnswerImpl extends MinimalEObjectImpl.Container implements Answer {
	/**
	 * The default value of the '{@link #getAnswer() <em>Answer</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getAnswer()
	 * @generated
	 * @ordered
	 */
	protected static final String ANSWER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAnswer() <em>Answer</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getAnswer()
	 * @generated
	 * @ordered
	 */
	protected String answer = ANSWER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getQuestion() <em>Question</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getQuestion()
	 * @generated
	 * @ordered
	 */
	protected Question question;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected AnswerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnswerPackage.Literals.ANSWER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getAnswer() {
		return answer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setAnswer(String newAnswer) {
		String oldAnswer = answer;
		answer = newAnswer;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, AnswerPackage.ANSWER__ANSWER, oldAnswer, answer));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Question getQuestion() {
		if (question != null && question.eIsProxy()) {
			InternalEObject oldQuestion = (InternalEObject) question;
			question = (Question) eResolveProxy(oldQuestion);
			if (question != oldQuestion) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AnswerPackage.ANSWER__QUESTION,
							oldQuestion, question));
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
	public Question basicGetQuestion() {
		return question;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setQuestion(Question newQuestion) {
		Question oldQuestion = question;
		question = newQuestion;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, AnswerPackage.ANSWER__QUESTION, oldQuestion,
					question));
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
		case AnswerPackage.ANSWER__ANSWER:
			return getAnswer();
		case AnswerPackage.ANSWER__QUESTION:
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
		case AnswerPackage.ANSWER__ANSWER:
			setAnswer((String) newValue);
			return;
		case AnswerPackage.ANSWER__QUESTION:
			setQuestion((Question) newValue);
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
		case AnswerPackage.ANSWER__ANSWER:
			setAnswer(ANSWER_EDEFAULT);
			return;
		case AnswerPackage.ANSWER__QUESTION:
			setQuestion((Question) null);
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
		case AnswerPackage.ANSWER__ANSWER:
			return ANSWER_EDEFAULT == null ? answer != null : !ANSWER_EDEFAULT.equals(answer);
		case AnswerPackage.ANSWER__QUESTION:
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
		result.append(" (answer: ");
		result.append(answer);
		result.append(')');
		return result.toString();
	}

} // AnswerImpl
