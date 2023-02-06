package com.stars.springbootjpa.service;

import com.stars.springbootjpa.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    void save(UserEntity user);

    List<UserEntity> findAll();

    UserEntity findUserByName(String name);
    UserEntity findUserByNameAndAge(String name,Integer age);

    Page<UserEntity> findALL(Pageable pageable);
    Page<UserEntity> findUserByName(String name,Pageable pageable);

    int modifyByUserId(String  name, Integer userId);

}
