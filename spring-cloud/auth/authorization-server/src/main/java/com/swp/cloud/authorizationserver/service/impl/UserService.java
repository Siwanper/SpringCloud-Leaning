package com.swp.cloud.authorizationserver.service.impl;

import com.swp.cloud.authorizationserver.entity.User;
import com.swp.cloud.authorizationserver.provider.OrganizationProvider;
import com.swp.cloud.authorizationserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-26 10:20 AM
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private OrganizationProvider organizationProvider;

    @Override
    public User getByUniqueId(String unique) {
        return organizationProvider.getByUniqueId(unique).getData();
    }
}
