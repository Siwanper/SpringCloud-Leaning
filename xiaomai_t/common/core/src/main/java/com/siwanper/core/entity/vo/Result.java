package com.siwanper.core.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.siwanper.core.exception.BaseException;
import com.siwanper.core.exception.ErrorType;
import com.siwanper.core.exception.SystemErrorType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * 描述:
 * rest请求返回数据模型
 *
 * @outhor ios
 * @create 2020-03-26 11:15 AM
 */
@Getter
@ApiModel(value = "rest请求返回数据模型")
public class Result<T> {

    private static final String SUCCESS_CODE = "000000";
    private static final String SUCCESS_MESG = "请求成功";

    @ApiModelProperty(value = "请求结果code", required = true)
    private String code;

    @ApiModelProperty(value = "请求结果描述")
    private String mesg;

    @ApiModelProperty(value = "请求时间戳")
    private Instant time;

    @ApiModelProperty(value = "请求返回的数据")
    @JsonInclude(JsonInclude.Include.NON_NULL) //将该标记放在属性上，如果该属性为NULL则不参与序列化  //如果放在类上边,那对这个类的全部属性起作用  //Include.Include.ALWAYS 默认  //Include.NON_DEFAULT 属性为默认值不序列化  //Include.NON_EMPTY 属性为 空（“”） 或者为 NULL 都不序列化  //Include.NON_NULL 属性为NULL 不序列化
    private T data;

    public Result(){
        this.time = ZonedDateTime.now().toInstant();
    }

    public Result(ErrorType errorType) {
        this.code = errorType.getCode();
        this.mesg = errorType.getMesg();
        this.time = ZonedDateTime.now().toInstant();
    }

    public Result(ErrorType errorType, T data) {
        this(errorType);
        this.data = data;
    }

    /**
     * 内部使用，构造方法
     * @param code
     * @param mesg
     * @param data
     */
    private Result(String code, String mesg, T data) {
        this.code = code;
        this.mesg = mesg;
        this.time = ZonedDateTime.now().toInstant();
        this.data = data;
    }

    /**
     * 请求成功，没有返回数据
     * @return
     */
    public static Result success(){
        return success(null);
    }

    /**
     * 请求成功并返回请求结果
     * @return
     */
    public static Result success(Object data){
        return new Result<>(SUCCESS_CODE, SUCCESS_MESG, data);
    }

    /**
     * 请求成功并返回请求结果
     * @return
     */
    public static Result success(String mesg, Object data){
        return new Result<>(SUCCESS_CODE, mesg, data);
    }

    /**
     * 系统异常
     * @return
     */
    public static Result fail(){
        return new Result(SystemErrorType.SYSTEM_ERROR);
    }

    /**
     * 请求发生异常，并返回数据
     * @param exception
     * @param data
     * @return
     */
    public static Result fail(BaseException exception, Object data){
        return new Result(exception.getErrorType(), data);
    }

    /**
     * 请求发生异常，不返回数据
     * @param exception
     * @return
     */
    public static Result fail(BaseException exception){
        return fail(exception, null);
    }

    /**
     * 请求失败，并返回数据
     * @param errorType
     * @param data
     * @return
     */
    public static Result fail(ErrorType errorType, Object data) {
        return new Result(errorType, data);
    }

    /**
     * 请求失败，不返回数据
     * @param errorType
     * @return
     */
    public static Result fail(ErrorType errorType) {
        return new Result(errorType);
    }

    /**
     * 系统异常，并返回数据
     * @param data
     * @return
     */
    public static Result fail(Object data) {
        return new Result(SystemErrorType.SYSTEM_ERROR, data);
    }

    /**
     * 请求是否成功
     * @return
     */
    public boolean isSuccess(){
        return SUCCESS_CODE.equals(this.getCode());
    }

    /**
     * 请求是否失败
     * @return
     */
    public boolean isFail(){
        return !isSuccess();
    }


}
