package com.lay.alibaba.controller;

import com.lay.alibaba.service.SaleOrderService;
import com.lay.springcloud.entity.SaleOrder;
import com.lay.springcloud.util.WebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class SaleOrderController {

    @Autowired
    private SaleOrderService saleOrderService;

    @PostMapping(value = "/create")
    public WebResponse<String> create(@RequestBody SaleOrder order) {
        saleOrderService.createOrder(order);
        return new WebResponse<String>(200, "创建订单成功", "");
    }
}
