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
 * @create 2019-09-05 2:54 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_role_relation")
public class UserRole extends BasePo{

    private long userId;
    private long roleId;
}
