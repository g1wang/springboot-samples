/*
package com.example.springbootrocketmq.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

*/
/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/6/26 13:59
 *//*

@Component
@RocketMQMessageListener(topic = "test_topic", //topic主题
        consumerGroup = "consumer-group",          //消费组
        messageModel = MessageModel.CLUSTERING,
        consumeMode = ConsumeMode.ORDERLY)
@Slf4j
public class DemoConsumer2 implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("接受到消息2：{}", message);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
*/
