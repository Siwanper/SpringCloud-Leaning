package com.siwanper.organization.entity.form;

import com.siwanper.organization.entity.po.User;
import com.siwanper.web.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * 描述:
 * 添加用户表单
 *
 * @outhor ios
 * @create 2020-04-10 2:36 PM
 */
@Data
@ApiModel
public class UserForm extends BaseForm<User>{

    @ApiModelProperty(value = "用户名")
    @Length(min = 2, max = 20, message = "用户名长度在2～20个字符之间")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "用户密码")
    @Length(min = 6, max = 20, message = "用户密码长度在6～20个字符之间")
    @NotBlank(message = "用户密码不能为空")
    private String password;

    @ApiModelProperty(value = "用户昵称")
    @NotBlank(message = "用户昵称不能为空")
    private String name;

    @ApiModelProperty(value = "用户手机号")
    @NotBlank(message = "用户手机号不能为空")
    private String mobile;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "用户状态是否能用， true可用")
    private Boolean enabled = true;

    @ApiModelProperty(value = "用户状态是否过期， true未过期")
    private Boolean accountNonExpired = true;

    @ApiModelProperty(value = "用户凭证是否过期， true未过期")
    private Boolean credentialsNonExpired = true;

    @ApiModelProperty(value = "用户是否被锁定， true未锁定")
    private Boolean accountNonLocked = true;

    @ApiModelProperty(value = "用户所拥有的角色")
    private Set<String> roleIds;

}
