package com.siwanper.core.exception;

/**
 * 描述:
 * 业务异常类
 *
 * @outhor ios
 * @create 2020-03-26 10:46 AM
 */
public class ServiceException extends BaseException {

    //TODO 对指定的业务异常类进行处理

    public ServiceException(SystemErrorType systemError) {
        super(systemError);
    }

    public static ServiceException userInvalide(){return new ServiceException(SystemErrorType.SYSTEM_ERROR);}
}
