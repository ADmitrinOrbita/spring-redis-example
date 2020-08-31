package ru.dmitrin.microservice.redis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping
    public String getRootResponse() {
        return "Redis service: Hello world!";
    }
}
