package com.stars.springbootjpa.repository;

import com.stars.springbootjpa.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findUserByName(String name);

    UserEntity findUserByNameAndAge(String name, Integer age);

    Page<UserEntity> findUserByName(String name ,Pageable pageable);

    @Modifying
    @Transactional
    @Query("update UserEntity u set u.name = ?1 where u.userId = ?2")
    int modifyByUserId(String name, Integer userId);
}
