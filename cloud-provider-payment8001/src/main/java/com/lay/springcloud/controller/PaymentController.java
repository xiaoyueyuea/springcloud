package com.lay.springcloud.controller;

import com.lay.springcloud.entity.Payment;
import com.lay.springcloud.service.PaymentService;
import com.lay.springcloud.util.WebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/create")
    public WebResponse<Integer> create(@RequestBody Payment payment) {
        Integer count = paymentService.create(payment);
        return new WebResponse<>(200, "成功", count);
    }

    @GetMapping(value = "/getById_{id}")
    public WebResponse<Payment> getById(@PathVariable("id") Long id) {
        return new WebResponse<>(200, "成功", paymentService.getById(id));
    }
}
