package com.swp.cloud.common.web.exception;

import com.swp.cloud.common.core.entity.vo.Result;
import com.swp.cloud.common.core.exception.BaseException;
import com.swp.cloud.common.core.exception.SystemErrorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-02 3:40 PM
 */
@Slf4j
public class DefaultGlobalExceptionHandlerAdvice {

    /**
     * 请求参数缺失
     * @param exception
     * @return
     */
    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public Result missingServletRequestParameterException(MissingServletRequestParameterException exception){
        log.error("missing request parameter exception:{}",exception.getMessage());
        return Result.fail(SystemErrorType.ARGUMENT_NOT_VALID);
    }

    /**
     * 上传文件大小超过限制
     * @param exception
     * @return
     */
    @ExceptionHandler(value = {MultipartException.class})
    public Result uploadFileLimitException(MultipartException exception){
        log.error("upload file size limit exception:{}", exception.getMessage());
        return Result.fail(SystemErrorType.UPLOAD_FILE_SIZE_LIMIT);
    }

    /**
     * 请求参数不可用
     * @param exception
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Result methodArgumentNotValidException(MethodArgumentNotValidException exception){
        log.error("method argument not valid exception:{}",exception.getMessage());
        return Result.fail(SystemErrorType.ARGUMENT_NOT_VALID);
    }

    /**
     * 唯一键冲突
     * @param exception
     * @return
     */
    @ExceptionHandler(value = {DuplicateKeyException.class})
    public Result duplicateKeyException(DuplicateKeyException exception) {
        log.error("duplicate primary key exception:{}", exception.getMessage());
        return Result.fail(SystemErrorType.DUPLICATE_PRIMARY_KEY);
    }

    /**
     * 自定义异常处理
     * @param exception
     * @return
     */
    @ExceptionHandler(value = {BaseException.class})
    public Result baseException(BaseException exception) {
        log.error("exception:{}",exception.getMessage());
        return Result.fail(exception.getErrorType());
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result exception(){
        return Result.fail();
    }

    @ExceptionHandler(value = {Throwable.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result throwable(){
        return Result.fail();
    }


}
