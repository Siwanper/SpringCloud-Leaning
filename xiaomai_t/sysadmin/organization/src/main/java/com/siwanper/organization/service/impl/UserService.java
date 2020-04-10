package com.siwanper.organization.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.siwanper.organization.dao.UserMapper;
import com.siwanper.organization.entity.param.UserQueryParam;
import com.siwanper.organization.entity.po.User;
import com.siwanper.organization.entity.vo.UserVo;
import com.siwanper.organization.exception.UserNotFoundException;
import com.siwanper.organization.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Transactional
    @Override
    public boolean add(User user) {
        if (StringUtils.isNotBlank(user.getPassword())) {
            user.setPassword(passwordEncoder().encode(user.getPassword()));
        }
        boolean result = this.save(user);
        return result;
    }

    @Transactional
    @Override
    public boolean delete(String id) {
        boolean result = this.removeById(id);
        return result;
    }

    @Transactional
    @Override
    public boolean update(User user) {
        if (StringUtils.isNotBlank(user.getPassword())) {
            user.setPassword(passwordEncoder().encode(user.getPassword()));
        }
        boolean result = this.updateById(user);
        return result;
    }

    @Override
    public UserVo get(String id) {
        log.info(id);
        User user = this.getById(id);
        log.info("user : {}", user);
        if (Objects.isNull(user)) {
            throw new UserNotFoundException("用户不存在");
        }
        return new UserVo(user);
    }

    @Override
    public IPage<UserVo> query(Page page, UserQueryParam userQueryParam) {
        QueryWrapper<User> queryWrapper = userQueryParam.build();
        queryWrapper.eq(StringUtils.isNotBlank(userQueryParam.getName()), "name", userQueryParam.getName());
        queryWrapper.eq(StringUtils.isNotBlank(userQueryParam.getMobile()), "mobile", userQueryParam.getMobile());
        queryWrapper.eq(StringUtils.isNotBlank(userQueryParam.getUsername()), "username", userQueryParam.getUsername());
        IPage<User> pageUser = this.page(page, queryWrapper);
        return pageUser.convert(UserVo::new);
    }
}
