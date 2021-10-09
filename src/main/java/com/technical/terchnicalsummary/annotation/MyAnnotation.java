package com.technical.terchnicalsummary.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * @ClassName MyAnnotion
 * @Description 注解
 * @Author shuai_yu
 * @Date 2021/10/9 15:49
 *
 * @Target 表示该注解用于什么地方，可能的值在枚举类 ElemenetType 中，包括：
          ElementType.CONSTRUCTOR----------------------------构造器声明
          ElementType.FIELD --------------------------------------域声明（包括 enum 实例）
          ElementType.LOCAL_VARIABLE------------------------- 局部变量声明
          ElementType.METHOD ----------------------------------方法声明
          ElementType.PACKAGE --------------------------------- 包声明
          ElementType.PARAMETER ------------------------------参数声明
          ElementType.TYPE--------------------------------------- 类，接口（包括注解类型）或enum声明

     @Retention 表示在什么级别保存该注解信息。可选的参数值在枚举类型 RetentionPolicy 中，包括：
          RetentionPolicy.SOURCE ---------------------------------注解将被编译器丢弃
          RetentionPolicy.CLASS -----------------------------------注解在class文件中可用，但会被VM丢弃
          RetentionPolicy.RUNTIME VM-------将在运行期也保留注释，因此可以通过反射机制读取注解的信息。

      @Documented 将此注解包含在 javadoc 中 ，它代表着此注解会被javadoc工具提取成文档。在doc文档中的内容会因为此注解的信息内容不同而不同。相当与@see,@param 等。

      @Inherited 允许子类继承父类中的注解。
 **/
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String name();
    int id() default 0;
    Class gid();
}
