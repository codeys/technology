package com.technical.terchnicalsummary.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @ClassName RocketMqConsumer
 * @Description TODO
 * @Author yushuai
 * @Date 2022/6/5 13:37
 * @Version 1.0
 **/
public class RocketMqConsumer {

    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer mqPushConsumer = new DefaultMQPushConsumer("consumerGroup");
        mqPushConsumer.setNamesrvAddr("172.16.22.220:9876");
        mqPushConsumer.subscribe("testTopic","test");
        /**
         * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费<br>
         * 如果非第一次启动，那么按照上次消费的位置继续消费
         */
        mqPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        syncMessage(mqPushConsumer);

        mqPushConsumer.start();
    }

    /**
     * 功能描述 同步消费
     * @author yushuai
     * @date 2022/6/5
     * @param mqPushConsumer
     * @return void
     */
    public static void syncMessage(DefaultMQPushConsumer mqPushConsumer) {
        mqPushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt messageExt : list) {
                    System.out.println(new String(messageExt.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
    }

    /**
     * 功能描述 顺序消费
     * @author yushuai
     * @date 2022/6/5
     * @param mqPushConsumer
     * @return void
     */
    public static void orderMessage(DefaultMQPushConsumer mqPushConsumer) {
        mqPushConsumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                consumeOrderlyContext.setAutoCommit(true);
                for (MessageExt msg : list) {
                    System.out.println("consumeThread=" + Thread.currentThread().getName() + "queueId=" + msg.getQueueId() + ", content:" + new String(msg.getBody()));
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
    }
}
