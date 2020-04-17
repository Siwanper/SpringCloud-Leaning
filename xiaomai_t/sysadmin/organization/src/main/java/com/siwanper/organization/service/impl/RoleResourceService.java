package com.siwanper.organization.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.siwanper.organization.dao.RoleResourceMapper;
import com.siwanper.organization.entity.po.RoleResource;
import com.siwanper.organization.service.IRoleResourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 描述:
 * 角色和资源关系服务
 *
 * @outhor ios
 * @create 2020-04-17 2:29 PM
 */
@Service
public class RoleResourceService extends ServiceImpl<RoleResourceMapper, RoleResource> implements IRoleResourceService {

    @Transactional
    @Override
    public boolean saveBatch(String roleId, Set<String> resourceIds) {
        if (CollectionUtils.isEmpty(resourceIds)) {
            return false;
        }
        deleteByRoleId(roleId);
        List<RoleResource> roleResources = resourceIds.stream().map(resourceId -> new RoleResource(roleId, resourceId)).collect(Collectors.toList());
        return this.saveBatch(roleResources);
    }

    @Transactional
    @Override
    public boolean deleteByRoleId(String roleId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("role_id", roleId);
        return this.remove(queryWrapper);
    }

    @Override
    public Set<String> queryByRoleId(String roleId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("role_id", roleId);
        List<RoleResource> roleResource = this.list(queryWrapper);
        return roleResource.stream().map(RoleResource::getResourceId).collect(Collectors.toSet());
    }

    @Override
    public Set<String> queryByRoleIds(Set<String> roleIds) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.in("role_id", roleIds);
        List<RoleResource> roleResources = this.list(queryWrapper);
        Set<String> resourceIds = roleResources.stream().map(RoleResource::getResourceId).collect(Collectors.toSet());
        return resourceIds;
    }
}
