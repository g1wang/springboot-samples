package com.stars.timeoutcenter.redissondelayqueue.web;

import com.stars.timeoutcenter.redissondelayqueue.RedisDelayQueueEnum;
import com.stars.timeoutcenter.redissondelayqueue.util.RedisDelayQueueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/10/29 18:41
 */
@RestController
@RequestMapping("redisson")
public class RedisDelayQueueController {
    @Autowired
    private RedisDelayQueueUtil redisDelayQueueUtil;

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    @GetMapping("/addQueue")
    public void addQueue(Integer total,Integer delay) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("orderId", UUID.randomUUID().toString());
        map1.put("remark", "订单支付超时，自动取消订单");
        map1.put("retry","3");
        // 添加订单支付超时，自动取消订单延迟队列。为了测试效果，延迟10秒钟
        for (int i = 0; i < total; i++) {
            executorService.submit(() -> {
                redisDelayQueueUtil.addDelayQueue(map1, delay, TimeUnit.SECONDS, RedisDelayQueueEnum.ORDER_PAYMENT_TIMEOUT.getCode());
            });

        }

        // 订单超时未评价，系统默认好评。为了测试效果，延迟20秒钟
        //redisDelayQueueUtil.addDelayQueue(map2, 20, TimeUnit.SECONDS, RedisDelayQueueEnum.ORDER_TIMEOUT_NOT_EVALUATED.getCode());
    }
}
