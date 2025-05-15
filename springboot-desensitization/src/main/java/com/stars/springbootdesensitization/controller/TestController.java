package com.stars.springbootdesensitization.controller;

import com.stars.springbootdesensitization.vo.TestPojo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2025/5/15 15:07
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public TestPojo testDesensitization(){
        TestPojo testPojo = new TestPojo();
        testPojo.setUserName("我是用户名");
        testPojo.setAddress("地球中国-北京市通州区京东总部2号楼");
        testPojo.setPhone("13782946666");
        testPojo.setPassword("sunyangwei123123123.");
        System.out.println(testPojo);
        return testPojo;
    }

}
