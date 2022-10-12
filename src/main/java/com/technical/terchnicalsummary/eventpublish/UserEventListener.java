package com.technical.terchnicalsummary.eventpublish;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener implements ApplicationListener<UserEvent> {

//    @EventListener(classes = {UserEvent.class})
//    public void userEventListener(UserEvent userEvent) {
//        System.out.println("userEvent监听：" + userEvent.getName());
//    }

//    ApplicationContext applicationContext1 = ApplicationContextUtils.getApplicationContext();
//    UserEvent userEvent = new UserEvent(new Object());
//    userEvent.setName("张三");
//    pplicationContext1.publishEvent(userEvent);

    @Override
    public void onApplicationEvent(UserEvent userEvent) {
        System.out.println("userEvent监听：" + userEvent.getName());
    }
}
