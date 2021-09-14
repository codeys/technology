package com.technical.terchnicalsummary.mapper;
/*
 * @ClassName UserInfoMapper
 * @Description 用户信息
 * @Author shuai_yu
 * @Date 2021/9/14 14:02
 **/

import com.technical.terchnicalsummary.model.Menu;
import com.technical.terchnicalsummary.model.Role;

import java.util.List;

public interface UserInfoMapper {

    List<Role> selectRoleByUserId(Long userId);

    List<Menu> selectMenuByUserId(Long userid);
}
