package com.lay.alibaba.controller;

import com.lay.alibaba.feign.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class NacosOrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/getServerPort")
    public String getServerPort() {
        return paymentFeignService.getServerPort();
    }
}
