/**
 */
package org.eclipse.sirius.qlstyle.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.sirius.qlstyle.Group;
import org.eclipse.sirius.qlstyle.QLStyle;
import org.eclipse.sirius.qlstyle.QLStyleElement;
import org.eclipse.sirius.qlstyle.QLStylePackage;
import org.eclipse.sirius.qlstyle.QuestionCustomization;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 *
 * @see org.eclipse.sirius.qlstyle.QLStylePackage
 * @generated
 */
public class QLStyleSwitch<T> extends Switch<T> {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected static QLStylePackage modelPackage;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	public QLStyleSwitch() {
		if (modelPackage == null) {
			modelPackage = QLStylePackage.eINSTANCE;
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
		case QLStylePackage.QL_STYLE: {
			QLStyle qlStyle = (QLStyle) theEObject;
			T result = caseQLStyle(qlStyle);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case QLStylePackage.QUESTION_CUSTOMIZATION: {
			QuestionCustomization questionCustomization = (QuestionCustomization) theEObject;
			T result = caseQuestionCustomization(questionCustomization);
			if (result == null) {
				result = caseQLStyleElement(questionCustomization);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case QLStylePackage.GROUP: {
			Group group = (Group) theEObject;
			T result = caseGroup(group);
			if (result == null) {
				result = caseQLStyleElement(group);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case QLStylePackage.QL_STYLE_ELEMENT: {
			QLStyleElement qlStyleElement = (QLStyleElement) theEObject;
			T result = caseQLStyleElement(qlStyleElement);
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
	 * Returns the result of interpreting the object as an instance of '<em>QL
	 * Style</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>QL
	 *         Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQLStyle(QLStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Question
	 * Customization</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Question
	 *         Customization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuestionCustomization(QuestionCustomization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of
	 * '<em>Group</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 *
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of
	 *         '<em>Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGroup(Group object) {
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
	public T caseQLStyleElement(QLStyleElement object) {
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

} // QLStyleSwitch
