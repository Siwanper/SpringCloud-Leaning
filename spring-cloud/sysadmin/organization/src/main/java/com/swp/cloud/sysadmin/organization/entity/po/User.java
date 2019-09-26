package com.swp.cloud.sysadmin.organization.entity.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.swp.cloud.common.core.entity.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 * 用户表
 *
 * @outhor ios
 * @create 2019-09-04 10:25 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User extends BasePo{

    // 用户名
    private String username;
    // 密码
    private String password;
    // 姓名
    private String name;
    // 电话
    private String mobile;
    // 简介
    private String description;
    // 是否已删除 Y：已删除，N：未删除
    // 在字段上加上这个注解再执行BaseMapper的删除方法时，删除方法会变成修改
    @TableLogic
    private String deleted = "N";
    // 是否有效用户
    private Boolean enabled;
    // 账号是否未过期
    private Boolean accountNonExpired;
    // 密码是否未过期
    private Boolean credentialsNonExpired;
    // 是否未锁定
    private Boolean accountNonLocked;

}
