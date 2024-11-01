package com.stars.timeoutcenter.redissondelayqueue.handler;

/**
 * @Description: 延迟队列执行器
 * @Author wanggl
 * @Date 2024/10/29 16:24
 */
public interface RedisDelayQueueHandler<T> {
    void execute(T t);
}
