package com.stars.springbootadminserver.dingding;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Slf4j
public class DingDingMessageUtil {
    private static String webhookUrl = "https://oapi.dingtalk.com/robot/send?access_token=63e77e02587e180bdf606b7520845b96de292f3287b5ffa0c66edfb260b11459";
    private static String secret = "SEC57baa1407aa34eba5da2088140fca4ffe1bf1084f55dc67f4acf6659f18feb5c";

    public static void sendTextMessage(String msg) {
        try {
            Message message = new Message();
            message.setMsgtype("text");
            message.setText(new MessageInfo(msg));
            URL url = new URL(buildUrl());
            // 建立 http 连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("Content-Type", "application/Json; charset=UTF-8");
            conn.connect();
            OutputStream out = conn.getOutputStream();
            String textMessage = JSONObject.toJSONString(message);
            byte[] data = textMessage.getBytes();
            out.write(data);
            out.flush();
            out.close();
            InputStream in = conn.getInputStream();
            byte[] data1 = new byte[in.available()];
            in.read(data1);
            log.info("{}", new String(data1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String buildUrl() {
        Long timestamp = System.currentTimeMillis();
        return String.format("%s&timestamp=%s&sign=%s", webhookUrl, timestamp, getSign(timestamp));
    }

    private static String getSign(Long timestamp) {
        try {
            String stringToSign = timestamp + "\n" + secret;
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
            return URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
}

