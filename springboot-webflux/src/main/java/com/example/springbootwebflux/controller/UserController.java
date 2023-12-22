package com.example.springbootwebflux.controller;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping
    public Mono<String> hello(ServerHttpRequest request) {
        return Mono.just("mono " + request.getURI());
    }
}
