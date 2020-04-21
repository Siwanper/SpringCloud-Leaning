package com.siwanper.authorization.service.impl;

import com.siwanper.authorization.entity.po.Role;
import com.siwanper.authorization.provider.OrganizationProvider;
import com.siwanper.authorization.service.IRoleService;
import com.siwanper.core.entity.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-04-21 4:12 PM
 */
@Service
public class RoleService implements IRoleService {

    @Autowired
    private OrganizationProvider organizationProvider;

    @Override
    public List<Role> getRolesByUserId(String userId) {
        Result<List<Role>> result = organizationProvider.getRolesByUserId(userId);
        return result.getData();
    }
}
