package com.swp.cloud.authorizationserver.service;

import com.swp.cloud.authorizationserver.entity.Role;

import java.util.Set;

public interface IRoleService {

    Set<Role> getRoleByUserId(long userId);

}
