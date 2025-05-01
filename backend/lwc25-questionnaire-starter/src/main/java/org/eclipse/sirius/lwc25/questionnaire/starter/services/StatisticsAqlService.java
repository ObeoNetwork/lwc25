package org.eclipse.sirius.lwc25.questionnaire.starter.services;

import com.google.common.collect.Streams;
import org.eclipse.sirius.answer.Answer;
import org.eclipse.sirius.answer.FormAnswers;
import org.eclipse.sirius.questionnaire.BooleanType;
import org.eclipse.sirius.questionnaire.EnumerationLiteral;
import org.eclipse.sirius.questionnaire.EnumerationType;
import org.eclipse.sirius.questionnaire.Type;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StatisticsAqlService {

    public List<String> getKeys(Type type) {
        if(type instanceof EnumerationType enumeration) {
            return enumeration.getEnumerationliteral().stream().map(EnumerationLiteral::getName).sorted().toList();
        } else if(type instanceof BooleanType) {
            return List.of("true", "false");
        }
        return List.of();
    }

    public List<Long> getValues(Type type, FormAnswers answers) {

        var answerCount = Streams.stream(answers.eAllContents())
                .filter(Answer.class::isInstance)
                .map(Answer.class::cast)
                .filter(answer -> answer.getQuestion().getType() == type && answer.getAnswer() != null && !answer.getAnswer().isBlank())
                .collect(Collectors.groupingBy(Answer::getAnswer, Collectors.counting()));

        if (type instanceof EnumerationType enumeration) {
            var emptyMap = enumeration.getEnumerationliteral().stream()
                    .map(EnumerationLiteral::getName)
                    .collect(Collectors.toMap(Function.identity(), (ignored) -> 0L));

            return List.copyOf(Stream.concat(emptyMap.entrySet().stream(), answerCount.entrySet().stream())
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Math::max))
                            .entrySet())
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .map(Map.Entry::getValue)
                    .toList();
        } else if(type instanceof BooleanType) {
            return List.of(answerCount.getOrDefault("true", 0L), answerCount.getOrDefault("false", 0L));
        }
        return List.of();
    }

}
