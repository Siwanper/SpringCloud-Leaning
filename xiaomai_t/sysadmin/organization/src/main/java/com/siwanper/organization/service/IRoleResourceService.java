package com.siwanper.organization.service;

import java.util.Set;

public interface IRoleResourceService {

    boolean saveBatch(String roleId, Set<String> resourceIds);

    boolean deleteByRoleId(String roleId);

    Set<String> queryByRoleId(String roleId);

    Set<String> queryByRoleIds(Set<String> roleIds);

}
