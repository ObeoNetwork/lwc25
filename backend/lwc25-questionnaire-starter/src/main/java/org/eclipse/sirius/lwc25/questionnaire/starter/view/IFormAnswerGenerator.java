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

    List<FormElementDescription> generateIntegerWidget(String elementExpression, String currentQuestionExpression);
    List<FormElementDescription> generateBooleanWidget(String elementExpression, String currentQuestionExpression);
    List<FormElementDescription> generateDateWidget(String elementExpression, String currentQuestionExpression);
    List<FormElementDescription> generateDecimalWidget(String elementExpression, String currentQuestionExpression);
    List<FormElementDescription> generateEnumerationWidget(String elementExpression, String currentQuestionExpression);
    List<FormElementDescription> generateStringWidget(String elementExpression, String currentQuestionExpression);
    List<FormElementDescription> generateMoneyWidget(String elementExpression, String currentQuestionExpression);

    default List<FormElementDescription> dispatchType(EClass clazz, String elementExpression, String currentQuestionExpression, boolean isReuse) {
        if(clazz == QuestionnairePackage.eINSTANCE.getIntegerType()) {
            return generateIntegerWidget(elementExpression, currentQuestionExpression);
        } else if(clazz == QuestionnairePackage.eINSTANCE.getBooleanType()) {
            return generateBooleanWidget(elementExpression, currentQuestionExpression);
        } else if(clazz == QuestionnairePackage.eINSTANCE.getDateType()) {
            return generateDateWidget(elementExpression, currentQuestionExpression);
        } else if(clazz == QuestionnairePackage.eINSTANCE.getDecimalType()) {
            return generateDecimalWidget(elementExpression, currentQuestionExpression);
        } else if(clazz == QuestionnairePackage.eINSTANCE.getEnumerationType()) {
            return generateEnumerationWidget(elementExpression, currentQuestionExpression);
        } else if(clazz == QuestionnairePackage.eINSTANCE.getStringType()) {
            return generateStringWidget(elementExpression, currentQuestionExpression);
        } else if(clazz == QuestionnairePackage.eINSTANCE.getMoneyType()) {
            return generateMoneyWidget(elementExpression, currentQuestionExpression);
        }
        return null;
    }

    FormElementIf generateDisplayCondition(String questionExpression);

    FormElementFor generateLoop();
    String getQuestionFromIteratorExpression();

}
