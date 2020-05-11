package com.siwanper.gateway.admin.entity.po;

import com.siwanper.web.entity.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 * 网关路径
 *
 * @outhor ios
 * @create 2020-05-11 3:31 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GatewayRoute extends BasePo {

    // 路由ID
    private String routeId;
    // 目标服务地址 lb://service_name:pore
    private String uri;
    // 断言
    private String predicates;
    // 过滤器
    private String filters;
    // 排序
    private Integer orders = 0;

    private String description;
    // 状态
    private String status = "Y";

}
