package com.swp.cloud.common.core.exception;

import lombok.Getter;

@Getter
public enum SystemErrorType implements ErrorType {

    SYSTEM_ERROR("-1", "系统错误"),

    ARGUMENT_NOT_VALID("020001","请求参数缺失"),
    UPLOAD_FILE_SIZE_LIMIT("020001", "上传文件大小超过限制"),

    DUPLICATE_PRIMARY_KEY("030000","唯一键冲突");
    ;
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误描述
     */
    private String message;

    SystemErrorType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
