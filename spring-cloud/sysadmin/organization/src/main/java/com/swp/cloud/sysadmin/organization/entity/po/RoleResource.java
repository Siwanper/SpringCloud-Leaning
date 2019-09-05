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
 * @create 2019-09-05 4:18 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("roles_resources_relation")
public class RoleResource extends BasePo{

    private long roleId;
    private long resourceId;

}
