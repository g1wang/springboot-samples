package com.stars.timeoutcenter.redissondelayqueue;

import com.stars.timeoutcenter.redissondelayqueue.handler.RedisDelayQueueHandler;
import com.stars.timeoutcenter.redissondelayqueue.util.RedisDelayQueueUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 消费者
 * @Author wanggl
 * @Date 2024/10/29 18:37
 */
@Slf4j
@Component
public class RedisDelayQueueRunner implements CommandLineRunner {

    /**
     * @param args
     * @throws Exception
     */

    @Autowired
    private RedisDelayQueueUtil redisDelayQueueUtil;
    @Autowired
    private ApplicationContext context;
    @Autowired
    private ThreadPoolTaskExecutor ptask;



    ThreadPoolExecutor executorService = new ThreadPoolExecutor(8, 32, 30, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(1000));

    @Override
    public void run(String... args) throws Exception {
        ptask.execute(() -> {
            while (true) {
                try {
                    RedisDelayQueueEnum[] queueEnums = RedisDelayQueueEnum.values();
                    for (RedisDelayQueueEnum queueEnum : queueEnums) {
                        Object value = redisDelayQueueUtil.getDelayQueue(queueEnum.getCode());
                        if (value != null) {
                            RedisDelayQueueHandler<Object> redisDelayQueueHandler = (RedisDelayQueueHandler<Object>) context.getBean(queueEnum.getBeanId());
                            executorService.execute(() -> {
                                redisDelayQueueHandler.execute(value);

                            });
                        } else {
                            TimeUnit.MILLISECONDS.sleep(200);
                        }
                    }

                } catch (InterruptedException e) {
                    log.error("(Redission延迟队列监测异常中断) {}", e.getMessage());
                }
            }
        });
        log.info("(Redission延迟队列监测启动成功)");


    }
}
