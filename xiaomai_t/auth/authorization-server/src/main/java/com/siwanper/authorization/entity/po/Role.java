package com.siwanper.authorization.entity.po;

import com.siwanper.web.entity.po.BasePo;
import lombok.Data;

/**
 * 描述:
 * 角色
 *
 * @outhor ios
 * @create 2020-04-21 4:04 PM
 */
@Data
public class Role extends BasePo {

    private String code;
    private String name;

}
