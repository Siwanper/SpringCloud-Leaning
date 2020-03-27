package com.siwanper.web.exception;

import com.siwanper.core.entity.vo.Result;
import com.siwanper.core.exception.BaseException;
import com.siwanper.core.exception.SystemErrorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

/**
 * 描述: web中 统一异常处理
 *
 * @outhor ios
 * @create 2020-03-27 12:30 PM
 */
@Slf4j
public class DefaultGlobalExceptionHandlerAdvice {

    @ExceptionHandler(value = { MissingServletRequestParameterException.class })
    public Result missingServletRequestParameterException(MissingServletRequestParameterException ex){
        log.error("missing servlet request parameter ex:{}", ex.getMessage());
        return Result.fail(SystemErrorType.ARGUMENT_NOT_VALID);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Result methodArgumentNotValideException(MethodArgumentNotValidException ex) {
        log.error("service error : {}", ex.getMessage());
        return Result.fail(SystemErrorType.ARGUMENT_NOT_VALID, ex.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(value = {MultipartException.class})
    public Result multipartException(MultipartException ex){
        log.error("multipart ex:{}", ex.getMessage());
        return Result.fail(SystemErrorType.UPLOAD_FILE_SIZE_LIMIT);
    }

    @ExceptionHandler(value = {DuplicateKeyException.class})
    public Result duplicationKeyException(DuplicateKeyException ex) {
        log.error("primary key duplication ex:{}",ex.getMessage());
        return Result.fail(SystemErrorType.PRIMARY_KEY_DUPLICATION);
    }

    @ExceptionHandler(value = {BaseException.class})
    public Result baseException(BaseException ex){
        log.error("baseException: {}",ex);
        return Result.fail(ex);
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result exception(){
        return Result.fail();
    }

    @ExceptionHandler(value = {Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result throwable(){
        return Result.fail();
    }

}
