package com.siwanper.organization.entity.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.siwanper.organization.entity.param.RoleQueryParam;
import com.siwanper.web.entity.form.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * 描述:
 * 条件查询角色
 *
 * @outhor ios
 * @create 2020-04-16 11:55 AM
 */
@ApiModel(value = "角色查询条件")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleQueryForm extends BaseQueryForm<RoleQueryParam> {

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "角色编码")
    private String code;

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
