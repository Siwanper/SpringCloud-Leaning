package com.siwanper.organization.entity.form;

import com.siwanper.organization.entity.po.Resource;
import com.siwanper.web.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述:
 * 更新资源信息
 *
 * @outhor ios
 * @create 2020-04-17 11:40 AM
 */
@ApiModel(value = "更新资源信息")
@Data
public class ResourceUpdateForm extends BaseForm<Resource> {

    @ApiModelProperty(value = "资源编码")
    private String code;

    @ApiModelProperty(value = "资源类型")
    private String type;

    @ApiModelProperty(value = "资源名")
    private String name;

    @ApiModelProperty(value = "资源链接")
    private String url;

    @ApiModelProperty(value = "资源方法")
    private String method;

    @ApiModelProperty(value = "资源简介")
    private String description;

}
