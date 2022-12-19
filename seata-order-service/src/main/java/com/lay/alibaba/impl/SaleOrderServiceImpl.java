package com.lay.alibaba.impl;

import com.lay.alibaba.feign.AccountService;
import com.lay.alibaba.feign.StorageService;
import com.lay.springcloud.param.AccountParam;
import com.lay.springcloud.param.StorageParam;
import com.lay.springcloud.entity.SaleOrder;
import com.lay.alibaba.mapper.SaleOrderMapper;
import com.lay.alibaba.service.SaleOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleOrderServiceImpl implements SaleOrderService {

    private final static Logger LOGGER = LoggerFactory.getLogger(SaleOrderServiceImpl.class);

    @Autowired
    private SaleOrderMapper saleOrderMapper;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    //添加seata分布式事务
    @GlobalTransactional(name = "create-order", rollbackFor = Exception.class)
    @Override
    public void createOrder(SaleOrder order) {
        LOGGER.info("---->创建订单");
        saleOrderMapper.createOrder(order);

        LOGGER.info("---->调用库存做扣减");
        StorageParam storage = new StorageParam();
        storage.setProductId(order.getProductId());
        storage.setCount(order.getCount());
        storageService.decrease(storage);

        LOGGER.info("---->调用账户做扣减余额");
        AccountParam param = new AccountParam();
        param.setUserId(order.getUserId());
        param.setMoney(order.getMoney());
        accountService.decrease(param);

        LOGGER.info("---->修改订单状态");
        saleOrderMapper.finishOrder(order.getUserId(), order.getProductId());
    }
}
