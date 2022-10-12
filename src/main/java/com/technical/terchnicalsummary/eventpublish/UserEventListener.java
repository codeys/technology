package com.technical.terchnicalsummary.eventpublish;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserEventListener {

    @Autowired
    JdbcTemplate jdbcTemplate;

//    @TransactionalEventListener(classes = {UserEvent.class})
    @EventListener(classes = {UserEvent.class})
    public void userEventListener(UserEvent userEvent) {
        String sql = "select * from user";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql);
        System.out.println(JSON.toJSONString(stringObjectMap));
        System.out.println("userEvent监听：" + userEvent.getName());
    }

//    ApplicationContext applicationContext1 = ApplicationContextUtils.getApplicationContext();
//    UserEvent userEvent = new UserEvent(new Object());
//    userEvent.setName("张三");
//    pplicationContext1.publishEvent(userEvent);



}
