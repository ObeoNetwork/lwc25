/**
 */
package org.eclipse.sirius.answer;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see org.eclipse.sirius.answer.AnswerPackage
 * @generated
 */
public interface AnswerFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	AnswerFactory eINSTANCE = org.eclipse.sirius.answer.impl.AnswerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Answer</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @return a new object of class '<em>Answer</em>'.
	 * @generated
	 */
	Answer createAnswer();

	/**
	 * Returns a new object of class '<em>User Answers</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>User Answers</em>'.
	 * @generated
	 */
	UserAnswers createUserAnswers();

	/**
	 * Returns a new object of class '<em>Form Answers</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Form Answers</em>'.
	 * @generated
	 */
	FormAnswers createFormAnswers();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @return the package supported by this factory.
	 * @generated
	 */
	AnswerPackage getAnswerPackage();

} // AnswerFactory
