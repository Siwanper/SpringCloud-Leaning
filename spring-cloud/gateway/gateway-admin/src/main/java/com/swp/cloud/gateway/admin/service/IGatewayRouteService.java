package com.swp.cloud.gateway.admin.service;

import com.swp.cloud.gateway.admin.entity.param.GatewayRouteQueryParam;
import com.swp.cloud.gateway.admin.entity.po.GatewayRoute;

import java.util.List;

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
     * 根据Id删除网关
     * @param id
     */
    void delete(long id);

    /**
     * 修改网关信息
     * @param gatewayRoute
     */
    void update(GatewayRoute gatewayRoute);

    /**
     * 根据网关Id获取网关信息
     * @param id
     * @return
     */
    GatewayRoute get(long id);

    /**
     * 按条件查询网关路由
     * @param gatewayRouteQueryParam
     * @return
     */
    List<GatewayRoute> query(GatewayRouteQueryParam gatewayRouteQueryParam);

    /**
     * 重新加载网关信息到redis中
     * @return
     */
    boolean overload();

}
