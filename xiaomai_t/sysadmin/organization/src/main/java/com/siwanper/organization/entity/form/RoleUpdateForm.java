package com.siwanper.organization.entity.form;

import com.siwanper.organization.entity.po.Role;
import com.siwanper.web.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * DESCRIPTION：   修改角色表单
 *
 * @ProjectName: cloud
 * @Package: com.siwanper.organization.entity.form
 * @Author: Siwanper
 * @CreateDate: 2020/4/14 下午11:14
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2020</p>
 */
@Data
@ApiModel(value = "修改角色信息")
public class RoleUpdateForm extends BaseForm<Role> {

    @ApiModelProperty(value = "角色编码")
    private String code;

    @ApiModelProperty(value = "角色名")
    private String name;

    @ApiModelProperty(value = "角色描述")
    private String description;

}
