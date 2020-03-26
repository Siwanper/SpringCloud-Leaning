package com.siwanper.core.exception;

import lombok.Getter;

/**
 * 描述:
 * 异常基类
 *
 * @outhor ios
 * @create 2020-03-26 10:38 AM
 */
@Getter
public class BaseException extends RuntimeException {

    /**
     * 异常对应的错误类型
     */
    private final ErrorType errorType;

    /**
     * 默认为系统异常
     */
    public BaseException(){
        this.errorType = SystemErrorType.SYSTEM_ERROR;
    }

    public BaseException(ErrorType errorType){
        this.errorType = errorType;
    }

    public BaseException(ErrorType errorType, String mesg){
        super(mesg);
        this.errorType = errorType;
    }

    public BaseException(ErrorType errorType, String mesg, Throwable cause){
        super(mesg, cause);
        this.errorType = errorType;
    }

}
