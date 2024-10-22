package com.example.cachedoubleclear.web;

import com.example.cachedoubleclear.api.ClearAndReloadCache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/10/22 16:30
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping
    @ClearAndReloadCache(name = "nam")
    public void get(String name) {
        return;
    }

}
