package com.technical.terchnicalsummary.runner;

import com.technical.terchnicalsummary.queue.LogThread;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TerchnicalApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 启动日志收集
        Thread logThread = new Thread(new LogThread());
        logThread.start();
    }
}
