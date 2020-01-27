package com.swp.cloud.gateway.admin.entity.po;

import com.swp.cloud.common.core.entity.po.BasePo;
import lombok.*;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-11-13 4:35 PM
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GatewayRoute extends BasePo {

    private String routeId;
    private String uri;
    private String predicates;
    private String filters;
    private Integer orders = 0;
    private String description;
    private String status = "Y";

}
