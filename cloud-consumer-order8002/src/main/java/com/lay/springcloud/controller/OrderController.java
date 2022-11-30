package com.lay.springcloud.controller;

import com.lay.springcloud.entity.Payment;
import com.lay.springcloud.util.WebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private static final String PAYMENT_URL = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/create")
    public WebResponse<Integer> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, WebResponse.class);
    }

    @GetMapping("/getById_{id}")
    public WebResponse<Payment> getById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getById_" + id, WebResponse.class);
    }
}
