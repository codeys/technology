//package com.technical.terchnicalsummary.config.security;
///*
// * @ClassName SecurityConfig
// * @Description security配置
// * @Author shuai_yu
// * @Date 2021/9/14 10:34
// **/
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//    @Autowired
//    private DataSource dataSource;
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
////        String encode = passwordEncoder.encode("123");
////        auth.inMemoryAuthentication().withUser("lzg").password(encode).roles("admin");
////    }
//
//    //将密码加密器加到容器中
//    @Bean
//    public PasswordEncoder getPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    //重写configure配置,将我们自己的校验密码器注入到该bean中
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
//    }
//
//    //重写configure配置,编写权限校验规则
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .loginPage("/loginPage").permitAll() //登录页面跳转请求
//                .loginProcessingUrl("/login").permitAll() //登录访问的路径
//                .successForwardUrl("/success").permitAll() //登录成功页面
//                .failureForwardUrl("/fail"); //无权限页面
//
//        //权限控制
//        http.authorizeRequests() // 认证配置
//                .antMatchers("/","/loginPage","/hello").permitAll() //设置哪些路径可以直接访问，不需要认证
////                .antMatchers("/findAll").hasAuthority("admin") // hasAuthority()，当前登录的用户，只有具有了admin权限才可以访问这个路径
////                .antMatchers("/findAll").hasAnyAuthority("admin,manager") //hasAnyAuthority()，当前登录的用户，有其中一个权限就能访问这个路径
////                .antMatchers("/findAll").hasAnyRole("sale") //hasAnyRole()，当前登录的用户，有其中一个角色就能访问这个路径
//                .antMatchers("/findAll").hasRole("管理员")
//                .antMatchers("/findAll").hasAnyAuthority("menu:system")
//                .anyRequest() // 任何请求
//                .authenticated() // 都需要身份验证
//                .and().csrf().disable();//关闭cors
//
//        //记住我
//        http.rememberMe()
//                .userDetailsService(userDetailsService) // 设置userDetailsService
//                .tokenRepository(persistentTokenRepository()) // 设置数据访问层
//                .tokenValiditySeconds(60 * 60);
//
//        //配置没有权限访问跳转自定义页面
//        http.exceptionHandling().accessDeniedPage("/fail");
//
//        //退出
//        http.logout().logoutUrl("/logout") //退出的请求
//                .logoutSuccessUrl("/loginPage").permitAll(); //退出成功之后跳转的页面
//    }
//
//    /**
//     * 持久化token
//     *
//     * Security中，默认是使用PersistentTokenRepository的子类InMemoryTokenRepositoryImpl，将token放在内存中
//     * 如果使用JdbcTokenRepositoryImpl，会创建表persistent_logins，将token持久化到数据库
//     */
//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
//        tokenRepository.setDataSource(dataSource); // 设置数据源
////        tokenRepository.setCreateTableOnStartup(true); // 启动创建表，创建成功后注释掉
//        return tokenRepository;
//    }
//
//}
