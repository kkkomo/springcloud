package com.example.feignconsumer.api;

import com.example.feignconsumer.client.HomeClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by liuyalan on 2019/4/29.
 */
@RestController
public class MyApi {

    @Resource
    private HomeClient homeClient;

    @GetMapping(value = "/hello")
    public String hello() {
        return homeClient.consumer();
    }
}
