package com.swp.cloud.sysadmin.organization.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swp.cloud.sysadmin.organization.entity.param.RoleQueryParam;
import com.swp.cloud.sysadmin.organization.entity.po.Role;

import java.util.List;

public interface IRoleService {

    /**
     * 添加角色
     * @param role
     * @return
     */
    long add(Role role);

    /**
     * 删除角色
     * @param id
     */
    void delete(long id);

    /**
     * 修改角色信息
     * @param role
     */
    void update(Role role);

    /**
     * 查找角色
     * @param id
     * @return
     */
    Role get(long id);

    /**
     * 分页查询角色
     * @param page
     * @param roleQueryParam
     * @return
     */
    IPage<Role> query(Page page, RoleQueryParam roleQueryParam);

    /**
     * 获取用户的所有角色
     * @param userId  用户ID
     * @return
     */
    List<Role> query(long userId);
}
