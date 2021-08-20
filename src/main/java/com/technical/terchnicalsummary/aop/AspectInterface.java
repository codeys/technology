package com.technical.terchnicalsummary.aop;
/*
 * @ClassName AspectInterface
 * @Description 切面接口
 * @Author shuai_yu
 * @Date 2021/8/18 16:33
 **/

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public interface AspectInterface {
    Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable;

    void afterReturning(JoinPoint joinPoint) throws Throwable;

    void after(JoinPoint joinPoint) throws Throwable;

    void before(JoinPoint joinPoint) throws Throwable;
}
