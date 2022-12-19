package com.lay.alibaba.impl;

import com.lay.alibaba.mapper.UserAccountMapper;
import com.lay.alibaba.service.AccountService;
import com.lay.springcloud.param.AccountParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Override
    public void decrease(AccountParam param) {
        //模拟超时异常，全局事务回滚
//        try {
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        userAccountMapper.decrease(param.getUserId(), param.getMoney());
    }
}
