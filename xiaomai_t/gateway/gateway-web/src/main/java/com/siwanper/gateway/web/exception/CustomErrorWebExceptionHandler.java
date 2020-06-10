package com.siwanper.gateway.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * 自定义 WebFlux 全局异常处理类
 */
@Slf4j
public class CustomErrorWebExceptionHandler extends DefaultErrorWebExceptionHandler {

    @Autowired
    private GatewayExceptionHandlerAdvice gatewayExceptionHandlerAdvice;

    public CustomErrorWebExceptionHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties, ErrorProperties errorProperties, ApplicationContext applicationContext) {
        super(errorAttributes, resourceProperties, errorProperties, applicationContext);
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }

    @Override
    protected Mono<ServerResponse> renderErrorResponse(ServerRequest request) {
        Map<String, Object> error = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus errorStatus = getHttpStatus(error);
        Throwable throwable = getError(request);
        return ServerResponse.status(errorStatus)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(gatewayExceptionHandlerAdvice.handle(throwable)));
        //.doOnNext((resp) -> logError(request, errorStatus));
    }


}
