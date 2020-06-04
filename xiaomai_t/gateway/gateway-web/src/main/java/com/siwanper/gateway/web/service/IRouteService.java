package com.siwanper.gateway.web.service;

import org.springframework.cloud.gateway.route.RouteDefinition;

import java.util.Collection;

public interface IRouteService {

    /**
     * 从redis中加载路由，并保存到内存中
     * @return
     */
    Collection<RouteDefinition> getRouteDefinitions();

    /**
     * 添加路由
     * @param routeDefinition
     */
    void save(RouteDefinition routeDefinition);

    /**
     * 删除路由
     * @param routeId
     */
    void delete(String routeId);


}
