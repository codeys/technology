package com.technical.terchnicalsummary.model;
/*
 * @ClassName User
 * @Description 用户实体
 * @Author shuai_yu
 * @Date 2021/7/7 17:15
 **/

import lombok.Data;

@Data
public class User {
    private String id;
    private String userName;
    private String userAge;
    private String gender;
}
