package com.example.feignconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by liuyalan on 2019/4/29.
 */

/**
 * 指定这个歌接口所要调用的  提供者服务的名称
 */
@FeignClient(value = "eureka-provider", fallbackFactory = HystrixClientFallbackFactory.class)
public interface HomeClient {

    @GetMapping("/")
    String consumer();
}
