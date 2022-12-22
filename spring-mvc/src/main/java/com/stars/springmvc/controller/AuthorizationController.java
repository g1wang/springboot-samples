package com.stars.springmvc.controller;

import com.stars.springmvc.authorization.annotation.Authorization;
import com.stars.springmvc.model.ResultModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/12/21 13:50
 */

@RestController
@RequestMapping("/author")
public class AuthorizationController {

    @GetMapping
    @Authorization
    public ResponseEntity<ResultModel> hello(String name){
        String result = "hello world,"+name;
        return new ResponseEntity<>(ResultModel.ok(result), HttpStatus.OK);
    }
}
