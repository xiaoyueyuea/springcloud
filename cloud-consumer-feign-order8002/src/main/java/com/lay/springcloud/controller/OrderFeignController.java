package com.lay.springcloud.controller;

import com.lay.springcloud.entity.Payment;
import com.lay.springcloud.feign.PaymentFeignService;
import com.lay.springcloud.util.WebResponse;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
@Slf4j
@DefaultProperties(defaultFallback = "fallBack") //默认降级方法，需要注解@HystrixCommand，但这种耦合度太高
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/getById_{id}")
    public WebResponse<Payment> getById(@PathVariable("id") Long id) {
        return paymentFeignService.getById(id);
    }

    @GetMapping("/hystrixOkTest")
    @HystrixCommand
    public String hystrixOkTest(){
        return paymentFeignService.hystrixOkTest();
    }

    @GetMapping("/hystrixTimeOutTest")
    @HystrixCommand(fallbackMethod = "fallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "400")
    })
    public String hystrixTimeOutTest() {
        return paymentFeignService.hystrixTimeOutTest();
    }

    //作为兜底的方案
    private String fallBack() {
        return "调用异常，通过hystrix实现服务降级";
    }
}
