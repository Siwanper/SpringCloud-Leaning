package com.siwanper.organization.rest;

import com.siwanper.core.entity.vo.Result;
import com.siwanper.organization.entity.po.User;
import com.siwanper.organization.entity.vo.UserVo;
import com.siwanper.organization.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * 用户控制器
 *
 * @outhor ios
 * @create 2020-04-08 4:45 PM
 */
@Api("用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "根据用户ID获取用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path", dataType = "string")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getUser(@PathVariable String id){
        UserVo user = userService.get(id);
        return Result.success(user);
    }

}
