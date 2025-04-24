/**
 */
package org.eclipse.sirius.questionnaire;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Integer
 * Type</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.questionnaire.IntegerType#getMin
 * <em>Min</em>}</li>
 * <li>{@link org.eclipse.sirius.questionnaire.IntegerType#getMax
 * <em>Max</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.questionnaire.QuestionnairePackage#getIntegerType()
 * @model
 * @generated
 */
public interface IntegerType extends Type {
	/**
	 * Returns the value of the '<em><b>Min</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Min</em>' attribute.
	 * @see #setMin(Integer)
	 * @see org.eclipse.sirius.questionnaire.QuestionnairePackage#getIntegerType_Min()
	 * @model
	 * @generated
	 */
	Integer getMin();

	/**
	 * Sets the value of the
	 * '{@link org.eclipse.sirius.questionnaire.IntegerType#getMin <em>Min</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Min</em>' attribute.
	 * @see #getMin()
	 * @generated
	 */
	void setMin(Integer value);

	/**
	 * Returns the value of the '<em><b>Max</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Max</em>' attribute.
	 * @see #setMax(int)
	 * @see org.eclipse.sirius.questionnaire.QuestionnairePackage#getIntegerType_Max()
	 * @model
	 * @generated
	 */
	int getMax();

	/**
	 * Sets the value of the
	 * '{@link org.eclipse.sirius.questionnaire.IntegerType#getMax <em>Max</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Max</em>' attribute.
	 * @see #getMax()
	 * @generated
	 */
	void setMax(int value);

} // IntegerType
