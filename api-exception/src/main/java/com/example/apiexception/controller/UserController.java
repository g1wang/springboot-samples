package com.example.apiexception.controller;

import com.example.apiexception.dto.UserDto;
import com.example.apiexception.exception.response.R;
import com.example.apiexception.exception.ValidationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public R<?> addUser(@Validated @RequestBody UserDto userDto) {
        if (userDto != null) throw new ValidationException("用户已存在");
        return R.success();
    }
}
