package com.technical.terchnicalsummary.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.technical.terchnicalsummary.shiro.realm.MyRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Autowired
    MyRealm myRealm;

    @Bean
    public DefaultSecurityManager securityManager() {
        // 1.创建securityManager对象
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        // 2.配置自定义realm
        defaultWebSecurityManager.setRealm(myRealm);

        return defaultWebSecurityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        // 1.创建shiro过滤器
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 2.配置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 3.配置过滤规则
        Map<String, String> filter = new HashMap<>();
        filter.put("/**","anon");
//        filter.put("/login","anon");
//        filter.put("/logout","logout");
//        filter.put("/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filter);
        // 4.配置登录url
        shiroFilterFactoryBean.setLoginUrl("/loginPage");
        // 5.配置登录成功后跳转的url
        shiroFilterFactoryBean.setSuccessUrl("/main");
        // 6.配置未授权跳转的url
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuthorization");

        return shiroFilterFactoryBean;
    }

    /**
     * 为了在thymeleaf中使用shiro的自定义tag
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

}
