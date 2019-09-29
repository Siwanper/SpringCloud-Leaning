package com.swp.cloud.sysadmin.organization.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swp.cloud.sysadmin.organization.dao.ResourceMapper;
import com.swp.cloud.sysadmin.organization.dao.RoleResourceMapper;
import com.swp.cloud.sysadmin.organization.dao.UserMapper;
import com.swp.cloud.sysadmin.organization.entity.param.ResourceQueryParam;
import com.swp.cloud.sysadmin.organization.entity.po.Resource;
import com.swp.cloud.sysadmin.organization.entity.po.Role;
import com.swp.cloud.sysadmin.organization.entity.po.RoleResource;
import com.swp.cloud.sysadmin.organization.entity.po.User;
import com.swp.cloud.sysadmin.organization.service.IResourceService;
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
 * @create 2019-09-05 4:47 PM
 */
@Service
public class ResourceService implements IResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public long add(Resource resource) {
        return resourceMapper.insert(resource);
    }

    @Override
    @CacheEvict(value = "resource", key = "#root.targetClass.name"+"+#id")
    public void delete(long id) {
        resourceMapper.deleteById(id);
    }

    @Override
    @CacheEvict(value = "resource", key = "#root.targetClass.name"+"+#resource.id")
    public void update(Resource resource) {
        resourceMapper.updateById(resource);
    }

    @Override
    @Cacheable(value = "resource", key = "#root.targetClass.name"+"+#id")
    public Resource get(long id) {
        return resourceMapper.selectById(id);
    }

    @Override
    public IPage<Resource> queryPage(Page page, ResourceQueryParam resourceQueryParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.ge(null != resourceQueryParam.getCreatedTimeStart(), "created_time", resourceQueryParam.getCreatedTimeStart());
        queryWrapper.le(null != resourceQueryParam.getCreatedTimeEnd(), "created_time", resourceQueryParam.getCreatedTimeEnd());
        queryWrapper.eq(StringUtils.isNotBlank(resourceQueryParam.getCode()), "code", resourceQueryParam.getCode());
        queryWrapper.eq(StringUtils.isNotBlank(resourceQueryParam.getName()), "name", resourceQueryParam.getName());
        queryWrapper.eq(StringUtils.isNotBlank(resourceQueryParam.getType()), "type", resourceQueryParam.getType());
        queryWrapper.eq(StringUtils.isNotBlank(resourceQueryParam.getUrl()), "url", resourceQueryParam.getUrl());
        queryWrapper.eq(StringUtils.isNotBlank(resourceQueryParam.getMethod()), "method", resourceQueryParam.getMethod());
        return resourceMapper.selectPage(page,queryWrapper);
    }

    @Override
    public List<Resource> query(ResourceQueryParam resourceQueryParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.ge(null != resourceQueryParam.getCreatedTimeStart(), "created_time", resourceQueryParam.getCreatedTimeStart());
        queryWrapper.le(null != resourceQueryParam.getCreatedTimeEnd(), "created_time", resourceQueryParam.getCreatedTimeEnd());
        queryWrapper.eq(StringUtils.isNotBlank(resourceQueryParam.getCode()), "code", resourceQueryParam.getCode());
        queryWrapper.eq(StringUtils.isNotBlank(resourceQueryParam.getName()), "name", resourceQueryParam.getName());
        queryWrapper.eq(StringUtils.isNotBlank(resourceQueryParam.getType()), "type", resourceQueryParam.getType());
        queryWrapper.eq(StringUtils.isNotBlank(resourceQueryParam.getUrl()), "url", resourceQueryParam.getUrl());
        queryWrapper.eq(StringUtils.isNotBlank(resourceQueryParam.getMethod()), "method", resourceQueryParam.getMethod());
        return resourceMapper.selectList(queryWrapper);
    }

    @Override
    public List<Resource> query(String username) {

        User user = userService.getUnique(username);
        List<Role> roles = roleService.query(user.getId());
        List<Long> roleIds = roles.stream().map(role -> role.getId()).collect(Collectors.toList());
        List<RoleResource> roleResources = roleResourceMapper.selectList(new QueryWrapper<RoleResource>().in("role_id", roleIds));

        return resourceMapper.selectBatchIds(roleResources.stream().map(roleResource -> roleResource.getResourceId()).collect(Collectors.toList()));
    }
}
