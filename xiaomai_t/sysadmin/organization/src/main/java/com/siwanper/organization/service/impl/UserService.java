package com.siwanper.organization.service.impl;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.siwanper.organization.dao.UserMapper;
import com.siwanper.organization.entity.param.UserQueryParam;
import com.siwanper.organization.entity.po.User;
import com.siwanper.organization.entity.vo.UserVo;
import com.siwanper.organization.exception.UserNotFoundException;
import com.siwanper.organization.service.IUserRoleService;
import com.siwanper.organization.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IUserRoleService userRoleService;

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
        // 添加角色
        userRoleService.saveBatch(user.getId(), user.getRoleIds());
        return result;
    }

    @Transactional
    @CacheInvalidate(name = "user_", key = "#id")
    @Override
    public boolean delete(String id) {
        this.removeById(id);
        return userRoleService.deleteByUserId(id);
    }

    @Transactional
    @CacheInvalidate(name = "user_", key = "#user.id")
    @Override
    public boolean update(User user) {
        if (StringUtils.isNotBlank(user.getPassword())) {
            user.setPassword(passwordEncoder().encode(user.getPassword()));
        }
        boolean result = this.updateById(user);
        userRoleService.saveBatch(user.getId(), user.getRoleIds());
        return result;
    }

    @Cached(name = "user_", key = "#id", cacheType = CacheType.BOTH)
    @Override
    public UserVo get(String id) {
        User user = this.getById(id);
        if (Objects.isNull(user)) {
            throw new UserNotFoundException("用户不存在");
        }
        user.setRoleIds(userRoleService.queryRoleIdsByUserId(id));
        return new UserVo(user);
    }

    @Cached(name = "user_", key = "#uniqueId", cacheType = CacheType.BOTH)
    @Override
    public UserVo getByUniqueId(String uniqueId) {
        User user = this.getOne(new QueryWrapper<User>().eq("username", uniqueId).or().eq("mobile", uniqueId));
        if (Objects.isNull(user)){
            throw new UserNotFoundException("该用户不存在");
        }
        user.setRoleIds(userRoleService.queryRoleIdsByUserId(user.getId()));
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
