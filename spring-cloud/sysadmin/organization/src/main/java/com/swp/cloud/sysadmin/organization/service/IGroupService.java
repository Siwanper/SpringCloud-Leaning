package com.swp.cloud.sysadmin.organization.service;

import com.swp.cloud.sysadmin.organization.entity.param.GroupQueryParam;
import com.swp.cloud.sysadmin.organization.entity.po.Group;

import java.util.List;

public interface IGroupService {

    /**
     * 添加用户组
     * @param group
     * @return
     */
    long add(Group group);

    /**
     * 删除用户组
     * @param id
     */
    void delete(long id);

    /**
     * 修改用户组
     * @param group
     */
    void update(Group group);

    /**
     * 获取用户组
     * @param id
     * @return
     */
    Group get(long id);

    /**
     * 查询用户组
     * @param groupQueryParam
     * @return
     */
    List<Group> query(GroupQueryParam groupQueryParam);

    /**
     * 根据父ID查询用户组
     * @param parentId
     * @return
     */
    List<Group> queryByParentId(long parentId);


}
