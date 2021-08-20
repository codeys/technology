package com.technical.terchnicalsummary.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/*
 * @ClassName MyAspect
 * @Description 切面
 * @Author shuai_yu
 * @Date 2021/8/18 17:29
 **/
@Aspect
@Component
public class MyAspect {
    @Pointcut("@annotation(com.technical.terchnicalsummary.aop.annotion.Around)")
    public void pointAround(){}
    @Pointcut("@annotation(com.technical.terchnicalsummary.aop.annotion.Before)")
    public void pointBefore(){}
    @Pointcut("@annotation(com.technical.terchnicalsummary.aop.annotion.After)")
    public void pointAfter(){}
    @Pointcut("@annotation(com.technical.terchnicalsummary.aop.annotion.AfterReturning)")
    public void pointAfterReturning(){}

    @Around("pointAround()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        com.technical.terchnicalsummary.aop.annotion.Around annotation = (com.technical.terchnicalsummary.aop.annotion.Around)method.getAnnotation(com.technical.terchnicalsummary.aop.annotion.Around.class);
        Class clazz = annotation.clazz();
        Method method1 = clazz.getMethod(annotation.method(), ProceedingJoinPoint.class);
        method1.setAccessible(true);
        return method1.invoke(clazz.newInstance(), joinPoint);
    }

    @AfterReturning("pointAfterReturning()")
    public void afterRetruning(JoinPoint joinPoint) {
        try {
            MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
            Method method = methodSignature.getMethod();
            com.technical.terchnicalsummary.aop.annotion.AfterReturning annotation = (com.technical.terchnicalsummary.aop.annotion.AfterReturning)method.getAnnotation(com.technical.terchnicalsummary.aop.annotion.AfterReturning.class);
            Class clazz = annotation.clazz();
            Method method1 = clazz.getMethod(annotation.method(), JoinPoint.class);
            method1.setAccessible(true);
            method1.invoke(clazz.newInstance(), joinPoint);
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }

    @After("pointAfter()")
    public void after(JoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        com.technical.terchnicalsummary.aop.annotion.After annotation = (com.technical.terchnicalsummary.aop.annotion.After)method.getAnnotation(com.technical.terchnicalsummary.aop.annotion.After.class);
        Class clazz = annotation.clazz();
        Method method1 = clazz.getMethod(annotation.method(), JoinPoint.class);
        method1.setAccessible(true);
        method1.invoke(clazz.newInstance(), joinPoint);
    }

    @Before("pointBefore()")
    public void before(JoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        com.technical.terchnicalsummary.aop.annotion.Before annotation = (com.technical.terchnicalsummary.aop.annotion.Before)method.getAnnotation(com.technical.terchnicalsummary.aop.annotion.Before.class);
        Class clazz = annotation.clazz();
        Method method1 = clazz.getMethod(annotation.method(), JoinPoint.class);
        method1.setAccessible(true);
        method1.invoke(clazz.newInstance(), joinPoint);
    }

}
