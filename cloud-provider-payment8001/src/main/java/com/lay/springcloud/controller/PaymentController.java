package com.lay.springcloud.controller;

import com.lay.springcloud.entity.Payment;
import com.lay.springcloud.service.PaymentService;
import com.lay.springcloud.util.WebResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port:8001}")
    private String serverPort;

    @PostMapping(value = "/create")
    public WebResponse<Integer> create(@RequestBody Payment payment) {
        Integer count = paymentService.create(payment);
        return new WebResponse<>(200, "成功", count);
    }

    @GetMapping(value = "/getById_{id}")
    public WebResponse<Payment> getById(@PathVariable("id") Long id) {
        LOGGER.info("根据id查询payment,port:{}", serverPort);
        return new WebResponse<>(200, "成功,port:" + serverPort, paymentService.getById(id));
    }

    @GetMapping(value = "/hystrixOkTest")
    public String hystrixOkTest() {
        return paymentService.hystrixOkTest();
    }

    @GetMapping(value = "/hystrixTimeOutTest")
    public String hystrixTimeOutTest() {
        return paymentService.hystrixTimeOutTest();
    }
}
