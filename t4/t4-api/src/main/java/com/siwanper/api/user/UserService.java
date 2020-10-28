package com.siwanper.api.user;


import com.siwanper.dao.model.user.SysUser;

public interface UserService {
    SysUser getUser(Integer id);
}
