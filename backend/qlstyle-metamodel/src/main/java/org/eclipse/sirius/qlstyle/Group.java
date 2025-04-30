/**
 */
package org.eclipse.sirius.qlstyle;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Group</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.qlstyle.Group#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.sirius.qlstyle.Group#getDescription
 * <em>Description</em>}</li>
 * <li>{@link org.eclipse.sirius.qlstyle.Group#getLayout <em>Layout</em>}</li>
 * <li>{@link org.eclipse.sirius.qlstyle.Group#getElements
 * <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.qlstyle.QLStylePackage#getGroup()
 * @model
 * @generated
 */
public interface Group extends QLStyleElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.sirius.qlstyle.QLStylePackage#getGroup_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.sirius.qlstyle.Group#getName
	 * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.sirius.qlstyle.QLStylePackage#getGroup_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.sirius.qlstyle.Group#getDescription
	 * <em>Description</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Layout</b></em>' attribute. The literals are
	 * from the enumeration {@link org.eclipse.sirius.qlstyle.GroupLayout}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Layout</em>' attribute.
	 * @see org.eclipse.sirius.qlstyle.GroupLayout
	 * @see #setLayout(GroupLayout)
	 * @see org.eclipse.sirius.qlstyle.QLStylePackage#getGroup_Layout()
	 * @model
	 * @generated
	 */
	GroupLayout getLayout();

	/**
	 * Sets the value of the '{@link org.eclipse.sirius.qlstyle.Group#getLayout
	 * <em>Layout</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Layout</em>' attribute.
	 * @see org.eclipse.sirius.qlstyle.GroupLayout
	 * @see #getLayout()
	 * @generated
	 */
	void setLayout(GroupLayout value);

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list. The list
	 * contents are of type {@link org.eclipse.sirius.qlstyle.QLStyleElement}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see org.eclipse.sirius.qlstyle.QLStylePackage#getGroup_Elements()
	 * @model
	 * @generated
	 */
	EList<QLStyleElement> getElements();

} // Group
