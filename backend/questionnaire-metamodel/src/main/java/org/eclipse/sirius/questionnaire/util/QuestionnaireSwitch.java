/**
 */
package org.eclipse.sirius.questionnaire.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.sirius.questionnaire.*;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 *
 * @see org.eclipse.sirius.questionnaire.QuestionnairePackage
 * @generated
 */
public class QuestionnaireSwitch<T> extends Switch<T> {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected static QuestionnairePackage modelPackage;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	public QuestionnaireSwitch() {
		if (modelPackage == null) {
			modelPackage = QuestionnairePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a
	 * non null result; it yields that result. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case QuestionnairePackage.FORM: {
			Form form = (Form) theEObject;
			T result = caseForm(form);
			if (result == null) {
				result = caseNamedElement(form);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case QuestionnairePackage.CONDITIONAL_GROUP: {
			ConditionalGroup conditionalGroup = (ConditionalGroup) theEObject;
			T result = caseConditionalGroup(conditionalGroup);
			if (result == null) {
				result = caseQuestionnaireElement(conditionalGroup);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case QuestionnairePackage.QUESTIONNAIRE_ELEMENT: {
			QuestionnaireElement questionnaireElement = (QuestionnaireElement) theEObject;
			T result = caseQuestionnaireElement(questionnaireElement);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case QuestionnairePackage.QUESTION: {
			Question question = (Question) theEObject;
			T result = caseQuestion(question);
			if (result == null) {
				result = caseQuestionnaireElement(question);
			}
			if (result == null) {
				result = caseNamedElement(question);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case QuestionnairePackage.TYPE: {
			Type type = (Type) theEObject;
			T result = caseType(type);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case QuestionnairePackage.BOOLEAN_TYPE: {
			BooleanType booleanType = (BooleanType) theEObject;
			T result = caseBooleanType(booleanType);
			if (result == null) {
				result = caseType(booleanType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case QuestionnairePackage.DATE_TYPE: {
			DateType dateType = (DateType) theEObject;
			T result = caseDateType(dateType);
			if (result == null) {
				result = caseType(dateType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case QuestionnairePackage.INTEGER_TYPE: {
			IntegerType integerType = (IntegerType) theEObject;
			T result = caseIntegerType(integerType);
			if (result == null) {
				result = caseType(integerType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case QuestionnairePackage.DECIMAL_TYPE: {
			DecimalType decimalType = (DecimalType) theEObject;
			T result = caseDecimalType(decimalType);
			if (result == null) {
				result = caseType(decimalType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case QuestionnairePackage.STRING_TYPE: {
			StringType stringType = (StringType) theEObject;
			T result = caseStringType(stringType);
			if (result == null) {
				result = caseType(stringType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case QuestionnairePackage.ENUMERATION_TYPE: {
			EnumerationType enumerationType = (EnumerationType) theEObject;
			T result = caseEnumerationType(enumerationType);
			if (result == null) {
				result = caseType(enumerationType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case QuestionnairePackage.ENUMERATION_LITERAL: {
			EnumerationLiteral enumerationLiteral = (EnumerationLiteral) theEObject;
			T result = caseEnumerationLiteral(enumerationLiteral);
			if (result == null) {
				result = caseNamedElement(enumerationLiteral);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case QuestionnairePackage.NAMED_ELEMENT: {
			NamedElement namedElement = (NamedElement) theEObject;
			T result = caseNamedElement(namedElement);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case QuestionnairePackage.MONEY_TYPE: {
			MoneyType moneyType = (MoneyType) theEObject;
			T result = caseMoneyType(moneyType);
			if (result == null) {
				result = caseType(moneyType);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case QuestionnairePackage.QUESTION_REUSE: {
			QuestionReuse questionReuse = (QuestionReuse) theEObject;
			T result = caseQuestionReuse(questionReuse);
			if (result == null) {
				result = caseQuestionnaireElement(questionReuse);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of
	 * '<em>Form</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of
	 *         '<em>Form</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForm(Form object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of
	 * '<em>Conditional Group</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of
	 *         '<em>Conditional Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalGroup(ConditionalGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of
	 * '<em>Element</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of
	 *         '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuestionnaireElement(QuestionnaireElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of
	 * '<em>Question</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of
	 *         '<em>Question</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuestion(Question object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of
	 * '<em>Type</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of
	 *         '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean
	 * Type</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean
	 *         Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanType(BooleanType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Date
	 * Type</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Date
	 *         Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDateType(DateType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer
	 * Type</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer
	 *         Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerType(IntegerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Decimal
	 * Type</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Decimal
	 *         Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDecimalType(DecimalType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String
	 * Type</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String
	 *         Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringType(StringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of
	 * '<em>Enumeration Type</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of
	 *         '<em>Enumeration Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationType(EnumerationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of
	 * '<em>Enumeration Literal</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of
	 *         '<em>Enumeration Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationLiteral(EnumerationLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named
	 * Element</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named
	 *         Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Money
	 * Type</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Money
	 *         Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMoneyType(MoneyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Question
	 * Reuse</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Question
	 *         Reuse</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuestionReuse(QuestionReuse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of
	 * '<em>EObject</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last
	 * case anyway. <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of
	 *         '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // QuestionnaireSwitch
