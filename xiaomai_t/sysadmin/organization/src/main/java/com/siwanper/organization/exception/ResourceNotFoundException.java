package com.siwanper.organization.exception;

import com.siwanper.core.exception.BaseException;

/**
 * 描述:
 * 资源不存在异常
 *
 * @outhor ios
 * @create 2020-04-17 10:46 AM
 */
public class ResourceNotFoundException  extends BaseException {

    public ResourceNotFoundException(){
        super(OrganizationErrorType.RESOURCE_NOT_FOUND);
    }

    public ResourceNotFoundException(String message){
        super(OrganizationErrorType.RESOURCE_NOT_FOUND, message);
    }

}
