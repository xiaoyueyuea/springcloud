package com.lay.springcloud.controller;

import com.lay.springcloud.entity.Payment;
import com.lay.springcloud.feign.PaymentFeignService;
import com.lay.springcloud.util.WebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/getById_{id}")
    public WebResponse<Payment> getById(@PathVariable("id") Long id) {
        return paymentFeignService.getById(id);
    }
}
