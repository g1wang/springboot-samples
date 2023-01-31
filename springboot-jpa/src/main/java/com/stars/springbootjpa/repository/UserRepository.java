package com.stars.springbootjpa.repository;

import com.stars.springbootjpa.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findUserByName(String name);

    UserEntity findUserByNameAndAge(String name, Integer age);
}
