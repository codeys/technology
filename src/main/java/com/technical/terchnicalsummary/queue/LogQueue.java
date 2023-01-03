package com.technical.terchnicalsummary.queue;

import java.util.concurrent.*;

/**
 * 操作日志的队列
 */
public class LogQueue {
    private static final int QUEUE_MAX_VALUE = 1000;

    private static int corePoolSize = 20;

    private static int maximumPoolSize = corePoolSize + 10;

    private static long keepAliveTime = 50;

    private static TimeUnit timeUnit = TimeUnit.SECONDS;

    public static BlockingQueue<LogEntity> blockingQueue = null;

    public static ThreadPoolExecutor executor = null;

    static {
        blockingQueue = new LinkedBlockingQueue<>(QUEUE_MAX_VALUE);
        executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, timeUnit, new LinkedBlockingQueue<>(QUEUE_MAX_VALUE),new ThreadPoolExecutor.DiscardPolicy());
    }

    /**
     * 消息入队
     * @param logEntity
     * @return
     */
    public static void push(LogEntity logEntity) throws Exception {
        //队列已满时,会阻塞队列,直到未满
        blockingQueue.put(logEntity);
    }

    /**
     * 消息出队
     * @return
     */
    public static LogEntity poll() {
        LogEntity result = null;
        try {
            //队列为空时会阻塞队列,直到不是空
            result = blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
