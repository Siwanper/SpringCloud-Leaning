package com.swp.cloud.common.core.exception;

import lombok.Getter;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-02 12:09 PM
 */
@Getter
public class BaseException extends RuntimeException {


    private final ErrorType errorType;

    /**
     * 默认为系统错误
     */
    BaseException() {
        this.errorType = SystemErrorType.SYSTEM_ERROR;
    }

    BaseException(ErrorType errorType) {
        this.errorType = errorType;
    }

    BaseException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    BaseException(ErrorType errorType, String message, Throwable cause) {
        super(message, cause);
        this.errorType = errorType;
    }

}
