package com.technical.terchnicalsummary.aop.annotion;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Around {
    Class clazz();

    String method() default "around";

    String values() default "";

    String type() default "";
}
