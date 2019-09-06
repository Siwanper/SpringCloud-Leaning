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
 * @create 2019-09-06 10:45 AM
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName
public class Menu extends BasePo {

    // 父菜单id
    private long parentId;
    // 菜单类型
    private String type;
    // 菜单路径
    private String href;
    // 菜单图标
    private String icon;
    // 菜单名称
    private String name;
    // 描述
    private String description;
    // 菜单序号
    private long orderNum;

}
