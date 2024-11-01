package com.example.springbootrocketmq.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/6/26 9:25
 */
@RestController
@Slf4j
public class NormalProduceController {
    @Resource
    private RocketMQTemplate rocketmqTemplate;
    AtomicInteger atomicInteger = new AtomicInteger(0);

    ExecutorService executorService = Executors.newFixedThreadPool(10);
    @GetMapping("/test")
    public String test(Integer size) {
        if (size == null) size = 20;
        //可以不用 setHeader 设置tag 标签
        List<Message> messageList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            executorService.submit(()->{
                Message message = MessageBuilder.withPayload("Hello,RocketMQ," + atomicInteger.incrementAndGet()).build();
                messageList.add(message);
                SendResult sendResult = rocketmqTemplate.syncSend("ww_delay_topic", message,1000,4);
                log.info("消息发送成功：{}",atomicInteger.incrementAndGet());
            });
        }
        return "OK";
    }
}
