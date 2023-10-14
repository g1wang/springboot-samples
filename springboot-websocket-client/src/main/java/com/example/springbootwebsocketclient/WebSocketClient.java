package com.example.springbootwebsocketclient;

import okhttp3.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2023/10/13 20:03
 */
public class WebSocketClient extends WebSocketListener {
    private String result = null;

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);
        webSocket.send("需要发送的请求数据");
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        super.onMessage(webSocket, text);
        //其中text是接收到的参数
        System.out.println("接口响应的结果text=" + text);
        result = text;
    }

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient.Builder()
                //设置超时时间是5秒
                .connectTimeout(5, TimeUnit.MINUTES)
                .build();
        //http的请求对应的就是websocket中的ws;https的请求对应的就是websocket中的wss
        String url = "ws://localhost:8080/websocket/name2";
        //实例化Request对象
        Request request = new Request.Builder().url(url).build();
        WebSocketClient webSocketClient = new WebSocketClient();
        client.newWebSocket(request, webSocketClient);
    }

}


