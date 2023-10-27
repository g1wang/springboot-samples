package com.example.cache.config;


import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    @Primary
    @Bean(name = "test1m")
    public CacheManager cacheManager(){
        Caffeine caffeine = Caffeine.newBuilder()
                // 存活时间（访问后x秒内没有被访问则被移除）
                .expireAfterAccess(1, TimeUnit.MINUTES)
                // 存活时间（写入后x分钟后会自动移除）
                .expireAfterWrite(3,TimeUnit.MINUTES)
                // 最大size
                .maximumSize(1000)
                // 初始化大小为100个键值对
                .initialCapacity(100)
                // 变成软引用模式（在jvm内存不足时会被回收）
                .softValues();
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(caffeine);
        cacheManager.setAllowNullValues(true);
        return cacheManager;

    }

    @Bean(name = "test2m")
    public CacheManager cacheManager2(){
        Caffeine caffeine = Caffeine.newBuilder()
                // 存活时间（访问后x秒内没有被访问则被移除）
                .expireAfterAccess(1, TimeUnit.MINUTES)
                // 存活时间（写入后x分钟后会自动移除）
                .expireAfterWrite(3,TimeUnit.MINUTES)
                // 最大size
                .maximumSize(1000)
                // 初始化大小为100个键值对
                .initialCapacity(100)
                // 变成软引用模式（在jvm内存不足时会被回收）
                .softValues();
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(caffeine);
        cacheManager.setAllowNullValues(true);
        return cacheManager;

    }
    @Bean(name = "test3m")
    public CacheManager cacheManager3(){
        Caffeine caffeine = Caffeine.newBuilder()
                // 存活时间（访问后x秒内没有被访问则被移除）
                .expireAfterAccess(1, TimeUnit.MINUTES)
                // 存活时间（写入后x分钟后会自动移除）
                .expireAfterWrite(3,TimeUnit.MINUTES)
                // 最大size
                .maximumSize(1000)
                // 初始化大小为100个键值对
                .initialCapacity(100)
                // 变成软引用模式（在jvm内存不足时会被回收）
                .softValues();
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(caffeine);
        cacheManager.setAllowNullValues(true);
        return cacheManager;

    }
}
