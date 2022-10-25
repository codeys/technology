package com.technical.terchnicalsummary.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class MyRealm extends AuthorizingRealm {
    /**
     * 授权Realm
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 1.获取用户身份信息
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
        // 2.根据用户身份信息获取用户权限信息
        // 3.封装SimpleAuthorizationInfo对象
        Set<String> roles = new HashSet<>();
        roles.add("admin");
        Set<String> permissions = new HashSet<>();
        permissions.add("user:select");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roles);
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证Realm
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String name = usernamePasswordToken.getUsername();

        // 1.根据用户名获取用户信息
        Map<String, String> userInfoMap = new HashMap<>();
        String password = "123";
        userInfoMap.put("username", "zhangsan");
        userInfoMap.put("password", password);
        if (!"zhangsan".equals(name)) {
            throw new UnknownAccountException("用户名不存在");
        }
        // 2.封装SimpleAuthenticationInfo信息
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userInfoMap, password, getName());
        return simpleAuthenticationInfo;
    }
}
