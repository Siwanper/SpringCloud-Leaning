package com.siwanper.gateway.web.exception;

import com.siwanper.core.entity.vo.Result;
import com.siwanper.core.exception.SystemErrorType;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.netty.channel.ConnectTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Component
public class GatewayExceptionHandlerAdvice {

    @ExceptionHandler(value = {ResponseStatusException.class})
    public Result handle(ResponseStatusException exception){
        log.error("response status exception:{}",exception.getMessage());
        return Result.fail(GatewayErrorType.GATEWAY_ERROR);
    }

    @ExceptionHandler(value = {ConnectTimeoutException.class})
    public Result handle(ConnectTimeoutException exception){
        log.error("connect timeout exception:{}", exception.getMessage());
        return Result.fail(GatewayErrorType.GATEWAY_CONNECT_TIME_OUT);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result handle(NotFoundException exception){
        log.error("notfound exception:{}", exception.getMessage());
        return Result.fail(GatewayErrorType.GATEWAY_NOT_FOUND);
    }

    @ExceptionHandler(value = {ExpiredJwtException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result handle(ExpiredJwtException exception){
        log.error("expired jwt exception:{}", exception.getMessage());
        return Result.fail(SystemErrorType.INVALID_TOKEN);
    }

    @ExceptionHandler(value = {SignatureException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result handle(SignatureException exception){
        log.error("SignatureException:{}", exception.getMessage());
        return Result.fail(SystemErrorType.INVALID_TOKEN);
    }

    @ExceptionHandler(value = {MalformedJwtException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result handle(MalformedJwtException exception){
        log.error("MalformedJwtException:{}", exception.getMessage());
        return Result.fail(SystemErrorType.INVALID_TOKEN);
    }

    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handle(RuntimeException exception){
        log.error("RuntimeException:{}", exception.getMessage());
        return Result.fail();
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handle(Exception exception){
        log.error("Exception:{}", exception.getMessage());
        return Result.fail();
    }

    @ExceptionHandler(value = {Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handle(Throwable exception){
        Result result = Result.fail();
        if (exception instanceof ResponseStatusException){
            result = handle((ResponseStatusException) exception);
        } else if (exception instanceof NotFoundException){
            result = handle((NotFoundException) exception);
        } else if (exception instanceof ExpiredJwtException){
            result = handle((ExpiredJwtException) exception);
        } else if (exception instanceof SignatureException){
            result = handle((SignatureException) exception);
        } else if (exception instanceof MalformedJwtException){
            result = handle((MalformedJwtException) exception);
        } else if (exception instanceof RuntimeException){
            result = handle((RuntimeException) exception);
        } else if (exception instanceof Exception){
            result = handle((Exception) exception);
        }
        return result;
    }

}
