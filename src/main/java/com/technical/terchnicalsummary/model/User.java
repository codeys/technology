package com.technical.terchnicalsummary.model;
/*
 * @ClassName User
 * @Description 用户实体
 * @Author shuai_yu
 * @Date 2021/7/7 17:15
 **/

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Data
@Component
public class User {

    @Autowired
    Org org;

    public User(){
        System.out.println("user 构造函数。。。");
    }
    private String id;
    private String userName;
    private String userAge;
    private String gender;

    @PostConstruct
    public void init() {
        System.out.println("user 初始化方法");
    }
}
