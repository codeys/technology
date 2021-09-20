package com.technical.terchnicalsummary.config.listener;
/*
 * @ClassName CustomHttpSessionListener
 * @Description 监听 HTTP 会话 Session 对象
 * @Author shuai_yu
 * @Date 2021/9/20 13:09
 **/

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Slf4j
@Component
public class CustomHttpSessionListener implements HttpSessionListener {
    public static int count = 0;
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        log.info("新用户上线了");
        count++;
        httpSessionEvent.getSession().getServletContext().setAttribute("count", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        log.info("用户下线了");
        count--;
        httpSessionEvent.getSession().getServletContext().setAttribute("count", count);
    }
}
