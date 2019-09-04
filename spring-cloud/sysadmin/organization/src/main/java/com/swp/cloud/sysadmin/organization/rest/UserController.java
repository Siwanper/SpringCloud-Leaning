package com.swp.cloud.sysadmin.organization.rest;

import com.swp.cloud.common.core.entity.vo.Result;
import com.swp.cloud.sysadmin.organization.entity.form.UserForm;
import com.swp.cloud.sysadmin.organization.entity.form.UserQueryForm;
import com.swp.cloud.sysadmin.organization.entity.param.UserQueryParam;
import com.swp.cloud.sysadmin.organization.entity.po.User;
import com.swp.cloud.sysadmin.organization.service.IUserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-04 10:59 AM
 */
@RestController
@RequestMapping("/user")
@Api("user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "添加用户", notes = "添加用户")
    @ApiImplicitParam(name = "userForm", value = "用户表单信息", dataType = "UserForm", required = true)
    @PostMapping
    public Result add(@Valid @RequestBody UserForm userForm) {
        log.debug("user: {}", userForm);
        User user = userForm.toPo(User.class);
        return Result.success(userService.add(user));
    }

    @ApiOperation(value = "删除用户", notes = "根据用户ID删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", dataType = "long", required = true, paramType = "path")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable long id){
        log.debug("delete user id:{}",id);
        userService.delete(id);
        return Result.success();
    }

    @ApiOperation(value = "更新用户", notes = "根据用户ID更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", dataType = "long", required = true, paramType = "path"),
            @ApiImplicitParam(name = "userForm", value = "用户信息", dataType = "UserForm", required = true)})
    @PutMapping("/{id}")
    public Result update(@PathVariable long id, @Valid @RequestBody UserForm userForm) {
        log.debug("update user id:{}, userForm:{}", id, userForm);
        User user = userForm.toPo(User.class);
        user.setId(id);
        userService.update(user);
        return Result.success();
    }

    @ApiOperation(value = "获取用户", notes = "根据用户ID获取用户")
    @ApiImplicitParam(name = "id", value = "用户ID", dataType = "long", required = true, paramType = "path")
    @GetMapping("/{id}")
    public Result get(@PathVariable long id){
        return Result.success(userService.get(id));
    }

    @ApiOperation(value = "获取用户", notes = "根据用户的用户名或者电话号码获取用户")
    @ApiImplicitParam(name = "unique", value = "用户名或者电话号码", dataType = "String", required = true, paramType = "query")
    @ApiResponses({@ApiResponse(code = 200, message = "处理成功", response = Result.class)})
    @GetMapping
    public Result query(@RequestParam String unique){
        log.debug("uniqueId:{}", unique);
        return Result.success(userService.getUnique(unique));
    }

    @ApiOperation(value = "搜索用户", notes = "根据条件搜索用户")
    @ApiImplicitParam(name = "userQueryForm", value = "搜索的用户条件", dataType = "UserQueryForm", required = true)
    @ApiResponses({@ApiResponse(code = 200, message = "处理成功", response = Result.class)})
    @PostMapping("/conditions")
    public Result search(@Valid @RequestBody UserQueryForm userQueryForm) {
        log.debug("search user conditions:{}",userQueryForm);
        return Result.success(userService.query(userQueryForm.getPage(), userQueryForm.toParam(UserQueryParam.class)));

    }

}
