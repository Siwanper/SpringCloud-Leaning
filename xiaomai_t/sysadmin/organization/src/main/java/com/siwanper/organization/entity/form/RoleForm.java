package com.siwanper.organization.entity.form;

import com.siwanper.organization.entity.po.Role;
import com.siwanper.web.entity.form.BaseForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.DocFlavor;
import javax.validation.constraints.NotBlank;

/**
 * DESCRIPTION：   添加角色表单信息
 *
 * @ProjectName: cloud
 * @Package: com.siwanper.organization.entity.form
 * @Author: Siwanper
 * @CreateDate: 2020/4/14 下午10:55
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2020</p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "角色")
public class RoleForm extends BaseForm<Role> {

    @NotBlank(message = "角色编码不能为空")
    @ApiModelProperty(value = "角色编码")
    private String code;

    @NotBlank(message = "角色名不能为空")
    @ApiModelProperty(value = "角色名")
    private String name;

    @ApiModelProperty(value = "角色描述")
    private String description;

}
