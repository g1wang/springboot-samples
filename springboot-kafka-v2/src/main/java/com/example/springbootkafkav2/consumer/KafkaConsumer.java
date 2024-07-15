package com.example.springbootkafkav2.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author wanggl
 * @Date 2024/7/13 13:47
 */
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(id = "cur-id",topics = "test-cur",groupId = "test_cur_group",concurrency = "5")
    public void consume(ConsumerRecord<?, ?> record){
        log.info("接收消息：key:{},value:{}",record.value(),record.value());
        try {
            Thread.sleep(65000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("消息处理完成：key:{},value:{}",record.value(),record.value());

    }
}
