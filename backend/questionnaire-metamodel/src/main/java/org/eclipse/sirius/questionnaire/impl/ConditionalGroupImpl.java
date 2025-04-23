/**
 */
package org.eclipse.sirius.questionnaire.impl;

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
import org.eclipse.sirius.questionnaire.ConditionalGroup;
import org.eclipse.sirius.questionnaire.QuestionnaireElement;
import org.eclipse.sirius.questionnaire.QuestionnairePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Conditional Group</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.questionnaire.impl.ConditionalGroupImpl#getElements
 * <em>Elements</em>}</li>
 * <li>{@link org.eclipse.sirius.questionnaire.impl.ConditionalGroupImpl#getCondition
 * <em>Condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConditionalGroupImpl extends MinimalEObjectImpl.Container implements ConditionalGroup {
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<QuestionnaireElement> elements;

	/**
	 * The default value of the '{@link #getCondition() <em>Condition</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected String condition = CONDITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ConditionalGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QuestionnairePackage.Literals.CONDITIONAL_GROUP;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<QuestionnaireElement> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<>(QuestionnaireElement.class, this,
					QuestionnairePackage.CONDITIONAL_GROUP__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setCondition(String newCondition) {
		String oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, QuestionnairePackage.CONDITIONAL_GROUP__CONDITION,
					oldCondition, condition));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case QuestionnairePackage.CONDITIONAL_GROUP__ELEMENTS:
			return ((InternalEList<?>) getElements()).basicRemove(otherEnd, msgs);
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
		case QuestionnairePackage.CONDITIONAL_GROUP__ELEMENTS:
			return getElements();
		case QuestionnairePackage.CONDITIONAL_GROUP__CONDITION:
			return getCondition();
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
		case QuestionnairePackage.CONDITIONAL_GROUP__ELEMENTS:
			getElements().clear();
			getElements().addAll((Collection<? extends QuestionnaireElement>) newValue);
			return;
		case QuestionnairePackage.CONDITIONAL_GROUP__CONDITION:
			setCondition((String) newValue);
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
		case QuestionnairePackage.CONDITIONAL_GROUP__ELEMENTS:
			getElements().clear();
			return;
		case QuestionnairePackage.CONDITIONAL_GROUP__CONDITION:
			setCondition(CONDITION_EDEFAULT);
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
		case QuestionnairePackage.CONDITIONAL_GROUP__ELEMENTS:
			return elements != null && !elements.isEmpty();
		case QuestionnairePackage.CONDITIONAL_GROUP__CONDITION:
			return CONDITION_EDEFAULT == null ? condition != null : !CONDITION_EDEFAULT.equals(condition);
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
		result.append(" (condition: ");
		result.append(condition);
		result.append(')');
		return result.toString();
	}

} // ConditionalGroupImpl
