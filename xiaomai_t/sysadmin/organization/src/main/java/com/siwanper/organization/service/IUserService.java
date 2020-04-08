package com.siwanper.organization.service;

import com.siwanper.organization.entity.vo.UserVo;

public interface IUserService {

    /**
     * 根据用户ID获取用户
     * @param id
     * @return
     */
    UserVo get(String id);

}
