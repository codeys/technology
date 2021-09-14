package com.technical.terchnicalsummary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @ClassName Users
 * @Description security实体
 * @Author shuai_yu
 * @Date 2021/9/14 10:49
 **/
@Data
@NoArgsConstructor
public class Users {

    public Users(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    private Integer id;
    private String username;
    private String password;
}
