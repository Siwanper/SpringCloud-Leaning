package com.swp.cloud.common.core.entity.vo;

import com.swp.cloud.common.core.exception.BaseException;
import com.swp.cloud.common.core.exception.ErrorType;
import com.swp.cloud.common.core.exception.SystemErrorType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * 描述:
 * 响应数据实体
 *
 * @outhor ios
 * @create 2019-09-02 2:52 PM
 */
@ApiModel("请求返回结果")
@Data
public class Result<T> {

    private static final String SUCCESSFUL_CODE = "000000";
    private static final String SUCCESSFUL_MESSAGE = "处理成功";

    @ApiModelProperty(value = "处理结果码", required = true)
    private String code;
    @ApiModelProperty(value = "处理结果信息")
    private String message;
    @ApiModelProperty(value = "处理的时间")
    private Instant timestamp;
    @ApiModelProperty(value = "返回的数据")
    private T data;

    public Result() {
        this.timestamp = ZonedDateTime.now().toInstant();
    }

    /**
     * 返回错误的构造函数并返回数据
     * @param errorType 错误类型
     */
    public Result(ErrorType errorType) {
        this.code = errorType.getCode();
        this.message = errorType.getMessage();
        this.timestamp = ZonedDateTime.now().toInstant();
    }

    /**
     * 返回错误的构造函数并返回数据
     * @param errorType 错误类型
     * @param data
     */
    public Result(ErrorType errorType, T data) {
        this.code = errorType.getCode();
        this.message = errorType.getMessage();
        this.timestamp = ZonedDateTime.now().toInstant();
        this.data = data;
    }

    /**
     * 内部构造函数
     * @param code
     * @param message
     * @param data
     */
    private Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.timestamp = ZonedDateTime.now().toInstant();
        this.data = data;
    }

    /**
     * 返回成功结构并返回数据
     * @param data
     * @return
     */
    public static Result success(Object data){
        return new Result<>(SUCCESSFUL_CODE, SUCCESSFUL_MESSAGE, data);
    }

    /**
     * 快速创建返回结果
     * @return
     */
    public static Result success(){
        return success(null);
    }

    /**
     * 系统错误
     * @return
     */
    public static Result fail(){
        return new Result(SystemErrorType.SYSTEM_ERROR);
    }

    /**
     * 根据错误类型返回结果
     * @param errorType 错误类型
     * @return
     */
    public static Result fail(ErrorType errorType) {
        return new Result(errorType);
    }

    /**
     * 根据错误类型和数据返回结果
     * @param errorType
     * @param data
     * @return
     */
    public static Result fail(ErrorType errorType, Object data) {
        return new Result(errorType, data);
    }

    /**
     * 根据系统异常返回结果
     * @param exception
     * @return
     */
    public static Result fail(BaseException exception) {
        return Result.fail(exception.getErrorType(),null);
    }

    /**
     * 根据系统异常返回处理结果并返回相关数据
     * @param exception 异常
     * @param data
     * @return
     */
    public static Result fail(BaseException exception, Object data) {
        return Result.fail(exception.getErrorType(),data);
    }

}
