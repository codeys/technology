package com.technical.terchnicalsummary.aop.annotion;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface After {
    Class clazz();

    String method() default "after";

    String values() default "";

    String type() default "";
}
