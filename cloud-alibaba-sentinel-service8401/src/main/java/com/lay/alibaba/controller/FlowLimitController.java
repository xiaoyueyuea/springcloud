package com.lay.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lay.alibaba.handler.MyBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sentinel")
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "testA ------";
    }

    @GetMapping("/testB")
    public String testB() {
        return "testB ------";
    }

    @GetMapping("/testHotKey")
//    @SentinelResource(value = "testHotKey", blockHandler = "dealHotKey")
    //blockHandler处理配置不符的情况， fallback处理运行异常
    @SentinelResource(value = "testHotKey", blockHandlerClass = MyBlockHandler.class, blockHandler = "handleException", fallback = "")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1, @RequestParam(value = "p2", required = false) String p2) {
        return "testHotKey------";
    }

//    public String dealHotKey(String p1, String p2, BlockException exception) {
//        return "dealHotKey-----";
//    }
}
