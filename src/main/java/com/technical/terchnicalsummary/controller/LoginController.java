package com.technical.terchnicalsummary.controller;
/*
 * @ClassName LoginController
 * @Description 登录控制器
 * @Author shuai_yu
 * @Date 2021/9/14 11:15
 **/

import com.technical.terchnicalsummary.model.Users;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/index")
public class LoginController {

    @GetMapping("/loginPage")
    public String login() {
        return "login";
    }

    @RequestMapping("/fail")
    public String fail() {
        return "fail";
    }

    @RequestMapping("/success")
    public String success() {
        return "success";
    }

    @GetMapping("findAll")
    @ResponseBody
    public String findAll() {
        return "findAll";
    }

    @PostMapping("/login")
    @ResponseBody
    public String loginAction() {
        return "login success";
    }

    /**
     * 判断是否具有角色，另外需要注意的是这里匹配的字符串需要添加前缀“ROLE_“。
     *
     * 进入方法前校验权限
     *
     * 使用注解先要开启注解功能！
     *
     * @EnableGlobalMethodSecurity(securedEnabled=true)
     * @return
     */
    @GetMapping("/testSecured")
    @ResponseBody
    @Secured({"ROLE_管理员","ROLE_普通用户"}) //校验权限的注解
    public String testSecured(){
        return "hello,Secured";
    }

    @GetMapping("/testSecured1")
    @ResponseBody
    @Secured({"ROLE_普通用户"}) //校验权限的注解
    public String testSecured1(){
        return "hello,Secured1";
    }

    @GetMapping("/testSecured2")
    @ResponseBody
    @Secured({"ROLE_管理员"}) //校验权限的注解
    public String testSecured2(){
        return "hello,Secured2";
    }

    /**
     * @PreAuthorize：注解适合进入方法前的权限验证， @PreAuthorize 可以将登录用 户的 roles/permissions 参数传到方法中。
     *
     * 进入方法前校验权限
     *
     * 先开启注解功能：
     *
     * @EnableGlobalMethodSecurity(prePostEnabled = true)
     * @return
     */
    @GetMapping("/testPreAuthorize")
    @PreAuthorize("hasAnyAuthority('menu:system')")
    public String testPreAuthorize(){
        System.out.println("PreAuthorize");
        return "hello PreAuthorize";
    }

    @GetMapping("/testPreAuthorize1")
    @PreAuthorize("hasRole('ROLE_普通用户')")
    public String testPreAuthorize1(){
        System.out.println("PreAuthorize1");
        return "hello PreAuthorize1";
    }

    /**
     * @PostFilter ：权限验证之后对数据进行过滤 留下用户名是 admin1 的数据
     * @PreFilter: 进入控制器之前对数据进行过滤
     * @return
     */
    @RequestMapping("/getALl")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_管理员')")
    @PostFilter("filterObject.username == 'admin1'")
    public List<Users> getAllUser(){
        System.out.println("PostFilter");
        List<Users> list = new ArrayList<>();
        list.add(new Users(1,"admin1","6666"));
        list.add(new Users(2,"admin2","888"));
        return list;
    }

    @RequestMapping("getTestPreFilter")
    @PreAuthorize("hasRole('ROLE_管理员')")
    @PreFilter(value = "filterObject.id%2==0")
    public List<Users> getTestPreFilter(@RequestBody List<Users> list){
        list.forEach(t-> {
            System.out.println(t.toString());
        });
        return list;
    }

    @PostMapping("/setRiskScore")
    @ResponseBody
    public Map getScore() {
        Map<String, Object> result = new HashMap<>();
        result.put("success",true);
        result.put("data", null);
        result.put("errorCode", null);
        result.put("errorName", null);
        result.put("errorMessage", null);
        return result;
    }
}
