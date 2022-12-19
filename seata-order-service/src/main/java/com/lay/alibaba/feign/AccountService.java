package com.lay.alibaba.feign;

import com.lay.springcloud.param.AccountParam;
import com.lay.springcloud.util.WebResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping(value = "/account/decrease")
    WebResponse decrease(@RequestBody AccountParam param);
}
