package com.technical.terchnicalsummary.config.listener;
/*
 * @ClassName MyEventListener
 * @Description 自定义监听器
 * @Author shuai_yu
 * @Date 2021/9/20 13:27
 **/

import com.technical.terchnicalsummary.config.listener.event.MyEvent;
import com.technical.terchnicalsummary.model.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyEventListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        // 把事件中的信息获取到
        Users users = myEvent.getUsers();
        // 处理事件，实际项目中可以通知别的微服务或者处理其他逻辑等
        log.info("用户名：" + users.getUsername());
        log.info("密码：" + users.getPassword());
    }
}
