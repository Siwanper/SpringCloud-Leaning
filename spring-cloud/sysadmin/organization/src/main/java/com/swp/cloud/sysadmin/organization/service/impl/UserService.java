package com.swp.cloud.sysadmin.organization.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swp.cloud.sysadmin.organization.dao.UserMapper;
import com.swp.cloud.sysadmin.organization.entity.param.UserQueryParam;
import com.swp.cloud.sysadmin.organization.entity.po.User;
import com.swp.cloud.sysadmin.organization.entity.vo.UserVo;
import com.swp.cloud.sysadmin.organization.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-04 10:57 AM
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public long add(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userMapper.insert(user);
    }

    @Override
    // 清除缓存
    @CacheEvict(value = "user", key = "#root.targetClass.name"+"+#id")
    public void delete(long id) {
        userMapper.deleteById(id);
    }

    @Override
    @CacheEvict(value = "user", key = "#root.targetClass.name"+"+#user.id")
    public void update(User user) {
        userMapper.updateById(user);
    }

    @Override
    // 添加缓存
    @Cacheable(value = "user", key = "#root.targetClass.name"+"+#id")
    public User get(long id) {
        return userMapper.selectById(id);
    }

    @Override
    public User getUnique(String unique) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotBlank(unique), "username", unique)
                .or()
                .eq(StringUtils.isNotBlank(unique), "mobile", unique);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public IPage<UserVo> query(Page<User> page, UserQueryParam userQueryParam) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.ge(null != userQueryParam.getCreatedTimeStart(),"created_time", userQueryParam.getCreatedTimeStart());
        queryWrapper.le(null != userQueryParam.getCreatedTimeEnd(), "created_time", userQueryParam.getCreatedTimeEnd());
        queryWrapper.eq(StringUtils.isNotBlank(userQueryParam.getName()),"name", userQueryParam.getName());
        queryWrapper.eq(StringUtils.isNotBlank(userQueryParam.getUsername()),"username", userQueryParam.getUsername());
        queryWrapper.eq(StringUtils.isNotBlank(userQueryParam.getMobile()),"mobile", userQueryParam.getMobile());

        IPage<UserVo> voIPage = userMapper.selectPage(page, queryWrapper).convert((user -> {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user, userVo);
            return userVo;
        }));

        return voIPage;
    }


}
