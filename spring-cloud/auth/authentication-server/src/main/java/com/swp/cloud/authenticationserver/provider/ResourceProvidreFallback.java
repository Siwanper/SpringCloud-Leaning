package com.swp.cloud.authenticationserver.provider;

import com.swp.cloud.sysadmin.organization.entity.po.Resource;
import com.swp.cloud.common.core.entity.vo.Result;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-29 11:31 AM
 */
public class ResourceProvidreFallback implements ResourceProvider {

    @Override
    public Result<Set<Resource>> resources() {
        return Result.success(new HashSet<Resource>());
    }

    @Override
    public Result<Set<Resource>> resources(String username) {
        return Result.success(new HashSet<Resource>());
    }
}
