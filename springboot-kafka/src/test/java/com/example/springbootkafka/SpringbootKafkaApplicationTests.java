package com.example.springbootkafka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootTest
class SpringbootKafkaApplicationTests {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void productTest() {
        String message = "this in my house 2000";
        System.out.println("kafka的消息=" + message);
        kafkaTemplate.send("wwtest", "wwkey", message);
        //kafkaTemplate.send("wwtest",  message);
        System.out.println("发送kafka成功.");
    }



}
