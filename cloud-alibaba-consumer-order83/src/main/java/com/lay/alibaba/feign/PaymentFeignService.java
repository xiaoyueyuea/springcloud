package com.lay.alibaba.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "nacos-payment-provider")
// openfeign集成了Ribbon自带负载均衡
public interface PaymentFeignService {

    @GetMapping(value = "/payment/getServerPort")
    public String getServerPort();

}
