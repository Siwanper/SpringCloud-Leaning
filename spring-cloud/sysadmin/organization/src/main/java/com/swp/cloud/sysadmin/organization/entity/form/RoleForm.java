package com.swp.cloud.sysadmin.organization.entity.form;

import com.swp.cloud.common.web.entity.form.BaseForm;
import com.swp.cloud.sysadmin.organization.entity.po.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-05 3:21 PM
 */
@ApiModel
@Data
public class RoleForm extends BaseForm<Role> {

    @NotBlank(message = "角色code不能为空")
    @ApiModelProperty("角色code")
    private String code;

    @NotBlank(message = "角色名称不能为空")
    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("角色介绍")
    private String description;

}
