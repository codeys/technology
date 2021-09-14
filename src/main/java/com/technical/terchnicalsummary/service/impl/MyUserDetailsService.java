package com.technical.terchnicalsummary.service.impl;
/*
 * @ClassName MyUserDetailsService
 * @Description 登录实现类
 * @Author shuai_yu
 * @Date 2021/9/14 10:58
 **/

import com.technical.terchnicalsummary.mapper.UserInfoMapper;
import com.technical.terchnicalsummary.mapper.UserMapper;
import com.technical.terchnicalsummary.model.Menu;
import com.technical.terchnicalsummary.model.Role;
import com.technical.terchnicalsummary.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("UserDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
         Users users = new Users();
        users.setUsername(s);
        Users user = userMapper.getUsersByUserName(users);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
//        List<GrantedAuthority> list = AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_sale");
        //权限集合
        List<GrantedAuthority> list = new ArrayList<>();
        List<Role> roleList = userInfoMapper.selectRoleByUserId(Long.valueOf(user.getId()));
        List<Menu> menuList = userInfoMapper.selectMenuByUserId(Long.valueOf(user.getId()));
        //处理角色
        for (Role role : roleList) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }
        //处理权限
        for (Menu menu : menuList) {
            list.add(new SimpleGrantedAuthority(menu.getPermission()));
        }

        return new User(user.getUsername(),user.getPassword(),list);
    }
}
