package com.technical.terchnicalsummary.controller;
/*
 * @ClassName DemoController
 * @Description controller
 * @Author shuai_yu
 * @Date 2021/7/12 10:06
 **/

import com.technical.terchnicalsummary.aop.annotion.Around;
import com.technical.terchnicalsummary.config.aop.RecordLogAspect;
import com.technical.terchnicalsummary.service.IBuy;
import com.technical.terchnicalsummary.service.impl.Boy;
import com.technical.terchnicalsummary.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DemoController {

    @Autowired
    Boy boy;
    @Autowired
    RedisUtils redisUtils;

    @ResponseBody
    @RequestMapping("/aop")
    @Around(clazz = RecordLogAspect.class)
    public String aop() {
        redisUtils.set("age","111");
        boy.buy();
        return "test";
    }


    @RequestMapping("/form")
    public String form(String name,String age) {
        return "form";
    }

    @ResponseBody
    @RequestMapping("/submitForm")
    public String submitForm(String name,String age) {
        return "form";
    }
}
