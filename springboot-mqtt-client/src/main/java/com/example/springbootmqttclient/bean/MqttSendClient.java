package com.example.springbootmqttclient.bean;

import com.example.springbootmqttclient.config.MqttProperties;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/4/11 17:23
 */
@Component
public class MqttSendClient {
    @Autowired
    private MqttSendCallBack mqttSendCallBack;

    @Autowired
    private MqttProperties mqttProperties;

    MqttClient client = null;

    @Bean
    public MqttClient connect() {
        try {
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            client = new MqttClient(mqttProperties.getHostUrl(),uuid , new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setUserName(mqttProperties.getUsername());
            options.setPassword(mqttProperties.getPassword().toCharArray());
            options.setConnectionTimeout(mqttProperties.getTimeout());
            options.setKeepAliveInterval(mqttProperties.getKeepAlive());
            options.setCleanSession(mqttProperties.getCleanSession());
            options.setAutomaticReconnect(mqttProperties.getReconnect());
            try {
                // 设置回调
                client.setCallback(mqttSendCallBack);
                client.connect(options);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }

    /**
     * 发布消息
     * 主题格式： server:report:$orgCode(参数实际使用机构代码)
     *
     * @param retained    是否保留
     * @param pushMessage 消息体
     */
    public void publish(boolean retained, String topic, String pushMessage) {
        MqttMessage message = new MqttMessage();
        message.setQos(mqttProperties.getQos());
        message.setRetained(retained);
        message.setPayload(pushMessage.getBytes());
        try {
            client.publish(topic, message);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接
     *
     * @param mqttClient
     */
    public static void disconnect(MqttClient mqttClient) {
        try {
            if (mqttClient != null) {
                mqttClient.disconnect();
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     *
     * @param mqttClient
     */
    public static void close(MqttClient mqttClient) {
        try {
            if (mqttClient != null) {
                mqttClient.close();
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
