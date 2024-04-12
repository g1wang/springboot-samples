package com.example.springbootmqttclient.bean;

import com.example.springbootmqttclient.config.MqttProperties;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.example.springbootmqttclient.bean.MyMqttClient.mqttclient;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/4/11 17:13
 */
@Component
@Slf4j
public class MqttCallBack implements MqttCallbackExtended {

    @Resource
    MqttProperties mqttProperties;
    @Override
    public void connectComplete(boolean reconnect, String serverURI) {
        log.info("--------------------客户端连接成功！--------------------");
        try {
            mqttclient.subscribe(mqttProperties.getTopic(), mqttProperties.getQos());
            log.info("MQTT订阅成功！");
        } catch (Exception e) {
            log.info("MQTT订阅失败！");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void connectionLost(Throwable cause) {
        log.info("连接断开，可以做重连");
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        log.info("发送消息回调:  接收消息主题 : " + topic);
        log.info("发送消息回调:  接收消息内容 : " + new String(message.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {

    }
}
