package com.siwanper.organization.entity.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.siwanper.organization.entity.param.ResourceQueryParam;
import com.siwanper.web.entity.form.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * 描述:
 * 条件查询资源
 *
 * @outhor ios
 * @create 2020-04-17 11:47 AM
 */
@ApiModel(value = "条件查询资源")
@Data
public class ResourceQueryForm extends BaseQueryForm<ResourceQueryParam> {


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

    @ApiModelProperty(value = "查询开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Past(message = "当前时间必须大于查询开始时间")
    private Date createdStartTime;

    @ApiModelProperty(value = "查询结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Past(message = "当前时间必须大于查询结束时间")
    private Date createdEndTime;

}
