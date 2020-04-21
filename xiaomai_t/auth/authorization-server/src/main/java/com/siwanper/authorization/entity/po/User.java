package com.siwanper.authorization.entity.po;

import com.siwanper.web.entity.po.BasePo;
import lombok.Data;

/**
 * 描述:
 * 用户信息
 *
 * @outhor ios
 * @create 2020-04-21 2:57 PM
 */
@Data
public class User extends BasePo{

    private String username;
    private String password;
    private String name;
    private String mobile;

    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean credentialsNonExpired;
    private Boolean accountNonLocked;

}
