package com.siwanper.gateway.web.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.siwanper.gateway.web.service.IRouteService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RouteService implements IRouteService {

    private static final String GATEWAY_ROUTES = "gateway_routes::";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @CreateCache(name = GATEWAY_ROUTES, cacheType = CacheType.REMOTE)
    private Cache<String, RouteDefinition> gatewayRouteCache;

    private Map<String, RouteDefinition> routeDefinitions = new HashMap<>();

    @PostConstruct
    private void loadRouteDefinition(){
        log.info("loadRouteDefinition 开始初始化路由");
        Set<String> gatewayKeys = stringRedisTemplate.keys(GATEWAY_ROUTES + "*");
        if (CollectionUtils.isEmpty(gatewayKeys)){
            return;
        }
        log.info("预计初始化路由：{}",gatewayKeys);
        Set<String> keys = gatewayKeys.stream().map(key -> {
            return key.replace(GATEWAY_ROUTES, Strings.EMPTY);
        }).collect(Collectors.toSet());
        Map<String, RouteDefinition> routeDefinitionMap = gatewayRouteCache.getAll(keys);
        log.info("gatewayRoutes:{}",routeDefinitionMap);

        routeDefinitions.putAll(routeDefinitionMap);
        log.info("共初始化路由信息:{}",routeDefinitions.size());
    }

    @Override
    public Collection<RouteDefinition> getRouteDefinitions() {
        return null;
    }
}
