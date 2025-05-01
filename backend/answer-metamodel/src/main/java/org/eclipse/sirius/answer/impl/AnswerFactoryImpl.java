/**
 */
package org.eclipse.sirius.answer.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.sirius.answer.*;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class AnswerFactoryImpl extends EFactoryImpl implements AnswerFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	public static AnswerFactory init() {
		try {
			AnswerFactory theAnswerFactory = (AnswerFactory) EPackage.Registry.INSTANCE
					.getEFactory(AnswerPackage.eNS_URI);
			if (theAnswerFactory != null) {
				return theAnswerFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AnswerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	public AnswerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case AnswerPackage.ANSWER:
			return createAnswer();
		case AnswerPackage.USER_ANSWERS:
			return createUserAnswers();
		case AnswerPackage.FORM_ANSWERS:
			return createFormAnswers();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Answer createAnswer() {
		AnswerImpl answer = new AnswerImpl();
		return answer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public UserAnswers createUserAnswers() {
		UserAnswersImpl userAnswers = new UserAnswersImpl();
		return userAnswers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public FormAnswers createFormAnswers() {
		FormAnswersImpl formAnswers = new FormAnswersImpl();
		return formAnswers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public AnswerPackage getAnswerPackage() {
		return (AnswerPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AnswerPackage getPackage() {
		return AnswerPackage.eINSTANCE;
	}

} // AnswerFactoryImpl
