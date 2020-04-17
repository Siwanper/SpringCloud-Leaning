package com.siwanper.organization.service.impl;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.siwanper.organization.dao.RoleMapper;
import com.siwanper.organization.entity.param.RoleQueryParam;
import com.siwanper.organization.entity.po.Role;
import com.siwanper.organization.exception.RoleNotFoundException;
import com.siwanper.organization.exception.UserNotFoundException;
import com.siwanper.organization.service.IRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * DESCRIPTION：角色服务
 *
 * @ProjectName: cloud
 * @Package: com.siwanper.organization.service.impl
 * @Author: Siwanper
 * @CreateDate: 2020/4/14 下午10:09
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2020</p>
 */
@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleResourceService roleResourceService;

    @Transactional
    @Override
    public boolean add(Role role) {
        boolean result = this.save(role);
        roleResourceService.saveBatch(role.getId(), role.getResourceIds());
        return result;
    }

    @Transactional
    @Override
    @CacheInvalidate(name = "role_", key = "#id")
    public boolean delete(String id) {
        boolean result = this.removeById(id);
        roleResourceService.deleteByRoleId(id);
        return result;
    }

    @Transactional
    @Override
    @CacheInvalidate(name = "role_", key = "#role.id")
    public boolean update(Role role) {
        boolean result = this.updateById(role);
        roleResourceService.saveBatch(role.getId(), role.getResourceIds());
        return result;
    }

    @Override
    @Cached(name = "role_", key = "#id" , cacheType = CacheType.BOTH)
    public Role get(String id) {
        Role role = this.getById(id);
        if (Objects.isNull(role)) {
            throw new RoleNotFoundException("角色不存在");
        }
        role.setResourceIds(roleResourceService.queryByRoleId(id));
        return role;
    }

    @Override
    public List<Role> getAll() {
        return this.list();
    }

    @Override
    public List<Role> getByUserId(String userId) {
        Set<String> roleIs = userRoleService.queryRoleIdsByUserId(userId);
        return (List<Role>) this.listByIds(roleIs);
    }

    @Override
    public IPage<Role> query(Page page, RoleQueryParam roleQueryParam) {
        QueryWrapper<Role> queryWrapper = roleQueryParam.build();
        queryWrapper.eq(StringUtils.isNotBlank(roleQueryParam.getName()),"name", roleQueryParam.getName());
        queryWrapper.eq(StringUtils.isNotBlank(roleQueryParam.getCode()),"code",roleQueryParam.getCode());
        IPage roles = this.page(page, queryWrapper);
        return roles;
    }


}
