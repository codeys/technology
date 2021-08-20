package com.technical.terchnicalsummary.config.aop;

import com.technical.terchnicalsummary.aop.AspectInterface;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/*
 * @ClassName RecordLogAspect
 * @Description 日志切面
 * @Author shuai_yu
 * @Date 2021/8/18 17:35
 **/
public class RecordLogAspect implements AspectInterface {
    @Override
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        return  proceedingJoinPoint.proceed();
    }

    @Override
    public void afterReturning(JoinPoint joinPoint) throws Throwable {

    }

    @Override
    public void after(JoinPoint joinPoint) throws Throwable {

    }

    @Override
    public void before(JoinPoint joinPoint) throws Throwable {

    }
}
