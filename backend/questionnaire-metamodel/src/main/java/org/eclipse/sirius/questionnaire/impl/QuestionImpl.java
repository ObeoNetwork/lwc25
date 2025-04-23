/**
 */
package org.eclipse.sirius.questionnaire.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.sirius.questionnaire.NamedElement;
import org.eclipse.sirius.questionnaire.Question;
import org.eclipse.sirius.questionnaire.QuestionnairePackage;
import org.eclipse.sirius.questionnaire.Type;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Question</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.questionnaire.impl.QuestionImpl#getName
 * <em>Name</em>}</li>
 * <li>{@link org.eclipse.sirius.questionnaire.impl.QuestionImpl#getLabel
 * <em>Label</em>}</li>
 * <li>{@link org.eclipse.sirius.questionnaire.impl.QuestionImpl#getType
 * <em>Type</em>}</li>
 * <li>{@link org.eclipse.sirius.questionnaire.impl.QuestionImpl#getComputedExpression
 * <em>Computed Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QuestionImpl extends MinimalEObjectImpl.Container implements Question {
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
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;

	/**
	 * The default value of the '{@link #getComputedExpression() <em>Computed
	 * Expression</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getComputedExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPUTED_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComputedExpression() <em>Computed
	 * Expression</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getComputedExpression()
	 * @generated
	 * @ordered
	 */
	protected String computedExpression = COMPUTED_EXPRESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected QuestionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QuestionnairePackage.Literals.QUESTION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, QuestionnairePackage.QUESTION__NAME, oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, QuestionnairePackage.QUESTION__LABEL, oldLabel,
					label));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Type getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetType(Type newType, NotificationChain msgs) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					QuestionnairePackage.QUESTION__TYPE, oldType, newType);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setType(Type newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null) {
				msgs = ((InternalEObject) type).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - QuestionnairePackage.QUESTION__TYPE, null, msgs);
			}
			if (newType != null) {
				msgs = ((InternalEObject) newType).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - QuestionnairePackage.QUESTION__TYPE, null, msgs);
			}
			msgs = basicSetType(newType, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, QuestionnairePackage.QUESTION__TYPE, newType,
					newType));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getComputedExpression() {
		return computedExpression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setComputedExpression(String newComputedExpression) {
		String oldComputedExpression = computedExpression;
		computedExpression = newComputedExpression;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, QuestionnairePackage.QUESTION__COMPUTED_EXPRESSION,
					oldComputedExpression, computedExpression));
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
		case QuestionnairePackage.QUESTION__TYPE:
			return basicSetType(null, msgs);
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
		case QuestionnairePackage.QUESTION__NAME:
			return getName();
		case QuestionnairePackage.QUESTION__LABEL:
			return getLabel();
		case QuestionnairePackage.QUESTION__TYPE:
			return getType();
		case QuestionnairePackage.QUESTION__COMPUTED_EXPRESSION:
			return getComputedExpression();
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
		case QuestionnairePackage.QUESTION__NAME:
			setName((String) newValue);
			return;
		case QuestionnairePackage.QUESTION__LABEL:
			setLabel((String) newValue);
			return;
		case QuestionnairePackage.QUESTION__TYPE:
			setType((Type) newValue);
			return;
		case QuestionnairePackage.QUESTION__COMPUTED_EXPRESSION:
			setComputedExpression((String) newValue);
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
		case QuestionnairePackage.QUESTION__NAME:
			setName(NAME_EDEFAULT);
			return;
		case QuestionnairePackage.QUESTION__LABEL:
			setLabel(LABEL_EDEFAULT);
			return;
		case QuestionnairePackage.QUESTION__TYPE:
			setType((Type) null);
			return;
		case QuestionnairePackage.QUESTION__COMPUTED_EXPRESSION:
			setComputedExpression(COMPUTED_EXPRESSION_EDEFAULT);
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
		case QuestionnairePackage.QUESTION__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case QuestionnairePackage.QUESTION__LABEL:
			return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
		case QuestionnairePackage.QUESTION__TYPE:
			return type != null;
		case QuestionnairePackage.QUESTION__COMPUTED_EXPRESSION:
			return COMPUTED_EXPRESSION_EDEFAULT == null ? computedExpression != null
					: !COMPUTED_EXPRESSION_EDEFAULT.equals(computedExpression);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
			case QuestionnairePackage.QUESTION__NAME:
				return QuestionnairePackage.NAMED_ELEMENT__NAME;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
			case QuestionnairePackage.NAMED_ELEMENT__NAME:
				return QuestionnairePackage.QUESTION__NAME;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(", label: ");
		result.append(label);
		result.append(", computedExpression: ");
		result.append(computedExpression);
		result.append(')');
		return result.toString();
	}

} // QuestionImpl
