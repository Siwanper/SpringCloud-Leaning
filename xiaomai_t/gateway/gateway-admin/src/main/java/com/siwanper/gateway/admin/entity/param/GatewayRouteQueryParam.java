package com.siwanper.gateway.admin.entity.param;

import com.siwanper.gateway.admin.entity.po.GatewayRoute;
import com.siwanper.web.entity.param.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-05-11 4:58 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GatewayRouteQueryParam extends BaseParam<GatewayRoute> {
    private String uri;
}
