package com.swp.cloud.sysadmin.organization.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.swp.cloud.common.core.entity.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-05 2:09 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
