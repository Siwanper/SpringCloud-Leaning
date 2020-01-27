package com.swp.cloud.gateway.admin.entity.vo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swp.cloud.common.core.entity.vo.BaseVo;
import com.swp.cloud.gateway.admin.entity.po.FilterDefinition;
import com.swp.cloud.gateway.admin.entity.po.GatewayRoute;
import com.swp.cloud.gateway.admin.entity.po.PredicateDefinition;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-11-13 5:53 PM
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
public class GatewayRouteVo extends BaseVo {

    private long id;
    private String uri;
    private Integer order;
    private List<PredicateDefinition> predicates = new ArrayList<>();
    private List<FilterDefinition> filters = new ArrayList<>();

    public GatewayRouteVo(GatewayRoute gatewayRoute){
        this.id = gatewayRoute.getId();
        this.uri = gatewayRoute.getUri();
        this.order = gatewayRoute.getOrders();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            this.predicates = objectMapper.readValue(gatewayRoute.getPredicates(), new TypeReference<List<PredicateDefinition>>(){
            });
            this.filters = objectMapper.readValue(gatewayRoute.getFilters(), new TypeReference<List<FilterDefinition>>(){
            });
        } catch (IOException e) {
            log.error("网关对象转化失败",e);
        }
    }


}
