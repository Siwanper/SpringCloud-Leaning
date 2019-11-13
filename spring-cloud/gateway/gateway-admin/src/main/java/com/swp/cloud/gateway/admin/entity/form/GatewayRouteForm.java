package com.swp.cloud.gateway.admin.entity.form;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swp.cloud.common.web.entity.form.BaseForm;
import com.swp.cloud.gateway.admin.entity.po.FilterDefinition;
import com.swp.cloud.gateway.admin.entity.po.GatewayRoute;
import com.swp.cloud.gateway.admin.entity.po.PredicateDefinition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-11-13 6:26 PM
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel
@Data
@Slf4j
public class GatewayRouteForm extends BaseForm<GatewayRoute> {

    @NotBlank(message = "断言不能为空")
    @ApiModelProperty(value = "网关断言")
    private List<PredicateDefinition> predicates = new ArrayList<>();

    @ApiModelProperty(value = "网关过滤器")
    private List<FilterDefinition> filters = new ArrayList<>();

    @NotBlank(message = "网关路由不能为空")
    @ApiModelProperty(value = "网关路由ID")
    private String routeId;

    @NotBlank(message = "网关uri不能为空")
    @ApiModelProperty(value = "网关uri")
    private String uri;

    @ApiModelProperty(value = "网关控制顺序")
    private Integer orders = 0;

    @ApiModelProperty(value = "网关描述")
    private String description;

    @Override
    public GatewayRoute toPo(Class<GatewayRoute> clazz) {
        GatewayRoute gatewayRoute = new GatewayRoute();
        BeanUtils.copyProperties(this, gatewayRoute);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            gatewayRoute.setPredicates(objectMapper.writeValueAsString(this.getPredicates()));
            gatewayRoute.setFilters(objectMapper.writeValueAsString(this.getFilters()));
        } catch (JsonProcessingException e) {
            log.error("网关filter或predicates配置转换异常", e);
        }
        return gatewayRoute;
    }
}
