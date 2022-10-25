package com.technical.terchnicalsummary.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ShiroController {

    @GetMapping("/loginPage")
    public String loginPage() {
        return "shiro/login";
    }

    @PostMapping("/login")
    public String login(String username,String password,HttpSession httpSession) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            if (!subject.isAuthenticated()) {
                subject.login(usernamePasswordToken);
                httpSession.setAttribute("username",subject.getPrincipal().toString());
            }
            return "shiro/main";
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping("/userRoles")
    @RequiresRoles({"admin"})
    @ResponseBody
    public String userRoles() {
        return "验证角色成功";
    }

    @RequestMapping("/userPermissions")
    @RequiresPermissions({"user:del"})
    @ResponseBody
    public String userPermissions() {
        return "验证角色成功";
    }

}
