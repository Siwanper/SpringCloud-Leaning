package com.swp.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-08-28 3:55 PM
 */
@Data
@Slf4j
@ApiModel(value = "User", description = "用户信息")
public class User {

    @ApiModelProperty(name = "id", value = "用户id", required = true, example = "1")
    private Long id;
    @ApiModelProperty(name = "usename", value = "用户名", required = true, example = "史万鹏")
    private String username;
    @ApiModelProperty(name = "password", value = "用户密码", required = true, example = "123456")
    private String  password;

}
