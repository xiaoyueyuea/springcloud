package com.lay.alibaba.controller;

import com.lay.alibaba.service.StorageService;
import com.lay.springcloud.param.StorageParam;
import com.lay.springcloud.util.WebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping(value = "/decrease")
    public WebResponse<String> decrease(@RequestBody StorageParam param) {
        storageService.decrease(param);
        return new WebResponse<>(200, "减库存成功", "");
    }
}
