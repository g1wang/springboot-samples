package com.stars.springbootjpa.service.impl;

import com.stars.springbootjpa.model.UserEntity;
import com.stars.springbootjpa.repository.UserRepository;
import com.stars.springbootjpa.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: TODO
 * @Author laboratory
 * @Date 2023/1/31 15:54
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Override
    public void save(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public UserEntity findUserByNameAndAge(String name, Integer age) {
        return userRepository.findUserByNameAndAge(name, age);
    }

    @Override
    public Page<UserEntity> findALL(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<UserEntity> findUserByName(String name, Pageable pageable) {
        return userRepository.findUserByName(name,pageable);
    }

    @Override
    public int modifyByUserId(String name, Integer id) {
        return userRepository.modifyByUserId(name,id);
    }
}
