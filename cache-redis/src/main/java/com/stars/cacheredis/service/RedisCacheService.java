package com.stars.cacheredis.service;

import java.util.Map;

public interface RedisCacheService {
    Map<String, String> getData();

    Map<String, String> invalid();

    Map<String, String> doubleWrite();
}
