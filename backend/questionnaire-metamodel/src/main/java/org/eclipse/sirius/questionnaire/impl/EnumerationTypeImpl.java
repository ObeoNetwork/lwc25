/**
 */
package org.eclipse.sirius.questionnaire.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.sirius.questionnaire.EnumerationLiteral;
import org.eclipse.sirius.questionnaire.EnumerationType;
import org.eclipse.sirius.questionnaire.QuestionnairePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Enumeration Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.questionnaire.impl.EnumerationTypeImpl#getEnumerationliteral
 * <em>Enumerationliteral</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumerationTypeImpl extends MinimalEObjectImpl.Container implements EnumerationType {
	/**
	 * The cached value of the '{@link #getEnumerationliteral()
	 * <em>Enumerationliteral</em>}' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @see #getEnumerationliteral()
	 * @generated
	 * @ordered
	 */
	protected EList<EnumerationLiteral> enumerationliteral;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected EnumerationTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QuestionnairePackage.Literals.ENUMERATION_TYPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<EnumerationLiteral> getEnumerationliteral() {
		if (enumerationliteral == null) {
			enumerationliteral = new EObjectContainmentEList<>(EnumerationLiteral.class, this,
					QuestionnairePackage.ENUMERATION_TYPE__ENUMERATIONLITERAL);
		}
		return enumerationliteral;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case QuestionnairePackage.ENUMERATION_TYPE__ENUMERATIONLITERAL:
			return ((InternalEList<?>) getEnumerationliteral()).basicRemove(otherEnd, msgs);
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
		case QuestionnairePackage.ENUMERATION_TYPE__ENUMERATIONLITERAL:
			return getEnumerationliteral();
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
		case QuestionnairePackage.ENUMERATION_TYPE__ENUMERATIONLITERAL:
			getEnumerationliteral().clear();
			getEnumerationliteral().addAll((Collection<? extends EnumerationLiteral>) newValue);
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
		case QuestionnairePackage.ENUMERATION_TYPE__ENUMERATIONLITERAL:
			getEnumerationliteral().clear();
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
		case QuestionnairePackage.ENUMERATION_TYPE__ENUMERATIONLITERAL:
			return enumerationliteral != null && !enumerationliteral.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // EnumerationTypeImpl
