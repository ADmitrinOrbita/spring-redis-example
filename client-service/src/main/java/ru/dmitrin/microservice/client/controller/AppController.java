package ru.dmitrin.microservice.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping
    public String getRootResponse() {
        return "Client service: Hello world!";
    }
}
