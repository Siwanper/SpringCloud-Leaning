package com.siwanper.organization.entity.param;

import com.siwanper.organization.entity.po.Role;
import com.siwanper.web.entity.param.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述: 角色查询条件，用于service
 *
 * @outhor ios
 * @create 2020-04-16 11:43 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleQueryParam extends BaseParam<Role>{

    private String code;
    private String name;

}
