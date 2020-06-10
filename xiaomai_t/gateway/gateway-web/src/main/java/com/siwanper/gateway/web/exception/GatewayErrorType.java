package com.siwanper.gateway.web.exception;

import com.siwanper.core.exception.ErrorType;
import lombok.Getter;

@Getter
public enum GatewayErrorType implements ErrorType {

    GATEWAY_ERROR("040500", "网关异常"),
    GATEWAY_NOT_FOUND("040404", "服务未找到"),
    GATEWAY_CONNECT_TIME_OUT("040002","网关连接超时")

    ;

    private String code;
    private String mesg;

    GatewayErrorType(String code, String mesg) {
        this.code = code;
        this.mesg = mesg;
    }

}
