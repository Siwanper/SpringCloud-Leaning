package com.swp.cloud.sysadmin.organization.entity.form;

import com.swp.cloud.common.web.entity.form.BaseForm;
import com.swp.cloud.sysadmin.organization.entity.po.Position;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 描述: 岗位表单
 *
 * @outhor ios
 * @create 2019-09-06 2:12 PM
 */
@ApiModel
@Data
public class PositionForm extends BaseForm<Position> {

    @NotBlank(message = "岗位名不能为空")
    @ApiModelProperty("岗位名")
    private String name;
    @ApiModelProperty("岗位简介")
    private String description;

}
