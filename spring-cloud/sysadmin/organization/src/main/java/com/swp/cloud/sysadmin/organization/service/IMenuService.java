package com.swp.cloud.sysadmin.organization.service;

import com.swp.cloud.sysadmin.organization.entity.param.MenuQueryParam;
import com.swp.cloud.sysadmin.organization.entity.po.Menu;

import java.util.List;

public interface IMenuService {

    /**
     * 添加菜单
     * @param menu
     * @return
     */
    long add(Menu menu);

    /**
     * 删除菜单
     * @param id
     */
    void delete(long id);

    /**
     * 修改菜单
     * @param menu
     */
    void update(Menu menu);

    /**
     * 获取菜单
     * @param id
     * @return
     */
    Menu get(long id);

    /**
     * 查询菜单
     * @param menuQueryParam
     * @return
     */
    List<Menu> query(MenuQueryParam menuQueryParam);

    /**
     * 根据父ID查询菜单
     * @param parentId
     * @return
     */
    List<Menu> queryByParentId(long parentId);

}
