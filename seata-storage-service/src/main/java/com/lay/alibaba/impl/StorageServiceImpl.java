package com.lay.alibaba.impl;

import com.lay.alibaba.mapper.ProductStorageMapper;
import com.lay.alibaba.service.StorageService;
import com.lay.springcloud.param.StorageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private ProductStorageMapper productStorageMapper;

    @Override
    public void decrease(StorageParam param) {
        productStorageMapper.decrease(param.getProductId(), param.getCount());
    }
}
