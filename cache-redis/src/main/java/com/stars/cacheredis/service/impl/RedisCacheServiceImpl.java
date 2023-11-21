package com.stars.cacheredis.service.impl;

import com.stars.cacheredis.service.RedisCacheService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author wanggl
 * @Date 2023/11/21 14:48
 */
@Slf4j
@Service
public class RedisCacheServiceImpl implements RedisCacheService {

    @Resource
    RedissonClient redissonClient;

    @Cacheable(value = {"category"}, key = "'like_fruit'", sync = true)
    @Override
    public Map<String, String> getData(String key) {
        log.info("未命中缓存。。。。。getData。。。");
        RLock rLock = redissonClient.getLock("banana");
        rLock.lock();
        if (rLock.isLocked()) {
            // 加锁，自动续期,手动解锁
            // rLock.lock();

            // 加锁,10 秒钟自动解锁, 无需调用 unlock 方法手动解锁
            rLock.lock(5, TimeUnit.SECONDS);
            try {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                Map<String, String> data = new HashMap<>();
                data.put("key1", "苹果");
                data.put("key2", "香蕉");
                data.put("key3", "桔子");
                data.put("key4", "西瓜");
                return data;
            } finally {
                if (rLock.isLocked()) {
                    rLock.unlock();
                }

            }

        }
        return null;

    }

    @CacheEvict(value = "category", allEntries = true)
    @Override
    public Map<String, String> invalid() {
        log.info("失效模式。。。。。invalid。。。");
        Map<String, String> map = new HashMap<>();
        map.put("delete", "all_fruit");
        return map;
    }

    /**
     * 双写模式
     *
     * @return
     */
    @CachePut(value = "category", key = "'like_fruit'")
    @Override
    public Map<String, String> doubleWrite() {


        log.info("双写模式。。。。。doubleWrite。。。");
        Map<String, String> data = new HashMap<>();
        data.put("key1", "荔枝");
        data.put("key2", "葡萄");
        data.put("key3", "柚子");
        data.put("key4", "榴莲");
        return data;

    }
}
