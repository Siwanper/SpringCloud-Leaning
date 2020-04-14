package com.siwanper.organization.service.impl;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.siwanper.organization.dao.RoleMapper;
import com.siwanper.organization.entity.po.Role;
import com.siwanper.organization.exception.RoleNotFoundException;
import com.siwanper.organization.exception.UserNotFoundException;
import com.siwanper.organization.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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

    @Transactional
    @Override
    public boolean add(Role role) {
        return this.save(role);
    }

    @Transactional
    @Override
    @CacheInvalidate(name = "role_", key = "#id")
    public boolean delete(String id) {
        return this.removeById(id);
    }

    @Transactional
    @Override
    @CacheInvalidate(name = "role_", key = "#role.id")
    public boolean update(Role role) {
        return this.updateById(role);
    }

    @Override
    @Cached(name = "role_", key = "#id" , cacheType = CacheType.BOTH)
    public Role get(String id) {
        Role role = this.getById(id);
        if (Objects.isNull(role)) {
            throw new RoleNotFoundException("角色不存在");
        }
        return role;
    }

    @Override
    public List<Role> getAll() {
        return this.list();
    }


}
