package com.siwanper.organization.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.siwanper.organization.entity.param.UserQueryParam;
import com.siwanper.organization.entity.po.User;
import com.siwanper.organization.entity.vo.UserVo;

public interface IUserService {

    /**
     * 添加用户
     * @param user
     * @return
     */
    boolean add(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * 修改用户
     * @param user
     * @return
     */
    boolean update(User user);

    /**
     * 根据用户ID获取用户
     * @param id
     * @return
     */
    UserVo get(String id);

    /**
     * 根据唯一标识获取用户（这里指的是用户名或者手机号）
     * @param uniqueId
     * @return
     */
    UserVo getByUniqueId(String uniqueId);

    /**
     * 条件查询
     * @param page 分页
     * @param userQueryParam 条件
     * @return
     */
    IPage<UserVo> query(Page page, UserQueryParam userQueryParam);

}
