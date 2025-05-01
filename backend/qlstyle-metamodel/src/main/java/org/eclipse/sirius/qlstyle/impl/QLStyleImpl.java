/**
 */
package org.eclipse.sirius.qlstyle.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.sirius.qlstyle.QLStyle;
import org.eclipse.sirius.qlstyle.QLStyleElement;
import org.eclipse.sirius.qlstyle.QLStylePackage;
import org.eclipse.sirius.questionnaire.Form;

import java.util.Collection;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>QL
 * Style</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.qlstyle.impl.QLStyleImpl#getForm
 * <em>Form</em>}</li>
 * <li>{@link org.eclipse.sirius.qlstyle.impl.QLStyleImpl#getElements
 * <em>Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QLStyleImpl extends MinimalEObjectImpl.Container implements QLStyle {
	/**
	 * The cached value of the '{@link #getForm() <em>Form</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getForm()
	 * @generated
	 * @ordered
	 */
	protected Form form;

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
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
	protected QLStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QLStylePackage.Literals.QL_STYLE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Form getForm() {
		if (form != null && form.eIsProxy()) {
			InternalEObject oldForm = (InternalEObject) form;
			form = (Form) eResolveProxy(oldForm);
			if (form != oldForm) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QLStylePackage.QL_STYLE__FORM, oldForm,
							form));
				}
			}
		}
		return form;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Form basicGetForm() {
		return form;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setForm(Form newForm) {
		Form oldForm = form;
		form = newForm;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, QLStylePackage.QL_STYLE__FORM, oldForm, form));
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
			elements = new EObjectContainmentEList<>(QLStyleElement.class, this,
					QLStylePackage.QL_STYLE__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case QLStylePackage.QL_STYLE__ELEMENTS:
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
		case QLStylePackage.QL_STYLE__FORM:
			if (resolve) {
				return getForm();
			}
			return basicGetForm();
		case QLStylePackage.QL_STYLE__ELEMENTS:
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
		case QLStylePackage.QL_STYLE__FORM:
			setForm((Form) newValue);
			return;
		case QLStylePackage.QL_STYLE__ELEMENTS:
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
		case QLStylePackage.QL_STYLE__FORM:
			setForm((Form) null);
			return;
		case QLStylePackage.QL_STYLE__ELEMENTS:
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
		case QLStylePackage.QL_STYLE__FORM:
			return form != null;
		case QLStylePackage.QL_STYLE__ELEMENTS:
			return elements != null && !elements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // QLStyleImpl
