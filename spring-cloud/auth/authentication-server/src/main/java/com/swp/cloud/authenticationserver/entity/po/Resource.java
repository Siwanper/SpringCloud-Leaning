package com.swp.cloud.authenticationserver.entity.po;

import com.swp.cloud.common.core.entity.po.BasePo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-29 11:03 AM
 */
@Data
@NoArgsConstructor
public class Resource extends BasePo {

    // 资源code
    private String code;
    // 资源类型
    private String type;
    // 资源名称
    private String name;
    // 资源方法
    private String method;
    // 简介
    private String description;
    // 资源url
    private String url;

}
