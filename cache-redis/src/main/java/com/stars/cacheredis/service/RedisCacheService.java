package com.stars.cacheredis.service;

import java.util.Map;

public interface RedisCacheService {
    Map<String, String> getData(String key);

    Map<String, String> invalid();

    Map<String, String> doubleWrite();
}
