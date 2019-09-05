package com.swp.cloud.sysadmin.organization.entity.form;

import com.swp.cloud.common.web.entity.form.BaseForm;
import com.swp.cloud.sysadmin.organization.entity.po.Resource;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-05 5:04 PM
 */
@ApiModel
@Data
public class ResourceForm extends BaseForm<Resource> {

    @NotBlank(message = "资源code不能为空")
    @ApiModelProperty("资源code")
    private String code;
    @NotBlank(message = "资源类型不能为空")
    @ApiModelProperty("资源类型")
    private String type;
    @NotBlank(message = "资源名称不能为空")
    @ApiModelProperty("资源名称")
    private String name;
    @NotBlank(message = "资源方法不能为空")
    @ApiModelProperty("资源方法")
    private String method;
    @NotBlank(message = "资源url不能为空")
    @ApiModelProperty("资源url")
    private String url;
    @ApiModelProperty("资源简介")
    private String description;

}
