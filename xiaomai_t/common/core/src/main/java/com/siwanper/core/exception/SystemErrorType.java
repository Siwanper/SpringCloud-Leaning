package com.siwanper.core.exception;


import lombok.Getter;

@Getter
public enum SystemErrorType implements ErrorType {
    SYSTEM_ERROR("-1", "系统异常"),
    SYSTEM_BUSY("000001", "服务器繁忙请稍后重试"),

    ARGUMENT_NOT_VALID("010001", "请求参数不合法"),
    UPLOAD_FILE_SIZE_LIMIT("010002", "上传的文件超过限制"),
    INVALID_TOKEN("010003","token无效"),
    PRIMARY_KEY_DUPLICATION("020001", "唯一键冲突");

    private String code;
    private String mesg;

    SystemErrorType(String code, String mesg) {
        this.code = code;
        this.mesg = mesg;
    }
}
