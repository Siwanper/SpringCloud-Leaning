package com.swp.cloud.authorizationserver.entity;

import com.swp.cloud.common.core.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-26 10:39 AM
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Role extends BasePo {

    // 角色code
    private String code;
    // 角色名称
    private String name;
    // 简介
    private String description;

}
