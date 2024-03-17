package com.lay.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/getServerPort")
    public String getServerPort() {
        try{
            InetAddress localhost = InetAddress.getLocalHost();
            String ip = localhost.getHostAddress();
            return "nacos registry :" + ip + ":" + serverPort;
        }catch (UnknownHostException r) {
            r.printStackTrace();
        }
        return "";
    }
}
