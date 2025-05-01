/**
 */
package org.eclipse.sirius.qlstyle;

import org.eclipse.emf.ecore.*;

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
 * @see org.eclipse.sirius.qlstyle.QLStyleFactory
 * @model kind="package"
 * @generated
 */
public interface QLStylePackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNAME = "qlstyle";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/qlstyle";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_PREFIX = "qlstyle";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	QLStylePackage eINSTANCE = org.eclipse.sirius.qlstyle.impl.QLStylePackageImpl.init();

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.sirius.qlstyle.impl.QLStyleImpl <em>QL Style</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.qlstyle.impl.QLStyleImpl
	 * @see org.eclipse.sirius.qlstyle.impl.QLStylePackageImpl#getQLStyle()
	 * @generated
	 */
	int QL_STYLE = 0;

	/**
	 * The feature id for the '<em><b>Form</b></em>' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QL_STYLE__FORM = 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QL_STYLE__ELEMENTS = 1;

	/**
	 * The number of structural features of the '<em>QL Style</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QL_STYLE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>QL Style</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QL_STYLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.sirius.qlstyle.QLStyleElement
	 * <em>Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.qlstyle.QLStyleElement
	 * @see org.eclipse.sirius.qlstyle.impl.QLStylePackageImpl#getQLStyleElement()
	 * @generated
	 */
	int QL_STYLE_ELEMENT = 3;

	/**
	 * The number of structural features of the '<em>Element</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QL_STYLE_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Element</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QL_STYLE_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.sirius.qlstyle.impl.QuestionCustomizationImpl
	 * <em>Question Customization</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.sirius.qlstyle.impl.QuestionCustomizationImpl
	 * @see org.eclipse.sirius.qlstyle.impl.QLStylePackageImpl#getQuestionCustomization()
	 * @generated
	 */
	int QUESTION_CUSTOMIZATION = 1;

	/**
	 * The feature id for the '<em><b>Help Text</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QUESTION_CUSTOMIZATION__HELP_TEXT = QL_STYLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QUESTION_CUSTOMIZATION__WIDGET = QL_STYLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Question</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QUESTION_CUSTOMIZATION__QUESTION = QL_STYLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Question Customization</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QUESTION_CUSTOMIZATION_FEATURE_COUNT = QL_STYLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Question Customization</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QUESTION_CUSTOMIZATION_OPERATION_COUNT = QL_STYLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.sirius.qlstyle.impl.GroupImpl
	 * <em>Group</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.qlstyle.impl.GroupImpl
	 * @see org.eclipse.sirius.qlstyle.impl.QLStylePackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int GROUP__NAME = QL_STYLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int GROUP__DESCRIPTION = QL_STYLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int GROUP__LAYOUT = QL_STYLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int GROUP__ELEMENTS = QL_STYLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Group</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = QL_STYLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Group</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int GROUP_OPERATION_COUNT = QL_STYLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.sirius.qlstyle.Widget
	 * <em>Widget</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.qlstyle.Widget
	 * @see org.eclipse.sirius.qlstyle.impl.QLStylePackageImpl#getWidget()
	 * @generated
	 */
	int WIDGET = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.sirius.qlstyle.GroupLayout
	 * <em>Group Layout</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.qlstyle.GroupLayout
	 * @see org.eclipse.sirius.qlstyle.impl.QLStylePackageImpl#getGroupLayout()
	 * @generated
	 */
	int GROUP_LAYOUT = 5;

	/**
	 * Returns the meta object for class '{@link org.eclipse.sirius.qlstyle.QLStyle
	 * <em>QL Style</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>QL Style</em>'.
	 * @see org.eclipse.sirius.qlstyle.QLStyle
	 * @generated
	 */
	EClass getQLStyle();

	/**
	 * Returns the meta object for the reference
	 * '{@link org.eclipse.sirius.qlstyle.QLStyle#getForm <em>Form</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Form</em>'.
	 * @see org.eclipse.sirius.qlstyle.QLStyle#getForm()
	 * @see #getQLStyle()
	 * @generated
	 */
	EReference getQLStyle_Form();

	/**
	 * Returns the meta object for the containment reference list
	 * '{@link org.eclipse.sirius.qlstyle.QLStyle#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list
	 *         '<em>Elements</em>'.
	 * @see org.eclipse.sirius.qlstyle.QLStyle#getElements()
	 * @see #getQLStyle()
	 * @generated
	 */
	EReference getQLStyle_Elements();

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.sirius.qlstyle.QuestionCustomization <em>Question
	 * Customization</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Question Customization</em>'.
	 * @see org.eclipse.sirius.qlstyle.QuestionCustomization
	 * @generated
	 */
	EClass getQuestionCustomization();

	/**
	 * Returns the meta object for the attribute
	 * '{@link org.eclipse.sirius.qlstyle.QuestionCustomization#getHelpText <em>Help
	 * Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Help Text</em>'.
	 * @see org.eclipse.sirius.qlstyle.QuestionCustomization#getHelpText()
	 * @see #getQuestionCustomization()
	 * @generated
	 */
	EAttribute getQuestionCustomization_HelpText();

	/**
	 * Returns the meta object for the attribute
	 * '{@link org.eclipse.sirius.qlstyle.QuestionCustomization#getWidget
	 * <em>Widget</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Widget</em>'.
	 * @see org.eclipse.sirius.qlstyle.QuestionCustomization#getWidget()
	 * @see #getQuestionCustomization()
	 * @generated
	 */
	EAttribute getQuestionCustomization_Widget();

	/**
	 * Returns the meta object for the reference
	 * '{@link org.eclipse.sirius.qlstyle.QuestionCustomization#getQuestion
	 * <em>Question</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Question</em>'.
	 * @see org.eclipse.sirius.qlstyle.QuestionCustomization#getQuestion()
	 * @see #getQuestionCustomization()
	 * @generated
	 */
	EReference getQuestionCustomization_Question();

	/**
	 * Returns the meta object for class '{@link org.eclipse.sirius.qlstyle.Group
	 * <em>Group</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Group</em>'.
	 * @see org.eclipse.sirius.qlstyle.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the meta object for the attribute
	 * '{@link org.eclipse.sirius.qlstyle.Group#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.sirius.qlstyle.Group#getName()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Name();

	/**
	 * Returns the meta object for the attribute
	 * '{@link org.eclipse.sirius.qlstyle.Group#getDescription
	 * <em>Description</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.sirius.qlstyle.Group#getDescription()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Description();

	/**
	 * Returns the meta object for the attribute
	 * '{@link org.eclipse.sirius.qlstyle.Group#getLayout <em>Layout</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Layout</em>'.
	 * @see org.eclipse.sirius.qlstyle.Group#getLayout()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Layout();

	/**
	 * Returns the meta object for the reference list
	 * '{@link org.eclipse.sirius.qlstyle.Group#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see org.eclipse.sirius.qlstyle.Group#getElements()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Elements();

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.sirius.qlstyle.QLStyleElement <em>Element</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.sirius.qlstyle.QLStyleElement
	 * @generated
	 */
	EClass getQLStyleElement();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.sirius.qlstyle.Widget
	 * <em>Widget</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for enum '<em>Widget</em>'.
	 * @see org.eclipse.sirius.qlstyle.Widget
	 * @generated
	 */
	EEnum getWidget();

	/**
	 * Returns the meta object for enum
	 * '{@link org.eclipse.sirius.qlstyle.GroupLayout <em>Group Layout</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for enum '<em>Group Layout</em>'.
	 * @see org.eclipse.sirius.qlstyle.GroupLayout
	 * @generated
	 */
	EEnum getGroupLayout();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QLStyleFactory getQLStyleFactory();

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
		 * '{@link org.eclipse.sirius.qlstyle.impl.QLStyleImpl <em>QL Style</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.qlstyle.impl.QLStyleImpl
		 * @see org.eclipse.sirius.qlstyle.impl.QLStylePackageImpl#getQLStyle()
		 * @generated
		 */
		EClass QL_STYLE = eINSTANCE.getQLStyle();

		/**
		 * The meta object literal for the '<em><b>Form</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference QL_STYLE__FORM = eINSTANCE.getQLStyle_Form();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference QL_STYLE__ELEMENTS = eINSTANCE.getQLStyle_Elements();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.qlstyle.impl.QuestionCustomizationImpl
		 * <em>Question Customization</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 *
		 * @see org.eclipse.sirius.qlstyle.impl.QuestionCustomizationImpl
		 * @see org.eclipse.sirius.qlstyle.impl.QLStylePackageImpl#getQuestionCustomization()
		 * @generated
		 */
		EClass QUESTION_CUSTOMIZATION = eINSTANCE.getQuestionCustomization();

		/**
		 * The meta object literal for the '<em><b>Help Text</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute QUESTION_CUSTOMIZATION__HELP_TEXT = eINSTANCE.getQuestionCustomization_HelpText();

		/**
		 * The meta object literal for the '<em><b>Widget</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute QUESTION_CUSTOMIZATION__WIDGET = eINSTANCE.getQuestionCustomization_Widget();

		/**
		 * The meta object literal for the '<em><b>Question</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference QUESTION_CUSTOMIZATION__QUESTION = eINSTANCE.getQuestionCustomization_Question();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.qlstyle.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.qlstyle.impl.GroupImpl
		 * @see org.eclipse.sirius.qlstyle.impl.QLStylePackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute GROUP__NAME = eINSTANCE.getGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute GROUP__DESCRIPTION = eINSTANCE.getGroup_Description();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute GROUP__LAYOUT = eINSTANCE.getGroup_Layout();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference GROUP__ELEMENTS = eINSTANCE.getGroup_Elements();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.qlstyle.QLStyleElement <em>Element</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.qlstyle.QLStyleElement
		 * @see org.eclipse.sirius.qlstyle.impl.QLStylePackageImpl#getQLStyleElement()
		 * @generated
		 */
		EClass QL_STYLE_ELEMENT = eINSTANCE.getQLStyleElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.sirius.qlstyle.Widget
		 * <em>Widget</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.qlstyle.Widget
		 * @see org.eclipse.sirius.qlstyle.impl.QLStylePackageImpl#getWidget()
		 * @generated
		 */
		EEnum WIDGET = eINSTANCE.getWidget();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.qlstyle.GroupLayout <em>Group Layout</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.qlstyle.GroupLayout
		 * @see org.eclipse.sirius.qlstyle.impl.QLStylePackageImpl#getGroupLayout()
		 * @generated
		 */
		EEnum GROUP_LAYOUT = eINSTANCE.getGroupLayout();

	}

} // QLStylePackage
