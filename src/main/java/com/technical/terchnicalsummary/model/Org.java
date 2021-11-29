package com.technical.terchnicalsummary.model;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Org {
    public Org(){
        System.out.println("org 构造函数。。。。。。");
    }

    @PostConstruct
    public void init(){
        System.out.println("org 初始化方法");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("org 销毁方法");
    }
}
