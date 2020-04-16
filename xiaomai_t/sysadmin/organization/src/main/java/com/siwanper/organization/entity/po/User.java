package com.siwanper.organization.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.siwanper.web.entity.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * 描述:
 * 用户
 *
 * @outhor ios
 * @create 2020-04-08 4:16 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "users")
public class User extends BasePo {

    private String username;
    private String password;
    private String name;
    private String mobile;
    private String description;
    // 逻辑删除
    @TableLogic
    private String deleted = "N";
    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean credentialsNonExpired;
    private Boolean accountNonLocked;
    // 数据库中不包含roleIds字段
    // 请求的JSON数据中  {"roleIds":[1250692416581328898,1250692694332334082]}
    @TableField(exist = false)
    private Set<String> roleIds;

}
