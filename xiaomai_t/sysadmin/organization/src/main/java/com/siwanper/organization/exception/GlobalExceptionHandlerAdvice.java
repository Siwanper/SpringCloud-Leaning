package com.siwanper.organization.exception;

import com.siwanper.core.entity.vo.Result;
import com.siwanper.web.exception.DefaultGlobalExceptionHandlerAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 描述:
 * 统一异常处理
 *
 * @outhor ios
 * @create 2020-04-10 9:53 AM
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandlerAdvice extends DefaultGlobalExceptionHandlerAdvice {

    @ExceptionHandler(value = {UserNotFoundException.class})
    public Result userNotFound(UserNotFoundException ex) {
        log.error(ex.getMessage());
        return Result.fail(ex);
    }

}
