package com.programacion.services;

import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.inject.Qualifier;

import java.lang.annotation.*;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD })
public @interface MiBean {
    public static final class Literal extends AnnotationLiteral<MiBean> implements MiBean {
        private static final long serialVersionUID = 1L;
        public static final Literal INSTANCE = new Literal();
    }
}
