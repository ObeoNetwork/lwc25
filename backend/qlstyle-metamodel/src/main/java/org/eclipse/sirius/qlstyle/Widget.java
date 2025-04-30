/**
 */
package org.eclipse.sirius.qlstyle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Widget</b></em>', and utility methods for working with them. <!--
 * end-user-doc -->
 *
 * @see org.eclipse.sirius.qlstyle.QLStylePackage#getWidget()
 * @model
 * @generated
 */
public enum Widget implements Enumerator {
	/**
	 * The '<em><b>Textfield</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #TEXTFIELD_VALUE
	 * @generated
	 * @ordered
	 */
	TEXTFIELD(0, "Textfield", "Textfield"),

	/**
	 * The '<em><b>Checkbox</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #CHECKBOX_VALUE
	 * @generated
	 * @ordered
	 */
	CHECKBOX(1, "Checkbox", "Checkbox"),

	/**
	 * The '<em><b>Select</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #SELECT_VALUE
	 * @generated
	 * @ordered
	 */
	SELECT(2, "Select", "Select"),

	/**
	 * The '<em><b>Slider</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #SLIDER_VALUE
	 * @generated
	 * @ordered
	 */
	SLIDER(3, "Slider", "Slider"),

	/**
	 * The '<em><b>Radio</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #RADIO_VALUE
	 * @generated
	 * @ordered
	 */
	RADIO(4, "Radio", "Radio"),
	/**
	 * The '<em><b>Date</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #DATE_VALUE
	 * @generated
	 * @ordered
	 */
	DATE(5, "Date", "Date");

	/**
	 * The '<em><b>Textfield</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #TEXTFIELD
	 * @model name="Textfield"
	 * @generated
	 * @ordered
	 */
	public static final int TEXTFIELD_VALUE = 0;

	/**
	 * The '<em><b>Checkbox</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #CHECKBOX
	 * @model name="Checkbox"
	 * @generated
	 * @ordered
	 */
	public static final int CHECKBOX_VALUE = 1;

	/**
	 * The '<em><b>Select</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #SELECT
	 * @model name="Select"
	 * @generated
	 * @ordered
	 */
	public static final int SELECT_VALUE = 2;

	/**
	 * The '<em><b>Slider</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #SLIDER
	 * @model name="Slider"
	 * @generated
	 * @ordered
	 */
	public static final int SLIDER_VALUE = 3;

	/**
	 * The '<em><b>Radio</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #RADIO
	 * @model name="Radio"
	 * @generated
	 * @ordered
	 */
	public static final int RADIO_VALUE = 4;

	/**
	 * The '<em><b>Date</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #DATE
	 * @model name="Date"
	 * @generated
	 * @ordered
	 */
	public static final int DATE_VALUE = 5;

	/**
	 * An array of all the '<em><b>Widget</b></em>' enumerators. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static final Widget[] VALUES_ARRAY = new Widget[] { TEXTFIELD, CHECKBOX, SELECT, SLIDER, RADIO, DATE, };

	/**
	 * A public read-only list of all the '<em><b>Widget</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final List<Widget> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Widget</b></em>' literal with the specified literal
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Widget get(String literal) {
		for (Widget result : VALUES_ARRAY) {
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Widget</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Widget getByName(String name) {
		for (Widget result : VALUES_ARRAY) {
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Widget</b></em>' literal with the specified integer
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Widget get(int value) {
		switch (value) {
		case TEXTFIELD_VALUE:
			return TEXTFIELD;
		case CHECKBOX_VALUE:
			return CHECKBOX;
		case SELECT_VALUE:
			return SELECT;
		case SLIDER_VALUE:
			return SLIDER;
		case RADIO_VALUE:
			return RADIO;
		case DATE_VALUE:
			return DATE;
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
	private Widget(int value, String name, String literal) {
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

} // Widget
