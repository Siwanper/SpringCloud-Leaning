package com.siwanper.organization.exception;

import com.siwanper.core.exception.BaseException;

/**
 * 描述:
 * 用户不存在异常
 *
 * @outhor ios
 * @create 2020-04-10 9:43 AM
 */
public class UserNotFoundException extends BaseException {

    public UserNotFoundException(){
        super(OrganizationErrorType.USER_NOT_FOUND);
    }

    public UserNotFoundException(String mesg){
        super(OrganizationErrorType.USER_NOT_FOUND, mesg);
    }

}
