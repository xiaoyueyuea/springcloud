package com.lay.springcloud.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Payment implements Serializable {

    private Long id;

    private String serial;
}
