package com.lay.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced //让RestTemplate在请求时具有负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
