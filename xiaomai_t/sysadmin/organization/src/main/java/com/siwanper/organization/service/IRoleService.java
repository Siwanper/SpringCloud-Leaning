package com.siwanper.organization.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.siwanper.organization.entity.param.RoleQueryParam;
import com.siwanper.organization.entity.po.Role;

import java.util.List;

/**
 * DESCRIPTION：   角色服务
 *
 * @ProjectName: cloud
 * @Package: com.siwanper.organization.service
 * @Author: Siwanper
 * @CreateDate: 2020/4/14 下午10:08
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2020</p>
 */
public interface IRoleService {

    /**
     * 添加角色
     * @param role
     * @return
     */
    boolean add(Role role);

    /**
     * 删除角色
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * 修改角色
     * @param role 角色
     * @return
     */
    boolean update(Role role);

    /**
     * 根据角色Id查询
     * @param id
     * @return
     */
    Role get(String id);

    /**
     * 获取所有角色
     * @return
     */
    List<Role> getAll();

    /**
     * 获取用户的所有角色
     * @param userId 用户Id
     * @return
     */
    List<Role> getByUserId(String userId);

    /**
     * 条件查询角色
     * @param page 页数
     * @param roleQueryParam 查询条件
     * @return
     */
    IPage<Role> query(Page page, RoleQueryParam roleQueryParam);

}
