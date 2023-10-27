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
    @Cacheable(value="userCache", key="#username")
    public UserDto getUser(String username) {
        log.info("do do query {}",username);
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        return userDto;
    }
}
