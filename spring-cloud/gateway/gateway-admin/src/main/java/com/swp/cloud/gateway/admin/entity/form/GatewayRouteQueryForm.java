package com.swp.cloud.gateway.admin.entity.form;

import com.swp.cloud.common.web.entity.form.BaseQueryForm;
import com.swp.cloud.gateway.admin.entity.param.GatewayRouteQueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-11-14 3:23 PM
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel
@Data
public class GatewayRouteQueryForm extends BaseQueryForm<GatewayRouteQueryParam> {
    @ApiModelProperty(value = "网关路径", required = true)
    private String uri;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "查询开始时间必须小于当前时间")
    @ApiModelProperty(value = "查询开始时间")
    private Date createdTimeStart;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "查询结束时间必须小于当前时间")
    @ApiModelProperty(value = "查询结束时间")
    private Date createdTimeEnd;

}
