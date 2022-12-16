package com.lay.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class MyBlockHandler {

    public static String handleException(String p1, String p2, BlockException exception) {
        return "sentinel流控异常全局处理, exception:" + exception;
    }
}
