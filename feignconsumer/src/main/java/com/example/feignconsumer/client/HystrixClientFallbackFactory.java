package com.example.feignconsumer.client;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Created by liuyalan on 2019/4/29.
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<HomeClient> {

    @Override
    public HomeClient create(Throwable throwable) {
        return () -> "feign + hystrix , 提供者服务挂了";
    }

}
