package com.swp.cloud.sysadmin.organization.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swp.cloud.sysadmin.organization.entity.param.UserQueryParam;
import com.swp.cloud.sysadmin.organization.entity.po.User;
import com.swp.cloud.sysadmin.organization.entity.vo.UserVo;

public interface IUserService {

    /**
     * 增加用户
     * @param user
     * @return
     */
    long add(User user);

    /**
     * 删除用户
     * @param id
     */
    void delete(long id);

    /**
     * 修改用户
     * @param user
     */
    void update(User user);

    /**
     * 根据用户ID获取用户
     * @param id
     * @return
     */
    User get(long id);

    /**
     * 根据唯一标示获取用户
     * 这里的唯一标示是用户名或者mobile
     * @param unique
     * @return
     */
    User getUnique(String unique);

    /**
     * 分页查询
     * @param page
     * @param userQueryParam
     * @return
     */
    IPage<UserVo> query(Page<User> page, UserQueryParam userQueryParam);


}
