package com.siwanper.organization.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.siwanper.web.entity.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DESCRIPTION：   角色
 *
 * @ProjectName: cloud
 * @Package: com.siwanper.organization.entity.po
 * @Author: Siwanper
 * @CreateDate: 2020/4/14 下午10:03
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2020</p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "roles")
public class Role extends BasePo {

    private String code;
    private String name;
    private String description;

}
