package com.siwanper.authorization.provider;

import com.siwanper.authorization.entity.po.Role;
import com.siwanper.authorization.entity.po.User;
import com.siwanper.core.entity.vo.Result;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 组织服务熔断
 *
 * @outhor ios
 * @create 2020-04-21 3:09 PM
 */
@Component
public class OrganizationProviderFallBack implements OrganizationProvider {

    @Override
    public Result<User> getUserByUniqueId(String uniqueId) {
        return Result.success(new User());
    }

    @Override
    public Result<List<Role>> getRolesByUserId(String userId) {
        return Result.success(new ArrayList<Role>());
    }
}
