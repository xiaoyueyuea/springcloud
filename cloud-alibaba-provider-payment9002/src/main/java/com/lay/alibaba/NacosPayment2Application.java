package com.lay.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosPayment2Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosPayment2Application.class, args);
    }
}
