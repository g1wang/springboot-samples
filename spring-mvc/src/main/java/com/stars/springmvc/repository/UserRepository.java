package com.stars.springmvc.repository;

import com.stars.springmvc.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
* @Author laboratory
* @Description User类的CRUD操作
* @Date 2023/1/9
* @Param
* @return
**/
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
