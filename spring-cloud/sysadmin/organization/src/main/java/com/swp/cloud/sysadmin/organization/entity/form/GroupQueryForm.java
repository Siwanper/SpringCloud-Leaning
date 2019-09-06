package com.swp.cloud.sysadmin.organization.entity.form;

import com.swp.cloud.common.web.entity.form.BaseQueryForm;
import com.swp.cloud.sysadmin.organization.entity.param.GroupQueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-06 11:15 AM
 */
@ApiModel
@Data
public class GroupQueryForm extends BaseQueryForm<GroupQueryParam> {

    @NotBlank(message = "用户组名不能为空")
    @ApiModelProperty("用户组名")
    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "查询开始时间必须小于当前日期")
    @ApiModelProperty(value = "查询开始时间")
    private Date createdTimeStart;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "查询结束时间必须小于当前日期")
    @ApiModelProperty(value = "查询结束时间")
    private Date createdTimeEnd;
}
