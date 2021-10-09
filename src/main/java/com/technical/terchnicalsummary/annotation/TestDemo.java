package com.technical.terchnicalsummary.annotation;
/*
 * @ClassName TestDemo
 * @Description
 * @Author shuai_yu
 * @Date 2021/10/9 16:31
 **/

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestDemo {

    public static void parseTypeAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("com.technical.terchnicalsummary.annotation.TestBO");
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            MyAnnotation myAnnotation = (MyAnnotation) annotation;
            System.out.println("class:   id="+myAnnotation.id() + ";name="+myAnnotation.name()+";gid="+myAnnotation.gid());
        }
    }

    public static void parseMethodAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("com.technical.terchnicalsummary.annotation.TestBO");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            boolean annotationPresent = method.isAnnotationPresent(MyAnnotation.class);
            if (annotationPresent) {
                MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
                System.out.println("method:  id="+myAnnotation.id() + ";name="+myAnnotation.name()+";gid="+myAnnotation.gid());
            }
        }

    }

    public static void main(String[] args) throws ClassNotFoundException {
        parseTypeAnnotation();
        parseMethodAnnotation();
    }
}
