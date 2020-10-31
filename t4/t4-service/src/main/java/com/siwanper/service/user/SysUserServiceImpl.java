package com.siwanper.service.user;

import com.siwanper.api.user.SysUserService;
import com.siwanper.common.service.impl.BaseServiceImpl;
import com.siwanper.dao.mapper.user.SysUserMapper;
import com.siwanper.dao.model.user.SysUser;
import com.siwanper.dao.model.user.SysUserExample;
import com.siwanper.dao.model.user.SysUserKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser, SysUserExample> implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    public int deleteByPrimaryKey(SysUserKey sysUserKey) {
        return userMapper.deleteByPrimaryKey(sysUserKey);
    }

    public SysUser selectByPrimaryKey(SysUserKey sysUserKey) {
        return userMapper.selectByPrimaryKey(sysUserKey);
    }
}
