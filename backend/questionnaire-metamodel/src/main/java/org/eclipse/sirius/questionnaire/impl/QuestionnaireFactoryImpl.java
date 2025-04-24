/**
 */
package org.eclipse.sirius.questionnaire.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.sirius.questionnaire.BooleanType;
import org.eclipse.sirius.questionnaire.ConditionalGroup;
import org.eclipse.sirius.questionnaire.DateType;
import org.eclipse.sirius.questionnaire.DecimalType;
import org.eclipse.sirius.questionnaire.EnumerationLiteral;
import org.eclipse.sirius.questionnaire.EnumerationType;
import org.eclipse.sirius.questionnaire.Form;
import org.eclipse.sirius.questionnaire.IntegerType;
import org.eclipse.sirius.questionnaire.MoneyType;
import org.eclipse.sirius.questionnaire.Question;
import org.eclipse.sirius.questionnaire.QuestionReuse;
import org.eclipse.sirius.questionnaire.QuestionnaireFactory;
import org.eclipse.sirius.questionnaire.QuestionnairePackage;
import org.eclipse.sirius.questionnaire.StringType;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class QuestionnaireFactoryImpl extends EFactoryImpl implements QuestionnaireFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	public static QuestionnaireFactory init() {
		try {
			QuestionnaireFactory theQuestionnaireFactory = (QuestionnaireFactory) EPackage.Registry.INSTANCE
					.getEFactory(QuestionnairePackage.eNS_URI);
			if (theQuestionnaireFactory != null) {
				return theQuestionnaireFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QuestionnaireFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	public QuestionnaireFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case QuestionnairePackage.FORM:
			return createForm();
		case QuestionnairePackage.CONDITIONAL_GROUP:
			return createConditionalGroup();
		case QuestionnairePackage.QUESTION:
			return createQuestion();
		case QuestionnairePackage.BOOLEAN_TYPE:
			return createBooleanType();
		case QuestionnairePackage.DATE_TYPE:
			return createDateType();
		case QuestionnairePackage.INTEGER_TYPE:
			return createIntegerType();
		case QuestionnairePackage.DECIMAL_TYPE:
			return createDecimalType();
		case QuestionnairePackage.STRING_TYPE:
			return createStringType();
		case QuestionnairePackage.ENUMERATION_TYPE:
			return createEnumerationType();
		case QuestionnairePackage.ENUMERATION_LITERAL:
			return createEnumerationLiteral();
		case QuestionnairePackage.MONEY_TYPE:
			return createMoneyType();
		case QuestionnairePackage.QUESTION_REUSE:
			return createQuestionReuse();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Form createForm() {
		FormImpl form = new FormImpl();
		return form;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ConditionalGroup createConditionalGroup() {
		ConditionalGroupImpl conditionalGroup = new ConditionalGroupImpl();
		return conditionalGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Question createQuestion() {
		QuestionImpl question = new QuestionImpl();
		return question;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public BooleanType createBooleanType() {
		BooleanTypeImpl booleanType = new BooleanTypeImpl();
		return booleanType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public DateType createDateType() {
		DateTypeImpl dateType = new DateTypeImpl();
		return dateType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public IntegerType createIntegerType() {
		IntegerTypeImpl integerType = new IntegerTypeImpl();
		return integerType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public DecimalType createDecimalType() {
		DecimalTypeImpl decimalType = new DecimalTypeImpl();
		return decimalType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public StringType createStringType() {
		StringTypeImpl stringType = new StringTypeImpl();
		return stringType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EnumerationType createEnumerationType() {
		EnumerationTypeImpl enumerationType = new EnumerationTypeImpl();
		return enumerationType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EnumerationLiteral createEnumerationLiteral() {
		EnumerationLiteralImpl enumerationLiteral = new EnumerationLiteralImpl();
		return enumerationLiteral;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public MoneyType createMoneyType() {
		MoneyTypeImpl moneyType = new MoneyTypeImpl();
		return moneyType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public QuestionReuse createQuestionReuse() {
		QuestionReuseImpl questionReuse = new QuestionReuseImpl();
		return questionReuse;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public QuestionnairePackage getQuestionnairePackage() {
		return (QuestionnairePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QuestionnairePackage getPackage() {
		return QuestionnairePackage.eINSTANCE;
	}

} // QuestionnaireFactoryImpl
