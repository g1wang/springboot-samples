package com.example.springbootrocketmq.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/6/26 13:59
 */
//@Component
@RocketMQMessageListener(topic = "ww_delay_topic", //topic主题
        consumerGroup = "consumer-group",          //消费组
        messageModel = MessageModel.CLUSTERING,
        consumeMode = ConsumeMode.CONCURRENTLY,
        consumeThreadMax = 20)
@Slf4j
public class DemoConsumer implements RocketMQListener<MessageExt> {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void onMessage(MessageExt messageExt) {
        //log.info("接受到消息：{}", messageExt);
        // 消费过程重启测试
        /*try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            log.info("休眠异常");
            //throw new RuntimeException("休眠异常");
        }*/
        // 异常测试
        /*try {
            throw new Exception("asdf");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
        log.info("第{}个消息消费完成", atomicInteger.incrementAndGet());
    }
}
