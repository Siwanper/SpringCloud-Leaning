package com.siwanper.gateway.web.service;

import org.springframework.cloud.gateway.route.RouteDefinition;

import java.util.Collection;

public interface IRouteService {

    /**
     * 加载路由
     * @return
     */
    Collection<RouteDefinition> getRouteDefinitions();

}
