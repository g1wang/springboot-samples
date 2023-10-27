package com.example.cache.service;

import com.example.cache.dto.UserDto;

public interface UserService {
    UserDto getUser(String username);
    UserDto getUser2(String username);
    UserDto getUser3(String username);
}
