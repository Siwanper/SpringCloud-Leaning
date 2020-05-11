package com.siwanper.gateway.admin.entity.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.siwanper.gateway.admin.entity.param.GatewayRouteQueryParam;
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
 *
 * @outhor ios
 * @create 2020-05-11 5:01 PM
 */
@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GatewayRouteQueryFrom extends BaseQueryForm<GatewayRouteQueryParam> {

    @ApiModelProperty(value = "uri路径", required = true)
    private String uri;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Past(message = "查询开始时间必须小于当前日期")
    @ApiModelProperty(value = "查询开始时间")
    private Date createdStartTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Past(message = "查询结束时间必须小于当前日期")
    @ApiModelProperty(value = "查询结束时间")
    private Date createdEndTime;

}
