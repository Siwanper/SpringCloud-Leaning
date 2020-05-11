package com.siwanper.gateway.admin.entity.form;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siwanper.gateway.admin.entity.po.FilterDefinition;
import com.siwanper.gateway.admin.entity.po.GatewayRoute;
import com.siwanper.gateway.admin.entity.po.PredicateDefiniton;
import com.siwanper.web.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-05-11 5:00 PM
 */
@ApiModel("更新路由网关")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GatewayRouteUpdateForm extends BaseForm<GatewayRoute> {

    @ApiModelProperty(name = "路由id", required = true)
    private String routeId;

    @ApiModelProperty(name = "目标服务地址", required = true, example = "lb://service_name:pore")
    private String uri;

    @ApiModelProperty(name = "断言", required = true, example = "[{\"name\":\"Path\",\"args\":{\"pattern\":\"/authentication-server/**\"}}]")
    private List<PredicateDefiniton> predicates;

    @ApiModelProperty(name = "过滤器", example = "[{\"name\":\"StripPrefix\",\"args\":{\"parts\":\"1\"}}]")
    private List<FilterDefinition> filters;

    @ApiModelProperty(name = "排序")
    private Integer orders = 0;

    @ApiModelProperty(name = "描述")
    private String description;

    @ApiModelProperty(name = "状态")
    private String status;

    @Override
    public GatewayRoute toPo(Class<GatewayRoute> clazz) {
        GatewayRoute gatewayRoute = BeanUtils.instantiateClass(clazz);
        BeanUtils.copyProperties(this, gatewayRoute);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            gatewayRoute.setPredicates(objectMapper.writeValueAsString(this.predicates));
            gatewayRoute.setFilters(objectMapper.writeValueAsString(this.filters));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return gatewayRoute;
    }

}
