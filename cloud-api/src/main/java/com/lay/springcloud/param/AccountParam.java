package com.lay.springcloud.param;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class AccountParam implements Serializable {

    private Long userId;

    private BigDecimal money;
}
