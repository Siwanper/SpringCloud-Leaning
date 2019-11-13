package com.swp.cloud.gateway.admin.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swp.cloud.gateway.admin.dao.GatewayRouteMapper;
import com.swp.cloud.gateway.admin.entity.po.GatewayRoute;
import com.swp.cloud.gateway.admin.entity.vo.GatewayRouteVo;
import com.swp.cloud.gateway.admin.service.IGatewayRouteService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-11-13 4:56 PM
 */
@Service
@Slf4j
public class GatewayRouteServiceImpl implements IGatewayRouteService {

    private static final String GATEWAY_ROUTES = "gateway_route::";
    @Autowired
    private GatewayRouteMapper mapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public long add(GatewayRoute gatewayRoute) {
        int id = mapper.insert(gatewayRoute);
        redisTemplate.opsForValue().set(GATEWAY_ROUTES + gatewayRoute.getId(), toJson(new GatewayRouteVo(gatewayRoute)));
        return id;
    }

    @Override
    public GatewayRoute get(long id) {
        return mapper.selectById(id);
    }

    private String toJson(GatewayRouteVo gatewayRouteVo){
        String routeDefinitionJson = Strings.EMPTY;
        try {
            routeDefinitionJson = new ObjectMapper().writeValueAsString(gatewayRouteVo);
        } catch (JsonProcessingException e) {
            log.error("网关对象序列号为json String", e.getMessage());
        }
        return routeDefinitionJson;
    }

}
