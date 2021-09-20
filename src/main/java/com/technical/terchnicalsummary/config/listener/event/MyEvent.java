package com.technical.terchnicalsummary.config.listener.event;
/*
 * @ClassName MyEvent
 * @Description 自定义事件
 * @Author shuai_yu
 * @Date 2021/9/20 13:25
 **/

import com.technical.terchnicalsummary.model.Users;
import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
    private Users users;
    public MyEvent(Object source,Users users) {
        super(source);
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}


