package com.technical.terchnicalsummary.annotation;
/*
 * @ClassName TestBO
 * @Description
 * @Author shuai_yu
 * @Date 2021/10/9 15:52
 **/

@MyAnnotation(name="testClass",id=2,gid=Long.class) //使用了类注解
public class TestBO {

    private String name;

    public TestBO() {

    }

    @MyAnnotation(name="testMethod",gid=Integer.class) //使用了类方法注解
    public void test() {

    }
}
