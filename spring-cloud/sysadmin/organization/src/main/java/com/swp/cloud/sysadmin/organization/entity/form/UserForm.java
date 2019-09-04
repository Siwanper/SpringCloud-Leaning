package com.swp.cloud.sysadmin.organization.entity.form;

import com.swp.cloud.common.web.entity.form.BaseForm;
import com.swp.cloud.sysadmin.organization.entity.po.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-04 3:38 PM
 */
@ApiModel
@Data
public class UserForm extends BaseForm<User> {

    // 用户名
    @ApiModelProperty(value = "用户名")
    @NotBlank(message = "用户名不能为空")
    @Length(min = 3, max = 20, message = "用户名长度在3到20个字符")
    private String username;
    // 密码
    @ApiModelProperty(value = "密码")
    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 20, message = "密码长度在6到20个字符")
    private String password;
    // 姓名
    @ApiModelProperty(value = "姓名")
    @NotBlank(message = "用户姓名不能为空")
    private String name;
    // 电话
    @ApiModelProperty(value = "电话")
    @NotBlank(message = "用户电话不能为空")
    private String mobile;
    // 简介
    @ApiModelProperty(value = "用户简介")
    private String description;
    // 是否已删除 Y：已删除，N：未删除
    @ApiModelProperty(value = "用户是否删除，Y：已删除")
    private String deleted = "N";
    // 是否有效用户
    @ApiModelProperty(value = "用户是否有效，true：有效")
    private Boolean enabled = true;
    // 账号是否未过期
    @ApiModelProperty(value = "账号是否过期，true：未过期")
    private Boolean account_non_expired = true;
    // 密码是否未过期
    @ApiModelProperty(value = "密码是否过期，true：未过期")
    private Boolean credentials_non_expired = true;
    // 是否未锁定
    @ApiModelProperty(value = "账号是否锁定，true：未锁定")
    private Boolean account_non_locked = true;

}
