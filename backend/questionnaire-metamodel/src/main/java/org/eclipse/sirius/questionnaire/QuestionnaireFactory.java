/**
 */
package org.eclipse.sirius.questionnaire;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see org.eclipse.sirius.questionnaire.QuestionnairePackage
 * @generated
 */
public interface QuestionnaireFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	QuestionnaireFactory eINSTANCE = org.eclipse.sirius.questionnaire.impl.QuestionnaireFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Form</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @return a new object of class '<em>Form</em>'.
	 * @generated
	 */
	Form createForm();

	/**
	 * Returns a new object of class '<em>Conditional Group</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Conditional Group</em>'.
	 * @generated
	 */
	ConditionalGroup createConditionalGroup();

	/**
	 * Returns a new object of class '<em>Question</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Question</em>'.
	 * @generated
	 */
	Question createQuestion();

	/**
	 * Returns a new object of class '<em>Boolean Type</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Boolean Type</em>'.
	 * @generated
	 */
	BooleanType createBooleanType();

	/**
	 * Returns a new object of class '<em>Date Type</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Date Type</em>'.
	 * @generated
	 */
	DateType createDateType();

	/**
	 * Returns a new object of class '<em>Integer Type</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Integer Type</em>'.
	 * @generated
	 */
	IntegerType createIntegerType();

	/**
	 * Returns a new object of class '<em>Decimal Type</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Decimal Type</em>'.
	 * @generated
	 */
	DecimalType createDecimalType();

	/**
	 * Returns a new object of class '<em>String Type</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>String Type</em>'.
	 * @generated
	 */
	StringType createStringType();

	/**
	 * Returns a new object of class '<em>Enumeration Type</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Enumeration Type</em>'.
	 * @generated
	 */
	EnumerationType createEnumerationType();

	/**
	 * Returns a new object of class '<em>Enumeration Literal</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Enumeration Literal</em>'.
	 * @generated
	 */
	EnumerationLiteral createEnumerationLiteral();

	/**
	 * Returns a new object of class '<em>Money Type</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Money Type</em>'.
	 * @generated
	 */
	MoneyType createMoneyType();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @return the package supported by this factory.
	 * @generated
	 */
	QuestionnairePackage getQuestionnairePackage();

} // QuestionnaireFactory
