package com.lay.springcloud.param;

import lombok.Data;

import java.io.Serializable;

@Data
public class StorageParam implements Serializable {

    private Long productId;

    private Integer count;
}
