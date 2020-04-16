package com.siwanper.organization.entity.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.siwanper.organization.entity.param.UserQueryParam;
import com.siwanper.web.entity.form.BaseQueryForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
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
@ApiModel
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
    // 请求数据格式为： 'yyyy-MM-dd HH:mm:ss',但是在接收到数据的时候，需要通过jackson把数据转化成Dto对象。jackson转化的时候，默认的时间格式是 'yyyy-MM-dd'T'HH:mm:ss.SSS’,所以就会出现异常
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Past(message = "查询的开始时间必须小于当前时间")
    private Date createdStartTime;

    @ApiModelProperty(value = "查询的结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Past(message = "查询的结束时间必须小于当前时间")
    private Date createdEndTime;

}
