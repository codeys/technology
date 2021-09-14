package com.technical.terchnicalsummary.mapper;
/*
 * @ClassName User
 * @Description 用户mapper
 * @Author shuai_yu
 * @Date 2021/7/7 15:15
 **/

import com.technical.terchnicalsummary.model.User;

import java.util.List;

public interface UserMapper {

    int getUserCount();

    void insertUser(User user);

    void updateUser();

    List<User> getUserByPage();
}
