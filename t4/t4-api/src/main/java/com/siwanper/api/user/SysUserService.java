package com.siwanper.api.user;

import com.siwanper.common.service.BaseService;
import com.siwanper.dao.model.user.SysUser;
import com.siwanper.dao.model.user.SysUserExample;
import com.siwanper.dao.model.user.SysUserKey;

public interface SysUserService extends BaseService<SysUser, SysUserExample> {

    int deleteByPrimaryKey(SysUserKey sysUserKey);

    SysUser selectByPrimaryKey(SysUserKey sysUserKey);

}
