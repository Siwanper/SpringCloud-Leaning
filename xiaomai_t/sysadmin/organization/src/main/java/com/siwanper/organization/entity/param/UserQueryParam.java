package com.siwanper.organization.entity.param;

import com.siwanper.organization.entity.po.User;
import com.siwanper.web.entity.param.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 * 条件查询参数
 *
 * @outhor ios
 * @create 2020-04-10 2:23 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQueryParam extends BaseParam<User> {

    private String username;
    private String name;
    private String mobile;

}
