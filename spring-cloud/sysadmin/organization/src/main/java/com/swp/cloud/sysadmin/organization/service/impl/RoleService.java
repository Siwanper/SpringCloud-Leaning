package com.swp.cloud.sysadmin.organization.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swp.cloud.sysadmin.organization.dao.RoleMapper;
import com.swp.cloud.sysadmin.organization.dao.UserRoleMapper;
import com.swp.cloud.sysadmin.organization.entity.param.RoleQueryParam;
import com.swp.cloud.sysadmin.organization.entity.po.Role;
import com.swp.cloud.sysadmin.organization.entity.po.UserRole;
import com.swp.cloud.sysadmin.organization.service.IRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-05 2:35 PM
 */
@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public long add(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    @CacheEvict(value = "role", key = "#root.targetClass.name"+"+#id" )
    public void delete(long id) {
        roleMapper.deleteById(id);
    }

    @Override
    @CacheEvict(value = "role", key = "#root.targetClass.name"+"+#role.id" )
    public void update(Role role) {
        roleMapper.updateById(role);
    }

    @Override
    @Cacheable(value = "role", key = "#root.targetClass.name"+"+#id")
    public Role get(long id) {
        return roleMapper.selectById(id);
    }

    @Override
    public IPage<Role> query(Page page, RoleQueryParam roleQueryParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.ge(null != roleQueryParam.getCreatedTimeStart(),"created_time", roleQueryParam.getCreatedTimeStart());
        queryWrapper.le(null != roleQueryParam.getCreatedTimeEnd(), "created_time", roleQueryParam.getCreatedTimeEnd());
        queryWrapper.eq(StringUtils.isNotBlank(roleQueryParam.getCode()), "code", roleQueryParam.getCode());
        queryWrapper.eq(StringUtils.isNotBlank(roleQueryParam.getName()), "name", roleQueryParam.getCode());
        return roleMapper.selectPage(page,queryWrapper);
    }

    @Override
    public List<Role> query(long userId) {
        List<UserRole> userRoleList = userRoleMapper.selectList(new QueryWrapper<UserRole>().eq("user_id", userId));
        List<Role> roles = roleMapper.selectBatchIds(userRoleList.stream().map(userRole -> userRole.getRoleId()).collect(Collectors.toList()));
        return roles;
    }
}
