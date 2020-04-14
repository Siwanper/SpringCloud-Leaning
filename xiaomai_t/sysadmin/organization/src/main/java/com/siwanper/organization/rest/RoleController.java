package com.siwanper.organization.rest;

import com.siwanper.core.entity.vo.Result;
import com.siwanper.organization.entity.form.RoleForm;
import com.siwanper.organization.entity.form.RoleUpdateForm;
import com.siwanper.organization.entity.po.Role;
import com.siwanper.organization.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * DESCRIPTION：   角色控制器
 *
 * @ProjectName: cloud
 * @Package: com.siwanper.organization.rest
 * @Author: Siwanper
 * @CreateDate: 2020/4/14 下午10:10
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2020</p>
 */
@Api(value = "角色api")
@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @ApiOperation(value = "添加角色")
    @ApiImplicitParam(name = "roleForm", value = "角色表单信息", required = true, dataType = "RoleForm")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result addRole(@Valid @RequestBody RoleForm roleForm){
        return Result.success(roleService.add(roleForm.toPo(Role.class)));
    }

    @ApiOperation(value = "根据角色Id删除角色")
    @ApiImplicitParam(name = "id", value = "角色ID", required = true, paramType = "path", dataType = "string")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public Result deleteRole(@PathVariable String id){
        return Result.success(roleService.delete(id));
    }

    @ApiOperation(value = "更新角色信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色id", required = true, paramType = "path", dataType = "string"),
            @ApiImplicitParam(name = "roleUpdateForm", value = "角色信息", required = true, dataType = "RoleUpdateForm")
    })
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Result updateRole(@PathVariable String id,@RequestBody RoleUpdateForm roleUpdateForm){
        Role role = roleUpdateForm.toPo(Role.class);
        role.setId(id);
        return Result.success(roleService.update(role));
    }

    @ApiOperation(value = "根据角色Id查询")
    @ApiImplicitParam(name = "id", value = "角色ID", required = true, paramType = "path", dataType = "string")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getRole(@PathVariable String id){
        return Result.success(roleService.get(id));
    }

}
