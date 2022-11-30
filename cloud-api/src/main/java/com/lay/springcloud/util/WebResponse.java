package com.lay.springcloud.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class WebResponse<T> implements Serializable {

    private Integer code;

    private String message;

    private T Data;

    public WebResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        Data = data;
    }
}
