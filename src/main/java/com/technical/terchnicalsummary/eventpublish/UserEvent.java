package com.technical.terchnicalsummary.eventpublish;

import org.springframework.context.ApplicationEvent;

public class UserEvent extends ApplicationEvent {

    private String name;

    public UserEvent(Object source) {
        super(source);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
