package com.siwanper.gateway.admin.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siwanper.gateway.admin.config.BusConfig;
import com.siwanper.gateway.admin.dao.GatewayRouteMapper;
import com.siwanper.gateway.admin.entity.param.GatewayRouteQueryParam;
import com.siwanper.gateway.admin.entity.po.GatewayRoute;
import com.siwanper.gateway.admin.entity.vo.GatewayRouteVo;
import com.siwanper.gateway.admin.events.EventSender;
import com.siwanper.gateway.admin.service.IGatewayRouteService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述:
 * 网关路由服务
 *
 * @outhor ios
 * @create 2020-05-11 3:42 PM
 */
@Slf4j
@Service
public class GatewayRouteService extends ServiceImpl<GatewayRouteMapper, GatewayRoute> implements IGatewayRouteService {

    private static final String GATEWAY_ROUTES = "gateway_routes::";

    @Autowired
    private EventSender eventSender;

    @CreateCache(name = GATEWAY_ROUTES, cacheType = CacheType.REMOTE)
    private Cache<String, RouteDefinition> gatewayRouteCache;

    @Override
    public boolean add(GatewayRoute gatewayRoute) {
        RouteDefinition routeDefinition = gatewayRouteToRouteDefinition(gatewayRoute);
        gatewayRouteCache.put(gatewayRoute.getRouteId(),routeDefinition);
        eventSender.send(BusConfig.ROUTING_KEY, routeDefinition);
        return this.save(gatewayRoute);
    }

    @Override
    public boolean delete(String id) {
        GatewayRoute gatewayRoute = this.getById(id);
        gatewayRouteCache.remove(gatewayRoute.getRouteId());
        eventSender.send(BusConfig.ROUTING_KEY_DELETE, gatewayRoute.getRouteId());
        return this.removeById(id);
    }

    @Override
    public boolean update(GatewayRoute gatewayRoute) {
        RouteDefinition routeDefinition = gatewayRouteToRouteDefinition(gatewayRoute);
        gatewayRouteCache.put(gatewayRoute.getRouteId(),routeDefinition);
        eventSender.send(BusConfig.ROUTING_KEY, routeDefinition);
        return this.updateById(gatewayRoute);
    }

    @Override
    public GatewayRoute get(String id) {
        return this.getById(id);
    }

    @Override
    public List<GatewayRouteVo> query(GatewayRouteQueryParam queryParam) {
        QueryWrapper<GatewayRoute> queryWrapper = queryParam.build();
        queryWrapper.eq(StringUtils.isNotBlank(queryParam.getUri()), "uri", queryParam.getUri());
        List<GatewayRoute> list = this.list(queryWrapper);
        return list.stream().map(GatewayRouteVo::new).collect(Collectors.toList());
    }

    @Override
    @PostConstruct // 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行，init（）方法之前执行
    public boolean overload() {
        List<GatewayRoute> list = this.list(new QueryWrapper<>());
        list.forEach(gatewayRoute ->
            gatewayRouteCache.put(gatewayRoute.getRouteId(), gatewayRouteToRouteDefinition(gatewayRoute))
        );
        log.debug("全剧初始化路由配置成功 : {}", gatewayRouteCache.toString());
        return false;
    }

    private RouteDefinition gatewayRouteToRouteDefinition(GatewayRoute gatewayRoute){
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setId(gatewayRoute.getRouteId());
        routeDefinition.setOrder(gatewayRoute.getOrders());
        routeDefinition.setUri(URI.create(gatewayRoute.getUri()));

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            routeDefinition.setPredicates(objectMapper.readValue(gatewayRoute.getPredicates(), new TypeReference<List<PredicateDefinition>>(){}));
            routeDefinition.setFilters(objectMapper.readValue(gatewayRoute.getFilters(), new TypeReference<List<FilterDefinition>>(){}));
        } catch (IOException e) {
            e.printStackTrace();
            log.error("网关路由转换失败：{}",gatewayRoute);
        }

        return routeDefinition;
    }


}
