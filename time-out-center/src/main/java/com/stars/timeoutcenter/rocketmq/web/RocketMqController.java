package com.stars.timeoutcenter.rocketmq.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.apis.ClientConfiguration;
import org.apache.rocketmq.client.apis.ClientConfigurationBuilder;
import org.apache.rocketmq.client.apis.ClientException;
import org.apache.rocketmq.client.apis.ClientServiceProvider;
import org.apache.rocketmq.client.apis.message.Message;
import org.apache.rocketmq.client.apis.message.MessageBuilder;
import org.apache.rocketmq.client.apis.producer.Producer;
import org.apache.rocketmq.client.apis.producer.SendReceipt;
import org.apache.rocketmq.client.java.message.MessageBuilderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/11/1 10:19
 */
@RestController
@RequestMapping("rocketmq")
@Slf4j
public class RocketMqController {

    @GetMapping
    public SendReceipt postMessage(Integer delay) throws ClientException {
        String endpoint = "127.0.0.1:8081";
        String namespace = "127.0.0.1:9876";
        // 消息发送的目标Topic名称，需要提前创建。
        String topic = "ww_delay_topic";
        ClientServiceProvider provider = ClientServiceProvider.loadService();
        ClientConfigurationBuilder builder = ClientConfiguration.newBuilder().setEndpoints(endpoint).setNamespace(namespace);
        ClientConfiguration configuration = builder.build();
        // 初始化Producer时需要设置通信配置以及预绑定的Topic。
        Producer producer = provider.newProducerBuilder()
                .setTopics(topic)
                .setClientConfiguration(configuration)
                .build();
        // 创建一个生产者实例，指定生产者组名

        //定时/延时消息发送
        //以下示例表示：延迟时间为10分钟之后的Unix时间戳。
        //定时/延时消息发送
        MessageBuilder messageBuilder = new MessageBuilderImpl();
        ;
        //以下示例表示：延迟时间为10分钟之后的Unix时间戳。
        Long deliverTimeStamp = System.currentTimeMillis() + delay * 60 * 60 * 1000;
        Message message = messageBuilder.setTopic("ww_delay_topic")
                //设置消息索引键，可根据关键字精确查找某条消息。
                .setKeys("messageKey")
                //设置消息Tag，用于消费端根据指定Tag过滤消息。
                .setTag("messageTag")
                .setDeliveryTimestamp(deliverTimeStamp)
                //消息体
                .setBody("messageBody".getBytes())
                .build();
        try {
            //发送消息，需要关注发送结果，并捕获失败等异常。
            SendReceipt sendReceipt = producer.send(message);
            System.out.println(sendReceipt.getMessageId());
            return sendReceipt;
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;

    }

}
