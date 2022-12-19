package com.lay.alibaba.controller;

import com.lay.alibaba.service.AccountService;
import com.lay.springcloud.param.AccountParam;
import com.lay.springcloud.util.WebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/decrease")
    public WebResponse<String> decrease(@RequestBody AccountParam param) {
        accountService.decrease(param);
        return new WebResponse<>(200, "扣减余额成功", "");
    }
}
