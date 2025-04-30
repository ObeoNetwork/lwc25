/**
 */
package org.eclipse.sirius.qlstyle;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see org.eclipse.sirius.qlstyle.QLStylePackage
 * @generated
 */
public interface QLStyleFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	QLStyleFactory eINSTANCE = org.eclipse.sirius.qlstyle.impl.QLStyleFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>QL Style</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>QL Style</em>'.
	 * @generated
	 */
	QLStyle createQLStyle();

	/**
	 * Returns a new object of class '<em>Question Customization</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Question Customization</em>'.
	 * @generated
	 */
	QuestionCustomization createQuestionCustomization();

	/**
	 * Returns a new object of class '<em>Group</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @return a new object of class '<em>Group</em>'.
	 * @generated
	 */
	Group createGroup();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @return the package supported by this factory.
	 * @generated
	 */
	QLStylePackage getQLStylePackage();

} // QLStyleFactory
