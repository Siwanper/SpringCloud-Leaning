package com.siwanper.organization.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.siwanper.core.exception.BaseException;
import com.siwanper.core.exception.SystemErrorType;
import com.siwanper.organization.dao.UserMapper;
import com.siwanper.organization.entity.po.User;
import com.siwanper.organization.entity.vo.UserVo;
import com.siwanper.organization.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 描述:
 * 用户服务管理
 *
 * @outhor ios
 * @create 2020-04-08 4:39 PM
 */
@Service
@Slf4j
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {

    public UserVo get(String id) {
        User user = this.getById(id);
        if (Objects.isNull(user)) {
            throw new BaseException(SystemErrorType.SYSTEM_ERROR);
        }
        return new UserVo(user);
    }
}
