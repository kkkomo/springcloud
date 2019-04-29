package com.example.ribbon.consumer.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyApi {

    @Autowired
    private RestTemplate restTemplate;

    /*@LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }*/

    @HystrixCommand(fallbackMethod = "defaultStores")//声明断路点
    @GetMapping(value = "/hello")
    public String hello() {
        return restTemplate.getForEntity("http://eureka-provider/", String.class).getBody();
    }

    public String defaultStores() {
        return "Ribbon + hystrix , 提供者服务挂了";
    }
}
