/**
 */
package org.eclipse.sirius.questionnaire;

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
 * @see org.eclipse.sirius.questionnaire.QuestionnaireFactory
 * @model kind="package"
 * @generated
 */
public interface QuestionnairePackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNAME = "questionnaire";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/questionnaire";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_PREFIX = "questionnaire";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	QuestionnairePackage eINSTANCE = org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl.init();

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.sirius.questionnaire.NamedElement <em>Named
	 * Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.questionnaire.NamedElement
	 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.sirius.questionnaire.impl.FormImpl <em>Form</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.questionnaire.impl.FormImpl
	 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getForm()
	 * @generated
	 */
	int FORM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORM__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORM__ELEMENTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Form</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORM_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Form</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORM_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.sirius.questionnaire.QuestionnaireElement
	 * <em>Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.questionnaire.QuestionnaireElement
	 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getQuestionnaireElement()
	 * @generated
	 */
	int QUESTIONNAIRE_ELEMENT = 2;

	/**
	 * The number of structural features of the '<em>Element</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QUESTIONNAIRE_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Element</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QUESTIONNAIRE_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.sirius.questionnaire.impl.ConditionalGroupImpl
	 * <em>Conditional Group</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see org.eclipse.sirius.questionnaire.impl.ConditionalGroupImpl
	 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getConditionalGroup()
	 * @generated
	 */
	int CONDITIONAL_GROUP = 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_GROUP__ELEMENTS = QUESTIONNAIRE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_GROUP__CONDITION = QUESTIONNAIRE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Conditional Group</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_GROUP_FEATURE_COUNT = QUESTIONNAIRE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Conditional Group</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_GROUP_OPERATION_COUNT = QUESTIONNAIRE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.sirius.questionnaire.impl.QuestionImpl
	 * <em>Question</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.questionnaire.impl.QuestionImpl
	 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getQuestion()
	 * @generated
	 */
	int QUESTION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QUESTION__NAME = QUESTIONNAIRE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QUESTION__LABEL = QUESTIONNAIRE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QUESTION__TYPE = QUESTIONNAIRE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Computed Expression</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QUESTION__COMPUTED_EXPRESSION = QUESTIONNAIRE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QUESTION__REQUIRED = QUESTIONNAIRE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Question</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QUESTION_FEATURE_COUNT = QUESTIONNAIRE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Question</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QUESTION_OPERATION_COUNT = QUESTIONNAIRE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.sirius.questionnaire.Type
	 * <em>Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.questionnaire.Type
	 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getType()
	 * @generated
	 */
	int TYPE = 4;

	/**
	 * The number of structural features of the '<em>Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Type</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.sirius.questionnaire.impl.BooleanTypeImpl <em>Boolean
	 * Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.questionnaire.impl.BooleanTypeImpl
	 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getBooleanType()
	 * @generated
	 */
	int BOOLEAN_TYPE = 5;

	/**
	 * The number of structural features of the '<em>Boolean Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.sirius.questionnaire.impl.DateTypeImpl <em>Date
	 * Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.questionnaire.impl.DateTypeImpl
	 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getDateType()
	 * @generated
	 */
	int DATE_TYPE = 6;

	/**
	 * The number of structural features of the '<em>Date Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DATE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Date Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DATE_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.sirius.questionnaire.impl.IntegerTypeImpl <em>Integer
	 * Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.questionnaire.impl.IntegerTypeImpl
	 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getIntegerType()
	 * @generated
	 */
	int INTEGER_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__MIN = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__MAX = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Integer Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Integer Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.sirius.questionnaire.impl.DecimalTypeImpl <em>Decimal
	 * Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.questionnaire.impl.DecimalTypeImpl
	 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getDecimalType()
	 * @generated
	 */
	int DECIMAL_TYPE = 8;

	/**
	 * The number of structural features of the '<em>Decimal Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DECIMAL_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Decimal Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DECIMAL_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.sirius.questionnaire.impl.StringTypeImpl <em>String
	 * Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.questionnaire.impl.StringTypeImpl
	 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getStringType()
	 * @generated
	 */
	int STRING_TYPE = 9;

	/**
	 * The number of structural features of the '<em>String Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>String Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.sirius.questionnaire.impl.EnumerationTypeImpl
	 * <em>Enumeration Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see org.eclipse.sirius.questionnaire.impl.EnumerationTypeImpl
	 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getEnumerationType()
	 * @generated
	 */
	int ENUMERATION_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Enumerationliteral</b></em>' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__ENUMERATIONLITERAL = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration Type</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Enumeration Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.sirius.questionnaire.impl.EnumerationLiteralImpl
	 * <em>Enumeration Literal</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.sirius.questionnaire.impl.EnumerationLiteralImpl
	 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getEnumerationLiteral()
	 * @generated
	 */
	int ENUMERATION_LITERAL = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Enumeration Literal</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Enumeration Literal</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.sirius.questionnaire.impl.MoneyTypeImpl <em>Money
	 * Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.questionnaire.impl.MoneyTypeImpl
	 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getMoneyType()
	 * @generated
	 */
	int MONEY_TYPE = 13;

	/**
	 * The number of structural features of the '<em>Money Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MONEY_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Money Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int MONEY_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.sirius.questionnaire.impl.QuestionReuseImpl <em>Question
	 * Reuse</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.sirius.questionnaire.impl.QuestionReuseImpl
	 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getQuestionReuse()
	 * @generated
	 */
	int QUESTION_REUSE = 14;

	/**
	 * The feature id for the '<em><b>Question</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QUESTION_REUSE__QUESTION = QUESTIONNAIRE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Question Reuse</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QUESTION_REUSE_FEATURE_COUNT = QUESTIONNAIRE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Question Reuse</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int QUESTION_REUSE_OPERATION_COUNT = QUESTIONNAIRE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.sirius.questionnaire.Form <em>Form</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Form</em>'.
	 * @see org.eclipse.sirius.questionnaire.Form
	 * @generated
	 */
	EClass getForm();

	/**
	 * Returns the meta object for the containment reference list
	 * '{@link org.eclipse.sirius.questionnaire.Form#getElements
	 * <em>Elements</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list
	 *         '<em>Elements</em>'.
	 * @see org.eclipse.sirius.questionnaire.Form#getElements()
	 * @see #getForm()
	 * @generated
	 */
	EReference getForm_Elements();

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.sirius.questionnaire.ConditionalGroup <em>Conditional
	 * Group</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Conditional Group</em>'.
	 * @see org.eclipse.sirius.questionnaire.ConditionalGroup
	 * @generated
	 */
	EClass getConditionalGroup();

	/**
	 * Returns the meta object for the containment reference list
	 * '{@link org.eclipse.sirius.questionnaire.ConditionalGroup#getElements
	 * <em>Elements</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list
	 *         '<em>Elements</em>'.
	 * @see org.eclipse.sirius.questionnaire.ConditionalGroup#getElements()
	 * @see #getConditionalGroup()
	 * @generated
	 */
	EReference getConditionalGroup_Elements();

	/**
	 * Returns the meta object for the attribute
	 * '{@link org.eclipse.sirius.questionnaire.ConditionalGroup#getCondition
	 * <em>Condition</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see org.eclipse.sirius.questionnaire.ConditionalGroup#getCondition()
	 * @see #getConditionalGroup()
	 * @generated
	 */
	EAttribute getConditionalGroup_Condition();

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.sirius.questionnaire.QuestionnaireElement
	 * <em>Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.sirius.questionnaire.QuestionnaireElement
	 * @generated
	 */
	EClass getQuestionnaireElement();

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.sirius.questionnaire.Question <em>Question</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Question</em>'.
	 * @see org.eclipse.sirius.questionnaire.Question
	 * @generated
	 */
	EClass getQuestion();

	/**
	 * Returns the meta object for the attribute
	 * '{@link org.eclipse.sirius.questionnaire.Question#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.sirius.questionnaire.Question#getLabel()
	 * @see #getQuestion()
	 * @generated
	 */
	EAttribute getQuestion_Label();

	/**
	 * Returns the meta object for the containment reference
	 * '{@link org.eclipse.sirius.questionnaire.Question#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.sirius.questionnaire.Question#getType()
	 * @see #getQuestion()
	 * @generated
	 */
	EReference getQuestion_Type();

	/**
	 * Returns the meta object for the attribute
	 * '{@link org.eclipse.sirius.questionnaire.Question#getComputedExpression
	 * <em>Computed Expression</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Computed Expression</em>'.
	 * @see org.eclipse.sirius.questionnaire.Question#getComputedExpression()
	 * @see #getQuestion()
	 * @generated
	 */
	EAttribute getQuestion_ComputedExpression();

	/**
	 * Returns the meta object for the attribute
	 * '{@link org.eclipse.sirius.questionnaire.Question#isRequired
	 * <em>Required</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see org.eclipse.sirius.questionnaire.Question#isRequired()
	 * @see #getQuestion()
	 * @generated
	 */
	EAttribute getQuestion_Required();

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.sirius.questionnaire.Type <em>Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.eclipse.sirius.questionnaire.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.sirius.questionnaire.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Boolean Type</em>'.
	 * @see org.eclipse.sirius.questionnaire.BooleanType
	 * @generated
	 */
	EClass getBooleanType();

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.sirius.questionnaire.DateType <em>Date Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Date Type</em>'.
	 * @see org.eclipse.sirius.questionnaire.DateType
	 * @generated
	 */
	EClass getDateType();

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.sirius.questionnaire.IntegerType <em>Integer Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Integer Type</em>'.
	 * @see org.eclipse.sirius.questionnaire.IntegerType
	 * @generated
	 */
	EClass getIntegerType();

	/**
	 * Returns the meta object for the attribute
	 * '{@link org.eclipse.sirius.questionnaire.IntegerType#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see org.eclipse.sirius.questionnaire.IntegerType#getMin()
	 * @see #getIntegerType()
	 * @generated
	 */
	EAttribute getIntegerType_Min();

	/**
	 * Returns the meta object for the attribute
	 * '{@link org.eclipse.sirius.questionnaire.IntegerType#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see org.eclipse.sirius.questionnaire.IntegerType#getMax()
	 * @see #getIntegerType()
	 * @generated
	 */
	EAttribute getIntegerType_Max();

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.sirius.questionnaire.DecimalType <em>Decimal Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Decimal Type</em>'.
	 * @see org.eclipse.sirius.questionnaire.DecimalType
	 * @generated
	 */
	EClass getDecimalType();

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.sirius.questionnaire.StringType <em>String Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>String Type</em>'.
	 * @see org.eclipse.sirius.questionnaire.StringType
	 * @generated
	 */
	EClass getStringType();

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.sirius.questionnaire.EnumerationType <em>Enumeration
	 * Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Enumeration Type</em>'.
	 * @see org.eclipse.sirius.questionnaire.EnumerationType
	 * @generated
	 */
	EClass getEnumerationType();

	/**
	 * Returns the meta object for the containment reference list
	 * '{@link org.eclipse.sirius.questionnaire.EnumerationType#getEnumerationliteral
	 * <em>Enumerationliteral</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list
	 *         '<em>Enumerationliteral</em>'.
	 * @see org.eclipse.sirius.questionnaire.EnumerationType#getEnumerationliteral()
	 * @see #getEnumerationType()
	 * @generated
	 */
	EReference getEnumerationType_Enumerationliteral();

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.sirius.questionnaire.EnumerationLiteral <em>Enumeration
	 * Literal</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Enumeration Literal</em>'.
	 * @see org.eclipse.sirius.questionnaire.EnumerationLiteral
	 * @generated
	 */
	EClass getEnumerationLiteral();

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.sirius.questionnaire.NamedElement <em>Named
	 * Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.eclipse.sirius.questionnaire.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute
	 * '{@link org.eclipse.sirius.questionnaire.NamedElement#getName
	 * <em>Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.sirius.questionnaire.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.sirius.questionnaire.MoneyType <em>Money Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Money Type</em>'.
	 * @see org.eclipse.sirius.questionnaire.MoneyType
	 * @generated
	 */
	EClass getMoneyType();

	/**
	 * Returns the meta object for class
	 * '{@link org.eclipse.sirius.questionnaire.QuestionReuse <em>Question
	 * Reuse</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Question Reuse</em>'.
	 * @see org.eclipse.sirius.questionnaire.QuestionReuse
	 * @generated
	 */
	EClass getQuestionReuse();

	/**
	 * Returns the meta object for the reference
	 * '{@link org.eclipse.sirius.questionnaire.QuestionReuse#getQuestion
	 * <em>Question</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Question</em>'.
	 * @see org.eclipse.sirius.questionnaire.QuestionReuse#getQuestion()
	 * @see #getQuestionReuse()
	 * @generated
	 */
	EReference getQuestionReuse_Question();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QuestionnaireFactory getQuestionnaireFactory();

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
		 * '{@link org.eclipse.sirius.questionnaire.impl.FormImpl <em>Form</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.questionnaire.impl.FormImpl
		 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getForm()
		 * @generated
		 */
		EClass FORM = eINSTANCE.getForm();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference FORM__ELEMENTS = eINSTANCE.getForm_Elements();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.questionnaire.impl.ConditionalGroupImpl
		 * <em>Conditional Group</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 *
		 * @see org.eclipse.sirius.questionnaire.impl.ConditionalGroupImpl
		 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getConditionalGroup()
		 * @generated
		 */
		EClass CONDITIONAL_GROUP = eINSTANCE.getConditionalGroup();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference CONDITIONAL_GROUP__ELEMENTS = eINSTANCE.getConditionalGroup_Elements();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute CONDITIONAL_GROUP__CONDITION = eINSTANCE.getConditionalGroup_Condition();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.questionnaire.QuestionnaireElement
		 * <em>Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.questionnaire.QuestionnaireElement
		 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getQuestionnaireElement()
		 * @generated
		 */
		EClass QUESTIONNAIRE_ELEMENT = eINSTANCE.getQuestionnaireElement();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.questionnaire.impl.QuestionImpl
		 * <em>Question</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.questionnaire.impl.QuestionImpl
		 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getQuestion()
		 * @generated
		 */
		EClass QUESTION = eINSTANCE.getQuestion();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute QUESTION__LABEL = eINSTANCE.getQuestion_Label();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference QUESTION__TYPE = eINSTANCE.getQuestion_Type();

		/**
		 * The meta object literal for the '<em><b>Computed Expression</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute QUESTION__COMPUTED_EXPRESSION = eINSTANCE.getQuestion_ComputedExpression();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute QUESTION__REQUIRED = eINSTANCE.getQuestion_Required();

		/**
		 * The meta object literal for the '{@link org.eclipse.sirius.questionnaire.Type
		 * <em>Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.questionnaire.Type
		 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.questionnaire.impl.BooleanTypeImpl <em>Boolean
		 * Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.questionnaire.impl.BooleanTypeImpl
		 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getBooleanType()
		 * @generated
		 */
		EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.questionnaire.impl.DateTypeImpl <em>Date
		 * Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.questionnaire.impl.DateTypeImpl
		 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getDateType()
		 * @generated
		 */
		EClass DATE_TYPE = eINSTANCE.getDateType();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.questionnaire.impl.IntegerTypeImpl <em>Integer
		 * Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.questionnaire.impl.IntegerTypeImpl
		 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getIntegerType()
		 * @generated
		 */
		EClass INTEGER_TYPE = eINSTANCE.getIntegerType();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute INTEGER_TYPE__MIN = eINSTANCE.getIntegerType_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute INTEGER_TYPE__MAX = eINSTANCE.getIntegerType_Max();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.questionnaire.impl.DecimalTypeImpl <em>Decimal
		 * Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.questionnaire.impl.DecimalTypeImpl
		 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getDecimalType()
		 * @generated
		 */
		EClass DECIMAL_TYPE = eINSTANCE.getDecimalType();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.questionnaire.impl.StringTypeImpl <em>String
		 * Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.questionnaire.impl.StringTypeImpl
		 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getStringType()
		 * @generated
		 */
		EClass STRING_TYPE = eINSTANCE.getStringType();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.questionnaire.impl.EnumerationTypeImpl
		 * <em>Enumeration Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 *
		 * @see org.eclipse.sirius.questionnaire.impl.EnumerationTypeImpl
		 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getEnumerationType()
		 * @generated
		 */
		EClass ENUMERATION_TYPE = eINSTANCE.getEnumerationType();

		/**
		 * The meta object literal for the '<em><b>Enumerationliteral</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 *
		 * @generated
		 */
		EReference ENUMERATION_TYPE__ENUMERATIONLITERAL = eINSTANCE.getEnumerationType_Enumerationliteral();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.questionnaire.impl.EnumerationLiteralImpl
		 * <em>Enumeration Literal</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 *
		 * @see org.eclipse.sirius.questionnaire.impl.EnumerationLiteralImpl
		 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getEnumerationLiteral()
		 * @generated
		 */
		EClass ENUMERATION_LITERAL = eINSTANCE.getEnumerationLiteral();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.questionnaire.NamedElement <em>Named
		 * Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.questionnaire.NamedElement
		 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.questionnaire.impl.MoneyTypeImpl <em>Money
		 * Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.questionnaire.impl.MoneyTypeImpl
		 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getMoneyType()
		 * @generated
		 */
		EClass MONEY_TYPE = eINSTANCE.getMoneyType();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.sirius.questionnaire.impl.QuestionReuseImpl <em>Question
		 * Reuse</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @see org.eclipse.sirius.questionnaire.impl.QuestionReuseImpl
		 * @see org.eclipse.sirius.questionnaire.impl.QuestionnairePackageImpl#getQuestionReuse()
		 * @generated
		 */
		EClass QUESTION_REUSE = eINSTANCE.getQuestionReuse();

		/**
		 * The meta object literal for the '<em><b>Question</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference QUESTION_REUSE__QUESTION = eINSTANCE.getQuestionReuse_Question();

	}

} // QuestionnairePackage
