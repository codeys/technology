package com.technical.terchnicalsummary.queue;

/**
 * 从队列里获取数据
 */
public class LogThread implements Runnable {

    @Override
    public void run() {
        while (true){
            LogEntity logEntity = LogQueue.poll();
            if (logEntity != null) {
                LogQueue.executor.submit(new LogHandleThread(logEntity));
            }
        }
    }
}
