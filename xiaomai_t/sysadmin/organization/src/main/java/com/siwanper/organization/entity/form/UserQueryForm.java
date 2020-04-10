package com.siwanper.organization.entity.form;

import com.siwanper.organization.entity.param.UserQueryParam;
import com.siwanper.web.entity.form.BaseQueryForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * 描述: 用户条件查询信息，分页查询
 *
 * @outhor ios
 * @create 2020-04-10 3:01 PM
 */
@Api
@Data
public class UserQueryForm extends BaseQueryForm<UserQueryParam> {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户昵称")
    private String name;

    @ApiModelProperty(value = "用户手机号")
    private String mobile;

    @ApiModelProperty(value = "查询的开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Past(message = "查询的开始时间必须小于当前时间")
    private Date createdTimeStart;

    @ApiModelProperty(value = "查询的结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Past(message = "查询的结束时间必须小于当前时间")
    private Date createdTimeEnd;

}
