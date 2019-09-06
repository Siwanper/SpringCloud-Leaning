package com.swp.cloud.sysadmin.organization.entity.form;

import com.swp.cloud.common.web.entity.form.BaseQueryForm;
import com.swp.cloud.sysadmin.organization.entity.param.PositionQueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * 描述: 岗位查询条件表单
 *
 * @outhor ios
 * @create 2019-09-06 2:14 PM
 */
@ApiModel
@Data
public class PositionQueryForm extends BaseQueryForm<PositionQueryParam> {

    @NotBlank(message = "岗位名不能为空")
    @ApiModelProperty("岗位名")
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
