package com.siwanper.authentication.provider;

import com.google.common.collect.Sets;
import com.siwanper.organization.entity.po.Resource;
import com.siwanper.core.entity.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-04-28 12:17 PM
 */
@Slf4j
@Component
public class ResourceProviderFallback implements ResourceProvider {

    @Override
    public Result<Set<Resource>> resource() {
        log.error("认证服务启动时加载资源失败，未加载到资源");
        return Result.success(Sets.newHashSet());
    }

    @Override
    public Result<Set<Resource>> resource(String username) {
        log.error("认证服务用户查询资源失败，查询资源为空");
        return Result.success(Sets.newHashSet());
    }
}
