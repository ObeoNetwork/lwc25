/**
 */
package org.eclipse.sirius.answer.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.sirius.answer.AnswerPackage;
import org.eclipse.sirius.answer.FormAnswers;
import org.eclipse.sirius.answer.UserAnswers;
import org.eclipse.sirius.questionnaire.Form;

import java.util.Collection;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Form
 * Answers</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.answer.impl.FormAnswersImpl#getForm
 * <em>Form</em>}</li>
 * <li>{@link org.eclipse.sirius.answer.impl.FormAnswersImpl#getUserAnswers
 * <em>User Answers</em>}</li>
 * <li>{@link org.eclipse.sirius.answer.impl.FormAnswersImpl#getUserId <em>User
 * Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FormAnswersImpl extends MinimalEObjectImpl.Container implements FormAnswers {
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
	 * The cached value of the '{@link #getUserAnswers() <em>User Answers</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getUserAnswers()
	 * @generated
	 * @ordered
	 */
	protected EList<UserAnswers> userAnswers;

	/**
	 * The default value of the '{@link #getUserId() <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getUserId()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserId() <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getUserId()
	 * @generated
	 * @ordered
	 */
	protected String userId = USER_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected FormAnswersImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnswerPackage.Literals.FORM_ANSWERS;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AnswerPackage.FORM_ANSWERS__FORM, oldForm,
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
			eNotify(new ENotificationImpl(this, Notification.SET, AnswerPackage.FORM_ANSWERS__FORM, oldForm, form));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<UserAnswers> getUserAnswers() {
		if (userAnswers == null) {
			userAnswers = new EObjectContainmentEList<>(UserAnswers.class, this,
					AnswerPackage.FORM_ANSWERS__USER_ANSWERS);
		}
		return userAnswers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getUserId() {
		return userId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setUserId(String newUserId) {
		String oldUserId = userId;
		userId = newUserId;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, AnswerPackage.FORM_ANSWERS__USER_ID, oldUserId,
					userId));
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
		case AnswerPackage.FORM_ANSWERS__USER_ANSWERS:
			return ((InternalEList<?>) getUserAnswers()).basicRemove(otherEnd, msgs);
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
		case AnswerPackage.FORM_ANSWERS__FORM:
			if (resolve) {
				return getForm();
			}
			return basicGetForm();
		case AnswerPackage.FORM_ANSWERS__USER_ANSWERS:
			return getUserAnswers();
		case AnswerPackage.FORM_ANSWERS__USER_ID:
			return getUserId();
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
		case AnswerPackage.FORM_ANSWERS__FORM:
			setForm((Form) newValue);
			return;
		case AnswerPackage.FORM_ANSWERS__USER_ANSWERS:
			getUserAnswers().clear();
			getUserAnswers().addAll((Collection<? extends UserAnswers>) newValue);
			return;
		case AnswerPackage.FORM_ANSWERS__USER_ID:
			setUserId((String) newValue);
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
		case AnswerPackage.FORM_ANSWERS__FORM:
			setForm((Form) null);
			return;
		case AnswerPackage.FORM_ANSWERS__USER_ANSWERS:
			getUserAnswers().clear();
			return;
		case AnswerPackage.FORM_ANSWERS__USER_ID:
			setUserId(USER_ID_EDEFAULT);
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
		case AnswerPackage.FORM_ANSWERS__FORM:
			return form != null;
		case AnswerPackage.FORM_ANSWERS__USER_ANSWERS:
			return userAnswers != null && !userAnswers.isEmpty();
		case AnswerPackage.FORM_ANSWERS__USER_ID:
			return USER_ID_EDEFAULT == null ? userId != null : !USER_ID_EDEFAULT.equals(userId);
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
		result.append(" (userId: ");
		result.append(userId);
		result.append(')');
		return result.toString();
	}

} // FormAnswersImpl
