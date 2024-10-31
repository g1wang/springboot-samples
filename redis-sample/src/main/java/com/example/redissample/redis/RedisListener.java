package com.example.redissample.redis;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/10/29 10:45
 */

@Component
@Slf4j
public class RedisListener implements ApplicationRunner , Ordered {

    @Autowired
    RedissonClient redissonClient;

    /**
     * Callback used to run the bean.
     *
     * @param args incoming application arguments
     * @throws Exception on error
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        RTopic testListener = redissonClient.getTopic("string-topic");
        // 异步监听
        log.info("-----监听主题topic,并处理其中的数据-----");
        testListener.addListener(String.class, new MessageListener<String>() {
            @Override
            public void onMessage(CharSequence channel, String msg) {
                // 监听到消息
                log.info(msg + ", RedisListener01");
            }
        });
        log.info("....init RedisListener01 addListener.....");
    }

    /**
     * Get the order value of this object.
     * <p>Higher values are interpreted as lower priority. As a consequence,
     * the object with the lowest value has the highest priority (somewhat
     * analogous to Servlet {@code load-on-startup} values).
     * <p>Same order values will result in arbitrary sort positions for the
     * affected objects.
     *
     * @return the order value
     * @see #HIGHEST_PRECEDENCE
     * @see #LOWEST_PRECEDENCE
     */
    @Override
    public int getOrder() {
        return 1;
    }
}
