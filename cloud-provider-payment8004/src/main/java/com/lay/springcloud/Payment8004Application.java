package com.lay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //用于使用consul或zookeeper作为注册中心时注册服务
public class Payment8004Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8004Application.class, args);
    }
}
