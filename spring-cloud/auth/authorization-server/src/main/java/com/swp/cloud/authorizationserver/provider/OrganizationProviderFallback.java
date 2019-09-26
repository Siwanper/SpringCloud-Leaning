package com.swp.cloud.authorizationserver.provider;

import com.swp.cloud.authorizationserver.entity.Role;
import com.swp.cloud.authorizationserver.entity.User;
import com.swp.cloud.common.core.entity.vo.Result;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-26 10:31 AM
 */
public class OrganizationProviderFallback implements OrganizationProvider {

    @Override
    public Result<User> getByUniqueId(String unique) {
        return Result.success(new User());
    }

    @Override
    public Result<Set<Role>> getRoleByUserId(long userId) {
        return Result.success(new HashSet<Role>());
    }
}
