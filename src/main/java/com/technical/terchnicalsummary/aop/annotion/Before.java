package com.technical.terchnicalsummary.aop.annotion;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Before {
    Class clazz();

    String method() default "before";

    String values() default "";

    String type() default "";
}
