package com.swp.cloud.sysadmin.organization.entity.form;

import com.swp.cloud.common.web.entity.form.BaseForm;
import com.swp.cloud.sysadmin.organization.entity.po.Menu;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 描述: 菜单表单
 *
 * @outhor ios
 * @create 2019-09-06 2:47 PM
 */
@ApiModel
@Data
public class MenuForm extends BaseForm<Menu> {

    @NotBlank(message = "菜单父Id不能为空")
    @ApiModelProperty("菜单父Id")
    private long parentId;

    @NotBlank(message = "菜单类型不能为空")
    @ApiModelProperty("菜单类型")
    private String type;

    @NotBlank(message = "菜单路径不能为空")
    @ApiModelProperty("菜单路径")
    private String href;

    @NotBlank(message = "菜单图标不能为空")
    @ApiModelProperty("菜单图标")
    private String icon;

    @NotBlank(message = "菜单名称不能为空")
    @ApiModelProperty("菜单名称")
    private String name;

    @NotBlank(message = "菜单序号不能为空")
    @ApiModelProperty("菜单序号")
    private long orderNum;

    @ApiModelProperty("菜单描述")
    private String description;


}
