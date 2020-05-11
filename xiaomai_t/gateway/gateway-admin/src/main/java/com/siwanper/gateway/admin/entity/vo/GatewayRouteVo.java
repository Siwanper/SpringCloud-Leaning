package com.siwanper.gateway.admin.entity.vo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siwanper.gateway.admin.entity.po.FilterDefinition;
import com.siwanper.gateway.admin.entity.po.GatewayRoute;
import com.siwanper.gateway.admin.entity.po.PredicateDefiniton;
import com.siwanper.web.entity.vo.BaseVo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-05-11 4:45 PM
 */
@Data
public class GatewayRouteVo extends BaseVo<GatewayRoute> {

    private String id;
    private String routeId;
    private String uri;
    private List<PredicateDefiniton> predicates;
    private List<FilterDefinition> filters;
    private Integer orders;
    private String description;
    private String status;
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;

    public GatewayRouteVo(GatewayRoute gatewayRoute){
        BeanUtils.copyProperties(gatewayRoute, this);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.setPredicates(objectMapper.readValue(gatewayRoute.getPredicates(), new TypeReference<List<PredicateDefiniton>>(){}));
            this.setFilters(objectMapper.readValue(gatewayRoute.getFilters(), new TypeReference<List<FilterDefinition>>(){}));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
