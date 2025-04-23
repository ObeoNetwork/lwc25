/**
 */
package org.eclipse.sirius.answer.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.sirius.answer.Answer;
import org.eclipse.sirius.answer.AnswerPackage;
import org.eclipse.sirius.answer.UserAnswers;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>User
 * Answers</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.answer.impl.UserAnswersImpl#getName
 * <em>Name</em>}</li>
 * <li>{@link org.eclipse.sirius.answer.impl.UserAnswersImpl#getAnswers
 * <em>Answers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UserAnswersImpl extends MinimalEObjectImpl.Container implements UserAnswers {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnswers() <em>Answers</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getAnswers()
	 * @generated
	 * @ordered
	 */
	protected EList<Answer> answers;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected UserAnswersImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnswerPackage.Literals.USER_ANSWERS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, AnswerPackage.USER_ANSWERS__NAME, oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<Answer> getAnswers() {
		if (answers == null) {
			answers = new EObjectContainmentEList<>(Answer.class, this, AnswerPackage.USER_ANSWERS__ANSWERS);
		}
		return answers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case AnswerPackage.USER_ANSWERS__ANSWERS:
			return ((InternalEList<?>) getAnswers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case AnswerPackage.USER_ANSWERS__NAME:
			return getName();
		case AnswerPackage.USER_ANSWERS__ANSWERS:
			return getAnswers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case AnswerPackage.USER_ANSWERS__NAME:
			setName((String) newValue);
			return;
		case AnswerPackage.USER_ANSWERS__ANSWERS:
			getAnswers().clear();
			getAnswers().addAll((Collection<? extends Answer>) newValue);
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
		case AnswerPackage.USER_ANSWERS__NAME:
			setName(NAME_EDEFAULT);
			return;
		case AnswerPackage.USER_ANSWERS__ANSWERS:
			getAnswers().clear();
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
		case AnswerPackage.USER_ANSWERS__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case AnswerPackage.USER_ANSWERS__ANSWERS:
			return answers != null && !answers.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} // UserAnswersImpl
