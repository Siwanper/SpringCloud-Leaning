package com.siwanper.service.user;


import com.siwanper.api.user.UserService;
import com.siwanper.dao.mapper.user.SysUserMapper;
import com.siwanper.dao.model.user.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    public SysUser getUser(Integer id) {
        return userMapper.getUser(id);
    }
}
