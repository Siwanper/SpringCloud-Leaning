package com.siwanper.authorization.service.impl;

import com.siwanper.authorization.entity.po.User;
import com.siwanper.authorization.provider.OrganizationProvider;
import com.siwanper.authorization.service.IUserService;
import com.siwanper.core.entity.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * 用户服务
 *
 * @outhor ios
 * @create 2020-04-21 3:17 PM
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private OrganizationProvider organizationProvider;

    @Override
    public User getUserByUniqueId(String uniqueId) {
        Result<User> result= organizationProvider.getUserByUniqueId(uniqueId);
        return result.getData();
    }


}
