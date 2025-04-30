/**
 */
package org.eclipse.sirius.qlstyle.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.sirius.qlstyle.Group;
import org.eclipse.sirius.qlstyle.GroupLayout;
import org.eclipse.sirius.qlstyle.QLStyle;
import org.eclipse.sirius.qlstyle.QLStyleElement;
import org.eclipse.sirius.qlstyle.QLStyleFactory;
import org.eclipse.sirius.qlstyle.QLStylePackage;
import org.eclipse.sirius.qlstyle.QuestionCustomization;
import org.eclipse.sirius.qlstyle.Widget;
import org.eclipse.sirius.questionnaire.QuestionnairePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class QLStylePackageImpl extends EPackageImpl implements QLStylePackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass qlStyleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass questionCustomizationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass groupEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass qlStyleElementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EEnum widgetEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EEnum groupLayoutEEnum = null;

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
	 * @see org.eclipse.sirius.qlstyle.QLStylePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QLStylePackageImpl() {
		super(eNS_URI, QLStyleFactory.eINSTANCE);
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
	 * This method is used to initialize {@link QLStylePackage#eINSTANCE} when that
	 * field is accessed. Clients should not invoke it directly. Instead, they
	 * should simply access that field to obtain the package. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QLStylePackage init() {
		if (isInited) {
			return (QLStylePackage) EPackage.Registry.INSTANCE.getEPackage(QLStylePackage.eNS_URI);
		}

		// Obtain or create and register package
		Object registeredQLStylePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QLStylePackageImpl theQLStylePackage = registeredQLStylePackage instanceof QLStylePackageImpl
				? (QLStylePackageImpl) registeredQLStylePackage
				: new QLStylePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		QuestionnairePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQLStylePackage.createPackageContents();

		// Initialize created meta-data
		theQLStylePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQLStylePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QLStylePackage.eNS_URI, theQLStylePackage);
		return theQLStylePackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getQLStyle() {
		return qlStyleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getQLStyle_Form() {
		return (EReference) qlStyleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getQLStyle_Elements() {
		return (EReference) qlStyleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getQuestionCustomization() {
		return questionCustomizationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getQuestionCustomization_HelpText() {
		return (EAttribute) questionCustomizationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getQuestionCustomization_Widget() {
		return (EAttribute) questionCustomizationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getQuestionCustomization_Question() {
		return (EReference) questionCustomizationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getGroup() {
		return groupEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getGroup_Name() {
		return (EAttribute) groupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getGroup_Description() {
		return (EAttribute) groupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getGroup_Layout() {
		return (EAttribute) groupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getGroup_Elements() {
		return (EReference) groupEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getQLStyleElement() {
		return qlStyleElementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EEnum getWidget() {
		return widgetEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EEnum getGroupLayout() {
		return groupLayoutEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public QLStyleFactory getQLStyleFactory() {
		return (QLStyleFactory) getEFactoryInstance();
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
		qlStyleEClass = createEClass(QL_STYLE);
		createEReference(qlStyleEClass, QL_STYLE__FORM);
		createEReference(qlStyleEClass, QL_STYLE__ELEMENTS);

		questionCustomizationEClass = createEClass(QUESTION_CUSTOMIZATION);
		createEAttribute(questionCustomizationEClass, QUESTION_CUSTOMIZATION__HELP_TEXT);
		createEAttribute(questionCustomizationEClass, QUESTION_CUSTOMIZATION__WIDGET);
		createEReference(questionCustomizationEClass, QUESTION_CUSTOMIZATION__QUESTION);

		groupEClass = createEClass(GROUP);
		createEAttribute(groupEClass, GROUP__NAME);
		createEAttribute(groupEClass, GROUP__DESCRIPTION);
		createEAttribute(groupEClass, GROUP__LAYOUT);
		createEReference(groupEClass, GROUP__ELEMENTS);

		qlStyleElementEClass = createEClass(QL_STYLE_ELEMENT);

		// Create enums
		widgetEEnum = createEEnum(WIDGET);
		groupLayoutEEnum = createEEnum(GROUP_LAYOUT);
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
		questionCustomizationEClass.getESuperTypes().add(this.getQLStyleElement());
		groupEClass.getESuperTypes().add(this.getQLStyleElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(qlStyleEClass, QLStyle.class, "QLStyle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQLStyle_Form(), theQuestionnairePackage.getForm(), null, "form", null, 1, 1, QLStyle.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQLStyle_Elements(), this.getQLStyleElement(), null, "elements", null, 0, -1, QLStyle.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(questionCustomizationEClass, QuestionCustomization.class, "QuestionCustomization", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQuestionCustomization_HelpText(), ecorePackage.getEString(), "helpText", null, 0, 1,
				QuestionCustomization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQuestionCustomization_Widget(), this.getWidget(), "widget", null, 1, 1,
				QuestionCustomization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQuestionCustomization_Question(), theQuestionnairePackage.getQuestionnaireElement(), null,
				"question", null, 1, 1, QuestionCustomization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groupEClass, Group.class, "Group", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGroup_Name(), ecorePackage.getEString(), "name", null, 0, 1, Group.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroup_Description(), ecorePackage.getEString(), "description", null, 0, 1, Group.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroup_Layout(), this.getGroupLayout(), "layout", null, 0, 1, Group.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGroup_Elements(), this.getQLStyleElement(), null, "elements", null, 0, -1, Group.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qlStyleElementEClass, QLStyleElement.class, "QLStyleElement", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(widgetEEnum, Widget.class, "Widget");
		addEEnumLiteral(widgetEEnum, Widget.TEXTFIELD);
		addEEnumLiteral(widgetEEnum, Widget.CHECKBOX);
		addEEnumLiteral(widgetEEnum, Widget.SELECT);
		addEEnumLiteral(widgetEEnum, Widget.SLIDER);
		addEEnumLiteral(widgetEEnum, Widget.RADIO);
		addEEnumLiteral(widgetEEnum, Widget.DATE);

		initEEnum(groupLayoutEEnum, GroupLayout.class, "GroupLayout");
		addEEnumLiteral(groupLayoutEEnum, GroupLayout.VERTICAL);
		addEEnumLiteral(groupLayoutEEnum, GroupLayout.HORIZONTAL);

		// Create resource
		createResource(eNS_URI);
	}

} // QLStylePackageImpl
