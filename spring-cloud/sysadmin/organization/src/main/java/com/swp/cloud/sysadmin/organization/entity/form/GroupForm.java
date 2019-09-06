package com.swp.cloud.sysadmin.organization.entity.form;

import com.swp.cloud.common.web.entity.form.BaseForm;
import com.swp.cloud.sysadmin.organization.entity.po.Group;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-06 11:10 AM
 */
@ApiModel
@Data
public class GroupForm extends BaseForm<Group> {

    @NotBlank(message = "用户组父Id不能为空")
    @ApiModelProperty("用户组父Id")
    private long parentId;
    @NotBlank(message = "用户组名不能为空")
    @ApiModelProperty("用户组名")
    private String name;
    @ApiModelProperty("用户组简介")
    private String description;

}
