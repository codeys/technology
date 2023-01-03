package com.technical.terchnicalsummary.queue;

/**
 * 处理日志的线程
 */
public class LogHandleThread implements Runnable {

    private LogEntity logEntity;

    public LogHandleThread(LogEntity logEntity) {
        this.logEntity = logEntity;
    }

    @Override
    public void run() {
        System.out.println(logEntity.toString());
    }
}
