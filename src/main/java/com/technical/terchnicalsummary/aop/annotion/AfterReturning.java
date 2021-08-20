package com.technical.terchnicalsummary.aop.annotion;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AfterReturning {
    Class clazz();

    String method() default "afterReturning";

    String values() default "";

    String type() default "";
}
