package com.siwanper.organization.rest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.siwanper.core.entity.vo.Result;
import com.siwanper.organization.entity.form.UserForm;
import com.siwanper.organization.entity.form.UserQueryForm;
import com.siwanper.organization.entity.form.UserUpdateForm;
import com.siwanper.organization.entity.param.UserQueryParam;
import com.siwanper.organization.entity.po.User;
import com.siwanper.organization.entity.vo.UserVo;
import com.siwanper.organization.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "添加用户")
    @ApiImplicitParam(name = "userForm", value = "用户表单信息", required = true , dataType = "UserForm")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result addUser(@Valid @RequestBody UserForm userForm){
        User user = userForm.toPo(User.class);
        log.info("user : {}",user);
        return Result.success(userService.add(user));
    }

    @ApiOperation(value = "根据用户ID删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path", dataType = "string")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public Result deleteUser(@PathVariable String id){
        boolean result = userService.delete(id);
        return Result.success(result);
    }

    @ApiOperation(value = "更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "string"),
            @ApiImplicitParam(name = "userUpdateForm", value = "用户信息", required = true, dataType = "UserUpdateForm")
    })
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Result updateUser(@PathVariable String id, @Valid @RequestBody UserUpdateForm userUpdateForm){
        User user = userUpdateForm.toPo(User.class);
        user.setId(id);
        boolean result = userService.update(user);
        return Result.success(result);
    }

    @ApiOperation(value = "根据用户ID获取用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path", dataType = "string")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getUser(@PathVariable String id){
        log.info(id);
        UserVo user = userService.get(id);
        return Result.success(user);
    }

    @ApiOperation(value = "搜索用户")
    @ApiImplicitParam(name = "userQueryForm", value = "用户搜索表单信息", required = true , dataType = "UserQueryForm")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result search(@Valid @RequestBody UserQueryForm userQueryForm) {
        IPage<UserVo> users = userService.query(userQueryForm.getPage(), userQueryForm.toParam(UserQueryParam.class));
        return Result.success(users);
    }

}
