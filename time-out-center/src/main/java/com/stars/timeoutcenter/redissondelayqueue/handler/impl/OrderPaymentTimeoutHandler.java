package com.stars.timeoutcenter.redissondelayqueue.handler.impl;

import com.stars.timeoutcenter.redissondelayqueue.RedisDelayQueueEnum;
import com.stars.timeoutcenter.redissondelayqueue.handler.RedisDelayQueueHandler;
import com.stars.timeoutcenter.redissondelayqueue.util.RedisDelayQueueUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 订单支付超时处理类
 */
@Component
@Slf4j
public class OrderPaymentTimeoutHandler implements RedisDelayQueueHandler<Map> {


    @Autowired
    private RedisDelayQueueUtil redisDelayQueueUtil;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * @param map
     */
    @Override
    public void execute(Map map) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            log.info("休眠异常");
        }
        try {

            atomicInteger.incrementAndGet();
            //throw new Exception("rer");
        } catch (Exception e) {
            Integer retry = Integer.valueOf((String) map.getOrDefault("retry", "0")) ;
            if (retry > 0) {
                atomicInteger.decrementAndGet();
                log.info("消费异常，重试，{}", map);
                map.put("retry", String.valueOf(--retry));
                redisDelayQueueUtil.addDelayQueue(map, 5, TimeUnit.SECONDS, RedisDelayQueueEnum.ORDER_PAYMENT_TIMEOUT.getCode());
            } else {
                log.info("消费异常，{}", map);
            }

        } finally {
            log.info("消费总数：{}", atomicInteger.get());
        }
        log.info("(收到订单支付超时延迟消息) {}", map);
    }
}
