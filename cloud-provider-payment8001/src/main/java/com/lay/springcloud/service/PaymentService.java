package com.lay.springcloud.service;

import com.lay.springcloud.entity.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment getById(Long id);

    /**
     * hystrix正常响应测试
     * @return
     */
    String hystrixOkTest();

    /**
     * hystrix超时响应test
     * @return
     */
    String hystrixTimeOutTest();
}
