package com.example.springbootrocketmq.web;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/6/26 9:25
 */
@RestController
public class NormalProduceController {
    @Resource
    private RocketMQTemplate rocketmqTemplate;
    AtomicInteger atomicInteger = new AtomicInteger(0);

    @GetMapping("/test")
    public SendResult test(Integer size) {
        if (size==null) size =20;
        //可以不用 setHeader 设置tag 标签
        List<Message> messageList = new ArrayList<>();
        for (int i = 0; i <size ; i++) {
            messageList.add( MessageBuilder.withPayload("Hello,RocketMQ,"+atomicInteger.incrementAndGet()).build());
        }
        SendResult sendResult = rocketmqTemplate.syncSend("test_topic", messageList);
        return sendResult;
    }
}
