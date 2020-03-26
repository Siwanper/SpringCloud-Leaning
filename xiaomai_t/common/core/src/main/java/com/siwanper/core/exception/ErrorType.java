package com.siwanper.core.exception;

public interface ErrorType {

    /**
     * 返回错误码
     * @return
     */
    String getCode();


    /**
     * 返回错误信息
     * @return
     */
    String getMesg();

}
