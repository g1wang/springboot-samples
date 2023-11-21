package com.stars.cacheredis.service.impl;

import com.stars.cacheredis.service.RedisCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author wanggl
 * @Date 2023/11/21 14:48
 */
@Slf4j
@Service
public class RedisCacheServiceImpl implements RedisCacheService {
    @Cacheable(value = {"category"},key = "'like_fruit'",sync = true)
    @Override
    public Map<String, String> getData() {
        log.info("未命中缓存。。。。。getData。。。");
        // 模拟业务操作
        Map<String, String> data = new HashMap<>();
        data.put("key1","苹果");
        data.put("key2","香蕉");
        data.put("key3","桔子");
        data.put("key4","西瓜");
        return data;
    }

    @CacheEvict(value = "category",allEntries = true)
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
    @CachePut(value = "category",key ="'like_fruit'" )
    @Override
    public Map<String, String> doubleWrite() {
        log.info("双写模式。。。。。doubleWrite。。。");
        Map<String, String> data = new HashMap<>();
        data.put("key1","荔枝");
        data.put("key2","葡萄");
        data.put("key3","柚子");
        data.put("key4","榴莲");
        return data;

    }
}
