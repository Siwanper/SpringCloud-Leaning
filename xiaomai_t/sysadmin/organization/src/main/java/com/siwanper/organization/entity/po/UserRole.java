package com.siwanper.organization.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.siwanper.web.entity.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 * 用户和角色关系对象
 *
 * @outhor ios
 * @create 2020-04-16 2:47 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user_role_relation")
public class UserRole extends BasePo {

    private String userId;
    private String roleId;

}
