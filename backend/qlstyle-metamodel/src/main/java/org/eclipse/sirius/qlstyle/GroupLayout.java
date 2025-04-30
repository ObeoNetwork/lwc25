/**
 */
package org.eclipse.sirius.qlstyle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Group Layout</b></em>', and utility methods for working with them.
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.sirius.qlstyle.QLStylePackage#getGroupLayout()
 * @model
 * @generated
 */
public enum GroupLayout implements Enumerator {
	/**
	 * The '<em><b>Vertical</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #VERTICAL_VALUE
	 * @generated
	 * @ordered
	 */
	VERTICAL(0, "Vertical", "Vertical"),

	/**
	 * The '<em><b>Horizontal</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #HORIZONTAL_VALUE
	 * @generated
	 * @ordered
	 */
	HORIZONTAL(1, "Horizontal", "Horizontal");

	/**
	 * The '<em><b>Vertical</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #VERTICAL
	 * @model name="Vertical"
	 * @generated
	 * @ordered
	 */
	public static final int VERTICAL_VALUE = 0;

	/**
	 * The '<em><b>Horizontal</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #HORIZONTAL
	 * @model name="Horizontal"
	 * @generated
	 * @ordered
	 */
	public static final int HORIZONTAL_VALUE = 1;

	/**
	 * An array of all the '<em><b>Group Layout</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static final GroupLayout[] VALUES_ARRAY = new GroupLayout[] { VERTICAL, HORIZONTAL, };

	/**
	 * A public read-only list of all the '<em><b>Group Layout</b></em>'
	 * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final List<GroupLayout> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Group Layout</b></em>' literal with the specified literal
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GroupLayout get(String literal) {
		for (GroupLayout result : VALUES_ARRAY) {
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Group Layout</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GroupLayout getByName(String name) {
		for (GroupLayout result : VALUES_ARRAY) {
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Group Layout</b></em>' literal with the specified integer
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static GroupLayout get(int value) {
		switch (value) {
		case VERTICAL_VALUE:
			return VERTICAL;
		case HORIZONTAL_VALUE:
			return HORIZONTAL;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	private GroupLayout(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string
	 * representation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // GroupLayout
