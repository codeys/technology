package com.technical.terchnicalsummary.config.listener;
/*
 * @ClassName CustomServletContextListener
 * @Description 监听 Servlet 上下文对象
 * @Author shuai_yu
 * @Date 2021/9/20 13:04
 **/

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class CustomServletContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Spring容器加载完成触发,可用于初始化环境，准备测试数据、加载一些数据到内存");
        //此处可以开启一个线程，用于查询首页数据，并缓存在内容中，供所有的首页进行查询
        //代码省略
    }
}
