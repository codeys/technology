package com.technical.terchnicalsummary.controller;
/*
 * @ClassName DemoController
 * @Description controller
 * @Author shuai_yu
 * @Date 2021/7/12 10:06
 **/

import com.alibaba.fastjson.JSON;
import com.technical.terchnicalsummary.aop.annotion.Around;
import com.technical.terchnicalsummary.config.aop.RecordLogAspect;
import com.technical.terchnicalsummary.config.listener.event.MyEvent;
import com.technical.terchnicalsummary.mapper.UserMapper;
import com.technical.terchnicalsummary.model.Users;
import com.technical.terchnicalsummary.service.IBuy;
import com.technical.terchnicalsummary.service.impl.Boy;
import com.technical.terchnicalsummary.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class DemoController {

    @Autowired
    Boy boy;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ApplicationContext applicationContext;

    @ResponseBody
    @RequestMapping("/aop")
    @Around(clazz = RecordLogAspect.class)
    public String aop() {
        redisUtils.set("age","111");
        boy.buy();
        return "当前在线人数：";
    }

    /**
     * 触发自定义事件监听
     * @return
     */
    @ResponseBody
    @RequestMapping("/testMyEvent")
    public String testMyEvent() {
        Users users = new Users(1, "yu", "123456");
        MyEvent myEvent = new MyEvent(this, users);
        applicationContext.publishEvent(myEvent);
        log.info("触发器被触发");
        return "test my event";
    }

    @RequestMapping("/update")
    @ResponseBody
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String update() {
        long time1 = System.currentTimeMillis();
        userMapper.updateUser();
        long time2 = System.currentTimeMillis();
        System.out.println("耗时：" + (time2-time1));
        Map map = new HashMap();
        map.put("code","0");
        return JSON.toJSONString(map);
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
