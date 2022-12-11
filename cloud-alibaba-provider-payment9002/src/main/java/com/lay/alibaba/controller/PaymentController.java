package com.lay.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/getServerPort")
    public String getServerPort() {
        return "nacos registry serverPort :" + serverPort;
    }
}
