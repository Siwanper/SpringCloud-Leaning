package com.siwanper.core.exception;


import lombok.Getter;

@Getter
public enum SystemErrorType implements ErrorType {
    SYSTEM_ERROR("-1", "系统异常"),
    SYSTEM_BUSY("000001", "服务器繁忙请稍后重试"),

    ;

    private String code;
    private String mesg;

    SystemErrorType(String code, String mesg) {
        this.code = code;
        this.mesg = mesg;
    }
}
