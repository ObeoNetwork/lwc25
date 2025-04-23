package org.eclipse.sirius.lwc25.questionnaire.starter.services;

import org.eclipse.acceleo.query.runtime.*;
import org.eclipse.acceleo.query.validation.type.ClassType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.sirius.components.interpreter.ExpressionConverter;
import org.eclipse.sirius.components.interpreter.SimpleCrossReferenceProvider;
import org.eclipse.sirius.questionnaire.*;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AQLValidator {

    private static final String AQL_PREFIX = "aql:";

    private final IQueryEnvironment queryEnvironment;

    public AQLValidator(List<Object> instances, List<EPackage> ePackages) {
        queryEnvironment = Query.newEnvironmentWithDefaultServices(new SimpleCrossReferenceProvider());
        queryEnvironment.registerEPackage(EcorePackage.eINSTANCE);
        queryEnvironment.registerCustomClassMapping(EcorePackage.eINSTANCE.getEStringToStringMapEntry(), EStringToStringMapEntryImpl.class);

        for (Object instance : instances) {
            var services = ServiceUtils.getServices(queryEnvironment, instance);
            ServiceUtils.registerServices(queryEnvironment, services);
        }

        ePackages.stream().filter(this::isValidEPackage).forEach(queryEnvironment::registerEPackage);
    }

    public IValidationResult validate(String expressionBody, List<Question> questionVariables) {
        String expression = new ExpressionConverter().convertExpression(expressionBody);
        if (expression.startsWith(AQL_PREFIX)) {
            expression = expression.substring(AQL_PREFIX.length());
        }
        var types = questionVariables.stream()
                .collect(Collectors.toMap(NamedElement::getName, question -> Set.of(this.questionToIType(question.getType()))));
        return QueryValidation.newEngine(this.queryEnvironment).validate(expression, types);
    }

    private boolean isValidEPackage(EPackage ePackage) {
        return ePackage != null && ePackage.getName() != null && ePackage.getNsURI() != null;
    }

    private IType questionToIType(Type type) {
        if(type instanceof StringType || type instanceof EnumerationType) {
            return new ClassType(this.queryEnvironment, String.class);
        } else if(type instanceof BooleanType) {
            return new ClassType(this.queryEnvironment, boolean.class);
        } else if(type instanceof IntegerType) {
            return new ClassType(this.queryEnvironment, int.class);
        } else if(type instanceof DecimalType || type instanceof MoneyType) {
            return new ClassType(this.queryEnvironment, double.class);
        } else if(type instanceof DateType) {
            return new ClassType(this.queryEnvironment, Instant.class);
        }
        return null;
    }
}
