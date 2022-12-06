package com.lay.springcloud.impl;

import com.lay.springcloud.entity.Payment;
import com.lay.springcloud.mapper.PaymentMapper;
import com.lay.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentMapper.getById(id);
    }

    @Override
    public String hystrixOkTest() {
        return "hystrix正常响应测试：" + Thread.currentThread().getName();
    }

    @HystrixCommand(fallbackMethod = "fallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "400"), //超时时间
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //失败率达到多少后跳闸（熔断）
    })
    @Override
    public String hystrixTimeOutTest() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hystrix超时响应测试：" + Thread.currentThread().getName();
    }

    //作为兜底的方案
    private String fallBack() {
        return "调用异常，通过hystrix实现服务降级";
    }
}
