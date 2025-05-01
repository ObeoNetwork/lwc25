/**
 */
package org.eclipse.sirius.qlstyle.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.sirius.qlstyle.Group;
import org.eclipse.sirius.qlstyle.GroupLayout;
import org.eclipse.sirius.qlstyle.QLStyleElement;
import org.eclipse.sirius.qlstyle.QLStylePackage;

import java.util.Collection;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Group</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.qlstyle.impl.GroupImpl#getName
 * <em>Name</em>}</li>
 * <li>{@link org.eclipse.sirius.qlstyle.impl.GroupImpl#getDescription
 * <em>Description</em>}</li>
 * <li>{@link org.eclipse.sirius.qlstyle.impl.GroupImpl#getLayout
 * <em>Layout</em>}</li>
 * <li>{@link org.eclipse.sirius.qlstyle.impl.GroupImpl#getElements
 * <em>Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupImpl extends MinimalEObjectImpl.Container implements Group {
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
	 * The default value of the '{@link #getDescription() <em>Description</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLayout() <em>Layout</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getLayout()
	 * @generated
	 * @ordered
	 */
	protected static final GroupLayout LAYOUT_EDEFAULT = GroupLayout.VERTICAL;

	/**
	 * The cached value of the '{@link #getLayout() <em>Layout</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getLayout()
	 * @generated
	 * @ordered
	 */
	protected GroupLayout layout = LAYOUT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<QLStyleElement> elements;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected GroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QLStylePackage.Literals.GROUP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, QLStylePackage.GROUP__NAME, oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, QLStylePackage.GROUP__DESCRIPTION, oldDescription,
					description));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public GroupLayout getLayout() {
		return layout;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setLayout(GroupLayout newLayout) {
		GroupLayout oldLayout = layout;
		layout = newLayout == null ? LAYOUT_EDEFAULT : newLayout;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, QLStylePackage.GROUP__LAYOUT, oldLayout, layout));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<QLStyleElement> getElements() {
		if (elements == null) {
			elements = new EObjectResolvingEList<>(QLStyleElement.class, this,
					QLStylePackage.GROUP__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case QLStylePackage.GROUP__NAME:
			return getName();
		case QLStylePackage.GROUP__DESCRIPTION:
			return getDescription();
		case QLStylePackage.GROUP__LAYOUT:
			return getLayout();
		case QLStylePackage.GROUP__ELEMENTS:
			return getElements();
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
		case QLStylePackage.GROUP__NAME:
			setName((String) newValue);
			return;
		case QLStylePackage.GROUP__DESCRIPTION:
			setDescription((String) newValue);
			return;
		case QLStylePackage.GROUP__LAYOUT:
			setLayout((GroupLayout) newValue);
			return;
		case QLStylePackage.GROUP__ELEMENTS:
			getElements().clear();
			getElements().addAll((Collection<? extends QLStyleElement>) newValue);
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
		case QLStylePackage.GROUP__NAME:
			setName(NAME_EDEFAULT);
			return;
		case QLStylePackage.GROUP__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		case QLStylePackage.GROUP__LAYOUT:
			setLayout(LAYOUT_EDEFAULT);
			return;
		case QLStylePackage.GROUP__ELEMENTS:
			getElements().clear();
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
		case QLStylePackage.GROUP__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case QLStylePackage.GROUP__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		case QLStylePackage.GROUP__LAYOUT:
			return layout != LAYOUT_EDEFAULT;
		case QLStylePackage.GROUP__ELEMENTS:
			return elements != null && !elements.isEmpty();
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
		result.append(", description: ");
		result.append(description);
		result.append(", layout: ");
		result.append(layout);
		result.append(')');
		return result.toString();
	}

} // GroupImpl
