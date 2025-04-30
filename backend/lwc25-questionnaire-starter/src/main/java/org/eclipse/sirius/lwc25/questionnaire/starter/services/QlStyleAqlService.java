package org.eclipse.sirius.lwc25.questionnaire.starter.services;

import com.google.common.collect.Streams;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.ecore.extender.business.internal.accessor.ecore.EcoreIntrinsicExtender;
import org.eclipse.sirius.qlstyle.*;
import org.eclipse.sirius.questionnaire.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class QlStyleAqlService {

    public List<Widget> getAvailableWidgets(Type type) {
        if(type instanceof IntegerType integer) {
            var diff = Long.valueOf(Optional.ofNullable(integer.getMax()).orElse(Integer.MAX_VALUE)) - Long.valueOf(Optional.ofNullable(integer.getMin()).orElse(Integer.MIN_VALUE));
            if(diff <= 10) {
                return List.of(Widget.RADIO, Widget.SLIDER, Widget.SELECT, Widget.TEXTFIELD);
            } else if(diff <= 50) {
                return List.of(Widget.SLIDER, Widget.TEXTFIELD);
            }
        } else if(type instanceof EnumerationType) {
            return List.of(Widget.RADIO, Widget.SELECT);
        } else if(type instanceof BooleanType) {
            return List.of(Widget.RADIO, Widget.CHECKBOX, Widget.SELECT);
        }
        return List.of();
    }

    public boolean canChangeWidget(Type type) {
        return (type instanceof IntegerType integer && Long.valueOf(Optional.ofNullable(integer.getMax()).orElse(Integer.MAX_VALUE)) - Long.valueOf(Optional.ofNullable(integer.getMin()).orElse(Integer.MIN_VALUE)) <= 50)
                || type instanceof EnumerationType
                || type instanceof BooleanType;
    }

    public List<Integer> generateIntList(IntegerType integer) {
        return IntStream.range(integer.getMin(), integer.getMax() + 1).boxed().toList();
    }

    public boolean init(QLStyle style) {
        if(style.getForm() != null) {
            var questions = Streams.stream(style.getForm().eAllContents()).filter(Question.class::isInstance).map(Question.class::cast).toList();

            Streams.stream(style.eAllContents())
                    .filter(QuestionCustomization.class::isInstance)
                    .map(QuestionCustomization.class::cast)
                    .filter(qstyle -> qstyle.getQuestion() == null)
                    .forEach(qstyle -> new EcoreIntrinsicExtender().eRemove(style, "elements", qstyle));

            for(var question: questions) {
                var styleOpt = getStyle(question, style);
                if(styleOpt.isEmpty()) {
                    var newStyle = QLStyleFactory.eINSTANCE.createQuestionCustomization();
                    newStyle.setQuestion(question);
                    newStyle.setWidget(typeToWidget(question.getType()));
                    new EcoreIntrinsicExtender().eAdd(style, "elements", newStyle);
                }
            }
            return true;
        }
        return false;
    }

    private Optional<QuestionCustomization> getStyle(Question question, QLStyle qlstyle) {
        return Streams.stream(qlstyle.eAllContents())
                .filter(QuestionCustomization.class::isInstance)
                .map(QuestionCustomization.class::cast)
                .filter(style -> style.getQuestion() == question)
                .findFirst();
    }

    public Widget typeToWidget(Type type) {
        if(type instanceof DateType) {
            return Widget.DATE;
        } else if(type instanceof BooleanType) {
            return Widget.CHECKBOX;
        } else if(type instanceof EnumerationType) {
            return Widget.SELECT;
        } else {
            return Widget.TEXTFIELD;
        }
    }

    public EObject moveBackward(QLStyleElement element) {
        var container = (List<QLStyleElement>) element.eContainer().eGet(element.eContainingFeature());
        var index = container.indexOf(element);
        if(index > 0) {
            container.remove(element);
            container.add(index - 1, element);
        }
        return element;
    }

    public EObject moveForward(QLStyleElement element) {
        var container = (List<QLStyleElement>) element.eContainer().eGet(element.eContainingFeature());
        var index = container.indexOf(element);
        if(index < container.size() - 1) {
            container.remove(element);
            container.add(index + 1, element);
        }
        return element;
    }

    public boolean canMoveBackward(QLStyleElement element) {
        return ((List<QLStyleElement>) element.eContainer().eGet(element.eContainingFeature())).indexOf(element) > 0;
    }

    public boolean canMoveForward(QLStyleElement element) {
        var list = (List<QLStyleElement>) element.eContainer().eGet(element.eContainingFeature());
        return list.indexOf(element) < list.size() - 1;
    }

}
