package com.siwanper.organization.entity.form;

import com.siwanper.organization.entity.po.Resource;
import com.siwanper.web.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 描述:
 * 资源表单
 *
 * @outhor ios
 * @create 2020-04-17 11:18 AM
 */
@ApiModel(value = "资源信息")
@Data
public class ResourceForm extends BaseForm<Resource> {

    @ApiModelProperty(value = "资源编码")
    @NotBlank(message = "资源编码不能为空")
    private String code;

    @ApiModelProperty(value = "资源类型")
    @NotBlank(message = "资源类型不能为空")
    private String type;

    @ApiModelProperty(value = "资源名")
    @NotBlank(message = "资源名不能为空")
    private String name;

    @ApiModelProperty(value = "资源链接")
    @NotBlank(message = "资源链接不能为空")
    private String url;

    @ApiModelProperty(value = "资源方法")
    @NotBlank(message = "资源方法不能为空")
    private String method;

    @ApiModelProperty(value = "资源简介")
    private String description;

}
