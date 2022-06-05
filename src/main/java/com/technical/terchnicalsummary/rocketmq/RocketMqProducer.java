package com.technical.terchnicalsummary.rocketmq;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RocketMqMain
 * @Description TODO
 * @Author yushuai
 * @Date 2022/6/5 13:24
 * @Version 1.0
 **/
public class RocketMqProducer {

    public static void main(String[] args) throws Exception  {
        DefaultMQProducer mqProducer = new DefaultMQProducer("testProducerGroup");
        mqProducer.setNamesrvAddr("172.16.22.191:9876");
        mqProducer.start();
        orderSendMessage(mqProducer);
        mqProducer.shutdown();
    }

    /**
     * 功能描述 同步发送消息
     * @author yushuai
     * @date 2022/6/5
     * @param mqProducer
     * @return void
     */
    public static void syncSendMessage(DefaultMQProducer mqProducer) throws Exception{
        Message message = new Message("testTopic","test","你好 rocketmq".getBytes());
        mqProducer.send(message);
    }

    /**
     * 功能描述 顺序发送消息
     * @author yushuai
     * @date 2022/6/5
     * @param mqProducer
     * @return void
     */
    public static void orderSendMessage(DefaultMQProducer mqProducer) throws Exception{
        List<OrderStep> orderSteps = buildOrders();
        for (int i = 0; i < orderSteps.size(); i++) {
            String body = JSON.toJSONString(orderSteps.get(i));
            Message message = new Message("orderTopic", "order", body.getBytes());
            mqProducer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object arg) {
                    Long orderId = (Long)arg;
                    int index = (int) (orderId % list.size());
                    return  list.get(index);
                }
            },orderSteps.get(i).getDesc());
        }
    }

    private static class OrderStep{
        private long orderId;
        private String desc;

        public long getOrderId() {
            return orderId;
        }

        public void setOrderId(long orderId) {
            this.orderId = orderId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "OrderStep{" +
                    "orderId=" + orderId +
                    ", desc='" + desc + '\'' +
                    '}';
        }
    }

    /**
     * 生成模拟订单数据
     */
    private static List<OrderStep> buildOrders() {
        List<OrderStep> orderList = new ArrayList<OrderStep>();

        OrderStep orderDemo = new OrderStep();
        orderDemo.setOrderId(1L);
        orderDemo.setDesc("创建");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(2L);
        orderDemo.setDesc("创建");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(1L);
        orderDemo.setDesc("付款");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(3L);
        orderDemo.setDesc("创建");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(2L);
        orderDemo.setDesc("付款");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(3L);
        orderDemo.setDesc("付款");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(1L);
        orderDemo.setDesc("完成");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(1L);
        orderDemo.setDesc("推送");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(2L);
        orderDemo.setDesc("完成");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(3L);
        orderDemo.setDesc("完成");
        orderList.add(orderDemo);

        return orderList;
    }


}
