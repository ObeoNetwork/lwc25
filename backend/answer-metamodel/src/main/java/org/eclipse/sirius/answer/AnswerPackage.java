/**
 */
package org.eclipse.sirius.answer;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.sirius.answer.AnswerFactory
 * @model kind="package"
 * @generated
 */
public interface AnswerPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNAME = "answer";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/answer";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_PREFIX = "answer";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	AnswerPackage eINSTANCE = org.eclipse.sirius.answer.impl.AnswerPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.sirius.answer.impl.AnswerImpl
	 * <em>Answer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.answer.impl.AnswerImpl
	 * @see org.eclipse.sirius.answer.impl.AnswerPackageImpl#getAnswer()
	 * @generated
	 */
	int ANSWER = 0;

	/**
	 * The feature id for the '<em><b>Answer</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ANSWER__ANSWER = 0;

	/**
	 * The feature id for the '<em><b>Question</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ANSWER__QUESTION = 1;

	/**
	 * The number of structural features of the '<em>Answer</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ANSWER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Answer</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ANSWER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.sirius.answer.impl.UserAnswersImpl <em>User
	 * Answers</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.answer.impl.UserAnswersImpl
	 * @see org.eclipse.sirius.answer.impl.AnswerPackageImpl#getUserAnswers()
	 * @generated
	 */
	int USER_ANSWERS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int USER_ANSWERS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Answers</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int USER_ANSWERS__ANSWERS = 1;

	/**
	 * The number of structural features of the '<em>User Answers</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int USER_ANSWERS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>User Answers</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int USER_ANSWERS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.sirius.answer.impl.FormAnswersImpl <em>Form
	 * Answers</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.answer.impl.FormAnswersImpl
	 * @see org.eclipse.sirius.answer.impl.AnswerPackageImpl#getFormAnswers()
	 * @generated
	 */
	int FORM_ANSWERS = 2;

	/**
	 * The feature id for the '<em><b>Form</b></em>' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORM_ANSWERS__FORM = 0;

	/**
	 * The feature id for the '<em><b>User Answers</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORM_ANSWERS__USER_ANSWERS = 1;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORM_ANSWERS__USER_ID = 2;

	/**
	 * The number of structural features of the '<em>Form Answers</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORM_ANSWERS_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Form Answers</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORM_ANSWERS_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.sirius.answer.Answer
	 * <em>Answer</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Answer</em>'.
	 * @see org.eclipse.sirius.answer.Answer
	 * @generated
	 */
	EClass getAnswer();

	/**
	 * Returns the meta object for the attribute
	 * '{@link org.eclipse.sirius.answer.Answer#getAnswer <em>Answer</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Answer</em>'.
	 * @see org.eclipse.sirius.answer.Answer#getAnswer()
	 * @see #getAnswer()
	 * @generated
	 */
	EAttribute getAnswer_Answer();

	/**
	 * Returns the meta object for the reference
	 * '{@link org.eclipse.sirius.answer.Answer#getQuestion <em>Question</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Question</em>'.
	 * @see org.eclipse.sirius.answer.Answer#getQuestion()
	 * @see #getAnswer()
	 * @generated
	 */
	EReference getAnswer_Question();

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.sirius.answer.UserAnswers <em>User Answers</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>User Answers</em>'.
	 * @see org.eclipse.sirius.answer.UserAnswers
	 * @generated
	 */
	EClass getUserAnswers();

	/**
	 * Returns the meta object for the attribute
	 * '{@link org.eclipse.sirius.answer.UserAnswers#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.sirius.answer.UserAnswers#getName()
	 * @see #getUserAnswers()
	 * @generated
	 */
	EAttribute getUserAnswers_Name();

	/**
	 * Returns the meta object for the containment reference list
	 * '{@link org.eclipse.sirius.answer.UserAnswers#getAnswers <em>Answers</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list
	 *         '<em>Answers</em>'.
	 * @see org.eclipse.sirius.answer.UserAnswers#getAnswers()
	 * @see #getUserAnswers()
	 * @generated
	 */
	EReference getUserAnswers_Answers();

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.sirius.answer.FormAnswers <em>Form Answers</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Form Answers</em>'.
	 * @see org.eclipse.sirius.answer.FormAnswers
	 * @generated
	 */
	EClass getFormAnswers();

	/**
	 * Returns the meta object for the reference
	 * '{@link org.eclipse.sirius.answer.FormAnswers#getForm <em>Form</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Form</em>'.
	 * @see org.eclipse.sirius.answer.FormAnswers#getForm()
	 * @see #getFormAnswers()
	 * @generated
	 */
	EReference getFormAnswers_Form();

	/**
	 * Returns the meta object for the containment reference list
	 * '{@link org.eclipse.sirius.answer.FormAnswers#getUserAnswers <em>User
	 * Answers</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>User
	 *         Answers</em>'.
	 * @see org.eclipse.sirius.answer.FormAnswers#getUserAnswers()
	 * @see #getFormAnswers()
	 * @generated
	 */
	EReference getFormAnswers_UserAnswers();

	/**
	 * Returns the meta object for the attribute
	 * '{@link org.eclipse.sirius.answer.FormAnswers#getUserId <em>User Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>User Id</em>'.
	 * @see org.eclipse.sirius.answer.FormAnswers#getUserId()
	 * @see #getFormAnswers()
	 * @generated
	 */
	EAttribute getFormAnswers_UserId();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AnswerFactory getAnswerFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each operation of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.answer.impl.AnswerImpl <em>Answer</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.answer.impl.AnswerImpl
		 * @see org.eclipse.sirius.answer.impl.AnswerPackageImpl#getAnswer()
		 * @generated
		 */
		EClass ANSWER = eINSTANCE.getAnswer();

		/**
		 * The meta object literal for the '<em><b>Answer</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute ANSWER__ANSWER = eINSTANCE.getAnswer_Answer();

		/**
		 * The meta object literal for the '<em><b>Question</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference ANSWER__QUESTION = eINSTANCE.getAnswer_Question();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.answer.impl.UserAnswersImpl <em>User
		 * Answers</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.answer.impl.UserAnswersImpl
		 * @see org.eclipse.sirius.answer.impl.AnswerPackageImpl#getUserAnswers()
		 * @generated
		 */
		EClass USER_ANSWERS = eINSTANCE.getUserAnswers();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute USER_ANSWERS__NAME = eINSTANCE.getUserAnswers_Name();

		/**
		 * The meta object literal for the '<em><b>Answers</b></em>' containment
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference USER_ANSWERS__ANSWERS = eINSTANCE.getUserAnswers_Answers();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.answer.impl.FormAnswersImpl <em>Form
		 * Answers</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.answer.impl.FormAnswersImpl
		 * @see org.eclipse.sirius.answer.impl.AnswerPackageImpl#getFormAnswers()
		 * @generated
		 */
		EClass FORM_ANSWERS = eINSTANCE.getFormAnswers();

		/**
		 * The meta object literal for the '<em><b>Form</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference FORM_ANSWERS__FORM = eINSTANCE.getFormAnswers_Form();

		/**
		 * The meta object literal for the '<em><b>User Answers</b></em>' containment
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference FORM_ANSWERS__USER_ANSWERS = eINSTANCE.getFormAnswers_UserAnswers();

		/**
		 * The meta object literal for the '<em><b>User Id</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute FORM_ANSWERS__USER_ID = eINSTANCE.getFormAnswers_UserId();

	}

} // AnswerPackage
