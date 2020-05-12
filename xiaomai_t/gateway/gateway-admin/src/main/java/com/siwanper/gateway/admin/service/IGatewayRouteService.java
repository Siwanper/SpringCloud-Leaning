package com.siwanper.gateway.admin.service;

import com.siwanper.gateway.admin.entity.param.GatewayRouteQueryParam;
import com.siwanper.gateway.admin.entity.po.GatewayRoute;
import com.siwanper.gateway.admin.entity.vo.GatewayRouteVo;

import java.util.List;

public interface IGatewayRouteService {

    /**
     * 添加网关路由
     * @param gatewayRoute
     * @return
     */
    boolean add(GatewayRoute gatewayRoute);

    /**
     * 删除网关路由
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * 更新网关路由
     * @param gatewayRoute
     * @return
     */
    boolean update(GatewayRoute gatewayRoute);

    /**
     * 根据ID获取网关路由
     * @param id
     * @return
     */
    GatewayRoute get(String id);

    /**
     * 根据条件查询
     * @param queryParam
     * @return
     */
    List<GatewayRouteVo> query(GatewayRouteQueryParam queryParam);

    /**
     * 加载所有的路由网关配置到redis
     * @return
     */
    boolean overload();

}
