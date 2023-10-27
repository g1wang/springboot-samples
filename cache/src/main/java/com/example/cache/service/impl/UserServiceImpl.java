package com.example.cache.service.impl;

import com.example.cache.dto.UserDto;
import com.example.cache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Override
    @Cacheable(cacheManager = "test1m",value="userCache", key="#username")
    public UserDto getUser(String username) {
        log.info("do do query1 {}",username);
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        return userDto;
    }

    @Override
    @Cacheable(cacheManager = "test2m",value="userCache", key="#username")
    public UserDto getUser2(String username) {
        log.info("do do query2 {}",username);
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        return userDto;
    }

    @Override
    @Cacheable(cacheManager = "test3m",value="userCache", key="#username")
    public UserDto getUser3(String username) {
        log.info("do do query3 {}",username);
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        return userDto;
    }
}
