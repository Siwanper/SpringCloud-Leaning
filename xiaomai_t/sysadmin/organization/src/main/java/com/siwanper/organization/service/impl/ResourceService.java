package com.siwanper.organization.service.impl;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.siwanper.organization.dao.ResourceMapper;
import com.siwanper.organization.entity.param.ResourceQueryParam;
import com.siwanper.organization.entity.po.Resource;
import com.siwanper.organization.entity.po.RoleResource;
import com.siwanper.organization.entity.vo.UserVo;
import com.siwanper.organization.exception.ResourceNotFoundException;
import com.siwanper.organization.exception.RoleNotFoundException;
import com.siwanper.organization.exception.UserNotFoundException;
import com.siwanper.organization.service.IResourceService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 描述:
 * 资源服务
 *
 * @outhor ios
 * @create 2020-04-17 10:39 AM
 */
@Service
public class ResourceService extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleResourceService roleResourceService;

    @Transactional
    @Override
    public boolean add(Resource resource) {
        return this.save(resource);
    }

    @Transactional
    @Override
    @CacheInvalidate(name = "resource_", key = "#id")
    public boolean delete(String id) {
        return this.removeById(id);
    }

    @Transactional
    @Override
    @CacheInvalidate(name = "resource_", key = "#resource.id")
    public boolean update(Resource resource) {
        return this.updateById(resource);
    }

    @Override
    @Cached(name = "resource_", key = "#id", cacheType = CacheType.BOTH)
    public Resource get(String id) {
        Resource resource = this.getById(id);
        if (Objects.isNull(resource)) {
            throw new ResourceNotFoundException("资源不存在");
        }
        return resource;
    }

    @Override
    public List<Resource> getAll() {
        return this.list();
    }

    @Override
    public IPage<Resource> query(Page page, ResourceQueryParam resourceQueryParam) {
        QueryWrapper<Resource> queryWrapper = resourceQueryParam.build();
        queryWrapper.eq(StringUtils.isNotBlank(resourceQueryParam.getCode()),"code", resourceQueryParam.getCode());
        queryWrapper.eq(StringUtils.isNotBlank(resourceQueryParam.getType()),"type", resourceQueryParam.getType());
        queryWrapper.eq(StringUtils.isNotBlank(resourceQueryParam.getName()),"name", resourceQueryParam.getName());
        queryWrapper.eq(StringUtils.isNotBlank(resourceQueryParam.getUrl()),"url", resourceQueryParam.getUrl());
        queryWrapper.eq(StringUtils.isNotBlank(resourceQueryParam.getMethod()),"method", resourceQueryParam.getMethod());
        return this.page(page,queryWrapper);

    }

    @Override
    public List<Resource> queryByUsername(String username) {
        UserVo userVo = userService.getByUniqueId(username);
        if (Objects.isNull(userVo)){
            throw new UserNotFoundException("用户不存在");
        }
        Set<String> roleIds = userRoleService.queryRoleIdsByUserId(userVo.getId());
        if (CollectionUtils.isEmpty(roleIds)) {
            throw new RoleNotFoundException("此用户暂无角色信息");
        }
        Set<String> resourceIds = roleResourceService.queryByRoleIds(roleIds);
        if (CollectionUtils.isEmpty(resourceIds)) {
            throw new ResourceNotFoundException("此用户暂无资源信息");
        }
        return (List<Resource>) this.listByIds(resourceIds);
    }
}
