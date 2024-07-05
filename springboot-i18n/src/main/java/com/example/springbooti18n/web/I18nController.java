package com.example.springbooti18n.web;

import com.example.springbooti18n.configration.I18nUtil;
import com.example.springbooti18n.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("i18n")
public class I18nController {

    private final HttpServletRequest request;
    @PostMapping("add")
    public String add(@RequestBody @Validated UserDto userDto) {
        return I18nUtil.getMessage("A00001",request.getHeader("lang"));
    }

    @GetMapping("get")
    public String get() {
        String s = I18nUtil.getMessage("A00002",request.getHeader("lang"));
        return s;
    }
}
