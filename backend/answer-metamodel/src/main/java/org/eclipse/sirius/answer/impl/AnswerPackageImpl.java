/**
 */
package org.eclipse.sirius.answer.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.sirius.answer.*;
import org.eclipse.sirius.questionnaire.QuestionnairePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class AnswerPackageImpl extends EPackageImpl implements AnswerPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass answerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass userAnswersEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass formAnswersEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method
	 * {@link #init init()}, which also performs initialization of the package, or
	 * returns the registered package, if one already exists. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.sirius.answer.AnswerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AnswerPackageImpl() {
		super(eNS_URI, AnswerFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and
	 * for any others upon which it depends.
	 *
	 * <p>
	 * This method is used to initialize {@link AnswerPackage#eINSTANCE} when that
	 * field is accessed. Clients should not invoke it directly. Instead, they
	 * should simply access that field to obtain the package. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AnswerPackage init() {
		if (isInited) {
			return (AnswerPackage) EPackage.Registry.INSTANCE.getEPackage(AnswerPackage.eNS_URI);
		}

		// Obtain or create and register package
		Object registeredAnswerPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		AnswerPackageImpl theAnswerPackage = registeredAnswerPackage instanceof AnswerPackageImpl
				? (AnswerPackageImpl) registeredAnswerPackage
				: new AnswerPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		QuestionnairePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theAnswerPackage.createPackageContents();

		// Initialize created meta-data
		theAnswerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAnswerPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AnswerPackage.eNS_URI, theAnswerPackage);
		return theAnswerPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getAnswer() {
		return answerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getAnswer_Answer() {
		return (EAttribute) answerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getAnswer_Question() {
		return (EReference) answerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getUserAnswers() {
		return userAnswersEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getUserAnswers_Name() {
		return (EAttribute) userAnswersEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getUserAnswers_Answers() {
		return (EReference) userAnswersEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getFormAnswers() {
		return formAnswersEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getFormAnswers_Form() {
		return (EReference) formAnswersEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getFormAnswers_UserAnswers() {
		return (EReference) formAnswersEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getFormAnswers_UserId() {
		return (EAttribute) formAnswersEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public AnswerFactory getAnswerFactory() {
		return (AnswerFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to
	 * have no affect on any invocation but its first. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) {
			return;
		}
		isCreated = true;

		// Create classes and their features
		answerEClass = createEClass(ANSWER);
		createEAttribute(answerEClass, ANSWER__ANSWER);
		createEReference(answerEClass, ANSWER__QUESTION);

		userAnswersEClass = createEClass(USER_ANSWERS);
		createEAttribute(userAnswersEClass, USER_ANSWERS__NAME);
		createEReference(userAnswersEClass, USER_ANSWERS__ANSWERS);

		formAnswersEClass = createEClass(FORM_ANSWERS);
		createEReference(formAnswersEClass, FORM_ANSWERS__FORM);
		createEReference(formAnswersEClass, FORM_ANSWERS__USER_ANSWERS);
		createEAttribute(formAnswersEClass, FORM_ANSWERS__USER_ID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This method is
	 * guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) {
			return;
		}
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		QuestionnairePackage theQuestionnairePackage = (QuestionnairePackage) EPackage.Registry.INSTANCE
				.getEPackage(QuestionnairePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(answerEClass, Answer.class, "Answer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnswer_Answer(), ecorePackage.getEString(), "answer", null, 0, 1, Answer.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnswer_Question(), theQuestionnairePackage.getQuestion(), null, "question", null, 1, 1,
				Answer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userAnswersEClass, UserAnswers.class, "UserAnswers", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUserAnswers_Name(), ecorePackage.getEString(), "name", null, 0, 1, UserAnswers.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserAnswers_Answers(), this.getAnswer(), null, "answers", null, 0, -1, UserAnswers.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(formAnswersEClass, FormAnswers.class, "FormAnswers", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFormAnswers_Form(), theQuestionnairePackage.getForm(), null, "form", null, 1, 1,
				FormAnswers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFormAnswers_UserAnswers(), this.getUserAnswers(), null, "userAnswers", null, 0, -1,
				FormAnswers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormAnswers_UserId(), ecorePackage.getEString(), "userId", null, 0, 1, FormAnswers.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // AnswerPackageImpl
