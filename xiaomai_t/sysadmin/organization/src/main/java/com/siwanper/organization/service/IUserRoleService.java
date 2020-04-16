package com.siwanper.organization.service;

import java.util.Set;

public interface IUserRoleService {

    boolean saveBatch(String userId, Set<String> roles);

    boolean deleteByUserId(String userId);

    boolean deleteByRoleId(String roleId);

    Set<String> queryRoleIdsByUserId(String userId);

}
