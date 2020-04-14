package com.siwanper.organization.exception;

import com.siwanper.core.exception.BaseException;

/**
 * DESCRIPTION：   角色不存在异常
 *
 * @ProjectName: cloud
 * @Package: com.siwanper.organization.exception
 * @Author: Siwanper
 * @CreateDate: 2020/4/14 下午11:19
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2020</p>
 */
public class RoleNotFoundException extends BaseException {

    public RoleNotFoundException(){
        super(OrganizationErrorType.ROLE_NOT_FOUND);
    }

    public RoleNotFoundException(String message){
        super(OrganizationErrorType.ROLE_NOT_FOUND, message);
    }

}
