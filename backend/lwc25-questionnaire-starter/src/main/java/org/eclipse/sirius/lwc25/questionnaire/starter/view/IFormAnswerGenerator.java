package org.eclipse.sirius.lwc25.questionnaire.starter.view;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.sirius.components.view.form.FormElementDescription;
import org.eclipse.sirius.components.view.form.FormElementFor;
import org.eclipse.sirius.components.view.form.FormElementIf;
import org.eclipse.sirius.components.view.form.WidgetDescription;
import org.eclipse.sirius.questionnaire.QuestionnairePackage;

import java.util.List;

public interface IFormAnswerGenerator {

    String canHandle();

    List<FormElementDescription> generateIntegerWidget(String elementExpression);
    List<FormElementDescription> generateBooleanWidget(String elementExpression);
    List<FormElementDescription> generateDateWidget(String elementExpression);
    List<FormElementDescription> generateDecimalWidget(String elementExpression);
    List<FormElementDescription> generateEnumerationWidget(String elementExpression);
    List<FormElementDescription> generateStringWidget(String elementExpression);
    List<FormElementDescription> generateMoneyWidget(String elementExpression);

    default List<FormElementDescription> dispatchType(EClass clazz, String elementExpression) {
        if(clazz == QuestionnairePackage.eINSTANCE.getIntegerType()) {
            return generateIntegerWidget(elementExpression);
        } else if(clazz == QuestionnairePackage.eINSTANCE.getBooleanType()) {
            return generateBooleanWidget(elementExpression);
        } else if(clazz == QuestionnairePackage.eINSTANCE.getDateType()) {
            return generateDateWidget(elementExpression);
        } else if(clazz == QuestionnairePackage.eINSTANCE.getDecimalType()) {
            return generateDecimalWidget(elementExpression);
        } else if(clazz == QuestionnairePackage.eINSTANCE.getEnumerationType()) {
            return generateEnumerationWidget(elementExpression);
        } else if(clazz == QuestionnairePackage.eINSTANCE.getStringType()) {
            return generateStringWidget(elementExpression);
        } else if(clazz == QuestionnairePackage.eINSTANCE.getMoneyType()) {
            return generateMoneyWidget(elementExpression);
        }
        return null;
    }

    FormElementIf generateDisplayCondition(String questionExpression);

    FormElementFor generateLoop();
    String getQuestionFromIteratorExpression();

}
