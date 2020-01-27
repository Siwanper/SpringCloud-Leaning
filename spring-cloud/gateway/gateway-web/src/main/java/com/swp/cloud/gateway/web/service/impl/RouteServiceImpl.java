package com.swp.cloud.gateway.web.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swp.cloud.gateway.web.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.*;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-11-18 3:51 PM
 */
@Service
public class RouteServiceImpl implements RouteService {

    private static final String GATEWAY_ROUTES = "gateway_routes::";

    @Autowired
    private StringRedisTemplate redisTemplate;

    private Map<String, RouteDefinition> routeDefinitionMap = new HashMap<>();

    private void loadRouteDefinitions(){
        Set<String> keys = redisTemplate.keys(GATEWAY_ROUTES + "*");

        if (CollectionUtils.isEmpty(keys)) {
            return;
        }

        List<String> gatewayRoutes = Optional.ofNullable(redisTemplate.opsForValue().multiGet(keys)).orElse(new ArrayList<>());
        gatewayRoutes.forEach(value -> {
            ObjectMapper mapper = new ObjectMapper();
            try {
                RouteDefinition routeDefinition = mapper.readValue(value, RouteDefinition.class);
                routeDefinitionMap.put(routeDefinition.getId(), routeDefinition);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        loadRouteDefinitions();
        return Flux.fromIterable(routeDefinitionMap.values());
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> routeDefinitionMono) {
        return routeDefinitionMono.flatMap(routeDefinition -> {
            routeDefinitionMap.put(routeDefinition.getId(), routeDefinition);
            return Mono.empty();
        });
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return routeId.flatMap(id -> {
            routeDefinitionMap.remove(id);
            return Mono.empty();
        });
    }
}
