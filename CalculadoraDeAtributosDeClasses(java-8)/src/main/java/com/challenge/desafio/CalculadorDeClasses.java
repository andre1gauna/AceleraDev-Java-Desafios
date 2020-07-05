package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.util.Arrays;

public class CalculadorDeClasses implements Calculavel {


    @Override
    public BigDecimal somar(Object object) {

        return SomadorDeAtributos(object, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object object) {

        return SomadorDeAtributos(object, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object object) {

        return somar(object).subtract(subtrair(object));
    }

    public BigDecimal SomadorDeAtributos(Object object, Class<? extends Annotation> annotation)
    {
        return Arrays.asList(object.getClass().getDeclaredFields())
                .stream()
                .filter(f -> f.isAnnotationPresent(annotation))
                .map(m -> {
                    try {
                        m.setAccessible(true);
                        return (BigDecimal)m.get(object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return BigDecimal.ZERO;
                    }
                })
                .reduce(BigDecimal.ZERO, (acc, prox) -> acc.add(prox));
    }
}
