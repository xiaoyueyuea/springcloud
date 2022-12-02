package com.lay.springcloud.service;

import com.lay.springcloud.entity.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment getById(Long id);
}
