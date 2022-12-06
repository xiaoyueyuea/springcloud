package com.lay.springcloud.feign;

import com.lay.springcloud.entity.Payment;
import com.lay.springcloud.util.WebResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
// openfeign集成了Ribbon自带负载均衡
public interface PaymentFeignService {

    @GetMapping(value = "/payment/getById_{id}")
    WebResponse<Payment> getById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/hystrixOkTest")
    String hystrixOkTest();

    @GetMapping(value = "/payment/hystrixTimeOutTest")
    String hystrixTimeOutTest();
}
