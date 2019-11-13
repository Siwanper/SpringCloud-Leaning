package com.swp.cloud.gateway.admin.service;

import com.swp.cloud.gateway.admin.entity.po.GatewayRoute;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-11-13 4:56 PM
 */
public interface IGatewayRouteService {

    /**
     * 添加网关信息
     * @param gatewayRoute
     * @return
     */
    long add(GatewayRoute gatewayRoute);

    /**
     * 根据网关Id获取网关信息
     * @param id
     * @return
     */
    GatewayRoute get(long id);

}
