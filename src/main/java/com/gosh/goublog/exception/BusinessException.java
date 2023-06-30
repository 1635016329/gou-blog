package com.gosh.goublog.exception;

import com.gosh.goublog.common.ErrorCode;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/22 10:15
 * @description 自定义异常类
 */
public class BusinessException extends RuntimeException {

    /**
     * 错误码
     */
    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    public int getCode() {
        return code;
    }
}