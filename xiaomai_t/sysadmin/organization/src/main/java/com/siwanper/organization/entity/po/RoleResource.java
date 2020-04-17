package com.siwanper.organization.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.siwanper.web.entity.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 * 角色和资源关系
 *
 * @outhor ios
 * @create 2020-04-17 2:19 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "role_resource_relation")
public class RoleResource extends BasePo {

    private String roleId;
    private String resourceId;

}
