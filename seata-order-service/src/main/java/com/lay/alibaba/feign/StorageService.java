package com.lay.alibaba.feign;

import com.lay.springcloud.param.StorageParam;
import com.lay.springcloud.util.WebResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping(value = "/storage/decrease")
    WebResponse decrease(@RequestBody StorageParam param);
}
