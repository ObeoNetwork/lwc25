/**
 */
package org.eclipse.sirius.questionnaire.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.sirius.questionnaire.IntegerType;
import org.eclipse.sirius.questionnaire.QuestionnairePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Integer
 * Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.questionnaire.impl.IntegerTypeImpl#getMin
 * <em>Min</em>}</li>
 * <li>{@link org.eclipse.sirius.questionnaire.impl.IntegerTypeImpl#getMax
 * <em>Max</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntegerTypeImpl extends MinimalEObjectImpl.Container implements IntegerType {
	/**
	 * The default value of the '{@link #getMin() <em>Min</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMin() <em>Min</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected int min = MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getMax() <em>Max</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMax() <em>Max</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected int max = MAX_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected IntegerTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QuestionnairePackage.Literals.INTEGER_TYPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int getMin() {
		return min;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setMin(int newMin) {
		int oldMin = min;
		min = newMin;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, QuestionnairePackage.INTEGER_TYPE__MIN, oldMin, min));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int getMax() {
		return max;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setMax(int newMax) {
		int oldMax = max;
		max = newMax;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, QuestionnairePackage.INTEGER_TYPE__MAX, oldMax, max));
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
		case QuestionnairePackage.INTEGER_TYPE__MIN:
			return getMin();
		case QuestionnairePackage.INTEGER_TYPE__MAX:
			return getMax();
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
		case QuestionnairePackage.INTEGER_TYPE__MIN:
			setMin((Integer) newValue);
			return;
		case QuestionnairePackage.INTEGER_TYPE__MAX:
			setMax((Integer) newValue);
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
		case QuestionnairePackage.INTEGER_TYPE__MIN:
			setMin(MIN_EDEFAULT);
			return;
		case QuestionnairePackage.INTEGER_TYPE__MAX:
			setMax(MAX_EDEFAULT);
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
		case QuestionnairePackage.INTEGER_TYPE__MIN:
			return min != MIN_EDEFAULT;
		case QuestionnairePackage.INTEGER_TYPE__MAX:
			return max != MAX_EDEFAULT;
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
		result.append(" (min: ");
		result.append(min);
		result.append(", max: ");
		result.append(max);
		result.append(')');
		return result.toString();
	}

} // IntegerTypeImpl
