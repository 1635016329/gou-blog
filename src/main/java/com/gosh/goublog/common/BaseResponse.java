package com.gosh.goublog.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/21 23:23
 * @description
 */
@Data
public class BaseResponse<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(int code, T data) {
        this(code, data, "");
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage());
    }
}

