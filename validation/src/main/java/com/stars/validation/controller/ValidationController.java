package com.stars.validation.controller;

import com.stars.validation.dto.UserDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("validation")
public class ValidationController {

    @PostMapping("add")
    public String add(@RequestBody @Validated UserDto userDto) {
        return "OK";
    }
}
