package com.stars.springbootjpa;

import com.stars.springbootjpa.model.UserEntity;
import com.stars.springbootjpa.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
import java.util.List;

//@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootJpaApplicationTests {

    @Resource
    UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void save(){
        UserEntity user = new UserEntity();
        user.setAge(10);
        user.setName("aab");
        user.setSex("1");
        userService.save(user);
    }

    @Test
    void findAll(){
        List<UserEntity> userEntityList = userService.findAll();
        System.out.println(userEntityList.get(1).getUserId());
    }

    @Test
    void findUserByName(){
        UserEntity user = userService.findUserByName("aab");
        System.out.println(user.getName());
    }

    @Test
    void findUserByNameAndAge(){
        UserEntity user = userService.findUserByNameAndAge("aab",11);
        if (user== null) System.out.println("user no found");
        else System.out.println(user.getName());
    }

    @Test
    void findAllPageAble(){
        int page = 0,size = 2;
        Pageable pageable = PageRequest.of(page, size, Sort.by("userId").descending());
        Page<UserEntity> userEntityPage = userService.findALL(pageable);
        userEntityPage.get();
    }

    @Test
    void findUserByNamePageable(){
        int page = 0,size = 1;
        Pageable pageable = PageRequest.of(page, size, Sort.by("userId").descending());
        Page<UserEntity> userEntityPage = userService.findUserByName("aab",pageable);
        userEntityPage.get();
    }

    @Test
    void modifyByIdAndUserId(){
        userService.modifyByUserId("aabb",4);
    }

}
