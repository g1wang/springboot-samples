package com.example.springbootmqttclient.bean;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/4/11 17:13
 */
@Component
@Slf4j
public class MqttSendCallBack implements MqttCallbackExtended {
    @Override
    public void connectComplete(boolean reconnect, String serverURI) {
        log.info("--------------------客户端连接成功！--------------------");

    }

    @Override
    public void connectionLost(Throwable cause) {
        log.info("发送消息回调: 连接断开，可以做重连");
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        log.info("发送消息回调:  接收消息主题 : " + topic);
        log.info("发送消息回调:  接收消息内容 : " + new String(message.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {

    }
}
