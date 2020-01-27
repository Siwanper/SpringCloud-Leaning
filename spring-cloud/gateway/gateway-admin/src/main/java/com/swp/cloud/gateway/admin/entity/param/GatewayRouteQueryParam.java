package com.swp.cloud.gateway.admin.entity.param;

import com.swp.cloud.common.core.entity.param.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-11-14 3:20 PM
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GatewayRouteQueryParam extends BaseParam {
    public GatewayRouteQueryParam(String uri) {
        this.uri = uri;
    }
    private String uri;
    private Date createdTimeStart;
    private Date createdTimeEnd;
}
