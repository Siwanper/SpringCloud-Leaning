package com.swp.cloud.gateway.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swp.cloud.gateway.admin.dao.GatewayRouteMapper;
import com.swp.cloud.gateway.admin.entity.param.GatewayRouteQueryParam;
import com.swp.cloud.gateway.admin.entity.po.GatewayRoute;
import com.swp.cloud.gateway.admin.entity.vo.GatewayRouteVo;
import com.swp.cloud.gateway.admin.service.IGatewayRouteService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-11-13 4:56 PM
 */
@Service
@Slf4j
public class GatewayRouteServiceImpl implements IGatewayRouteService {

    private static final String GATEWAY_ROUTES = "gateway_routes::";
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
    public void delete(long id) {
        mapper.deleteById(id);
        redisTemplate.delete(GATEWAY_ROUTES + id);
    }

    @Override
    public void update(GatewayRoute gatewayRoute) {
        mapper.updateById(gatewayRoute);
        redisTemplate.delete(GATEWAY_ROUTES + gatewayRoute.getId());
        redisTemplate.opsForValue().set(GATEWAY_ROUTES + gatewayRoute.getId(), toJson(new GatewayRouteVo(get(gatewayRoute.getId()))));
    }

    @Override
    public GatewayRoute get(long id) {
        return mapper.selectById(id);
    }

    @Override
    public List<GatewayRoute> query(GatewayRouteQueryParam gatewayRouteQueryParam) {
        QueryWrapper<GatewayRoute> wrapper = new QueryWrapper<>();
        wrapper.ge(null != gatewayRouteQueryParam.getCreatedTimeStart(), "created_time", gatewayRouteQueryParam.getCreatedTimeStart());
        wrapper.le(null != gatewayRouteQueryParam.getCreatedTimeEnd(), "created_time", gatewayRouteQueryParam.getCreatedTimeEnd());
        wrapper.eq(StringUtils.isNotBlank(gatewayRouteQueryParam.getUri()), "uri", gatewayRouteQueryParam.getUri());
        return mapper.selectList(wrapper);
    }

    @Override
    public boolean overload() {
        List<GatewayRoute> gatewayRoutes = mapper.selectList(new QueryWrapper<>());
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        for (GatewayRoute route : gatewayRoutes) {
            opsForValue.set(GATEWAY_ROUTES + route.getId(), toJson(new GatewayRouteVo(route)));
        }
        return true;
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
