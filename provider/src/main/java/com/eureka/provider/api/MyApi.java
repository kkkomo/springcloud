package com.eureka.provider.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyApi {

    @Value("${server.port}")
    String port;

    @GetMapping
    public String sayHello() {
        return "Hello world, port : " + port;
    }
}
