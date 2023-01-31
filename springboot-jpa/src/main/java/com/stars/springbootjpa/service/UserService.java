package com.stars.springbootjpa.service;

import com.stars.springbootjpa.model.UserEntity;

import java.util.List;

public interface UserService {

    void save(UserEntity user);

    List<UserEntity> findAll();

    UserEntity findUserByName(String name);
    UserEntity findUserByNameAndAge(String name,Integer age);
}
