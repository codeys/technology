package com.technical.terchnicalsummary.config.listener;
/*
 * @ClassName CustomServletRequestListener
 * @Description 监听客户端请求 Servlet Request 对象
 * @Author shuai_yu
 * @Date 2021/9/20 13:17
 **/

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class CustomServletRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        log.info("session id为：{}", request.getRequestedSessionId());
        log.info("request url为：{}", request.getRequestURL());
        request.setAttribute("name", "张三");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        log.info("request end");
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        log.info("request域中保存的name值为：{}", request.getAttribute("name"));
    }
}
