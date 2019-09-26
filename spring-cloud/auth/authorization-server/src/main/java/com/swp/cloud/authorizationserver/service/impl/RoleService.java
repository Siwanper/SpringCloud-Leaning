package com.swp.cloud.authorizationserver.service.impl;

import com.swp.cloud.authorizationserver.entity.Role;
import com.swp.cloud.authorizationserver.provider.OrganizationProvider;
import com.swp.cloud.authorizationserver.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-26 10:47 AM
 */
@Service
public class RoleService implements IRoleService {

    @Autowired
    private OrganizationProvider organizationProvider;

    @Override
    public Set<Role> getRoleByUserId(long userId) {
        return organizationProvider.getRoleByUserId(userId).getData();
    }
}
