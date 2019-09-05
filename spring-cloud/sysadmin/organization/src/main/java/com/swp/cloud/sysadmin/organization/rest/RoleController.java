package com.swp.cloud.sysadmin.organization.rest;

import com.swp.cloud.common.core.entity.vo.Result;
import com.swp.cloud.sysadmin.organization.entity.form.RoleForm;
import com.swp.cloud.sysadmin.organization.entity.form.RoleQueryForm;
import com.swp.cloud.sysadmin.organization.entity.param.RoleQueryParam;
import com.swp.cloud.sysadmin.organization.entity.po.Role;
import com.swp.cloud.sysadmin.organization.service.impl.RoleService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-05 3:11 PM
 */
@RestController
@RequestMapping("/role")
@Api("role")
@Slf4j
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "添加角色", notes = "添加角色信息")
    @ApiImplicitParam(name = "roleForm", value = "角色信息", required = true, dataType = "RoleForm")
    @PostMapping
    public Result add(@Valid @RequestBody RoleForm roleForm){
        log.debug("add role:{}",roleForm);
        Role role = roleForm.toPo(Role.class);
        return Result.success(roleService.add(role));
    }

    @ApiOperation(value = "删除角色", notes = "根据角色ID删除角色")
    @ApiImplicitParam(name = "id", value = "角色ID", dataType = "long", required = true, paramType = "path")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable long id){
        log.debug("delete role id:{}",id);
        roleService.delete(id);
        return Result.success();
    }

    @ApiOperation(value = "更新角色", notes = "根据角色ID更新角色信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色ID", dataType = "long", required = true, paramType = "path"),
            @ApiImplicitParam(name = "roleForm", value = "角色信息", dataType = "RoleForm", required = true)})
    @PutMapping("/{id}")
    public Result update(@PathVariable long id, @Valid @RequestBody RoleForm roleForm) {
        log.debug("update role id:{}, roleForm:{}", id, roleForm);
        Role role = roleForm.toPo(Role.class);
        role.setId(id);
        roleService.update(role);
        return Result.success();
    }

    @ApiOperation(value = "获取角色", notes = "根据角色Id获取角色")
    @ApiImplicitParam(name = "id", value = "角色Id", required = true, dataType = "long", paramType = "path")
    @GetMapping("/{id}")
    public Role get(@PathVariable long id){
       return roleService.get(id);
    }

    @ApiOperation(value = "搜索角色", notes = "根据条件搜索角色")
    @ApiImplicitParam(name = "roleQueryForm", value = "搜索的角色条件", dataType = "RoleQueryForm", required = true)
    @ApiResponses({@ApiResponse(code = 200, message = "处理成功", response = Result.class)})
    @PostMapping("/conditions")
    public Result search(@Valid @RequestBody RoleQueryForm roleQueryForm) {
        log.debug("search role conditions:{}",roleQueryForm);
        return Result.success(roleService.query(roleQueryForm.getPage(), roleQueryForm.toParam(RoleQueryParam.class)));
    }

    @ApiOperation(value = "获取用户角色", notes = "根据用户ID获取用户的角色")
    @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "long", required = true, paramType = "path")
    @ApiResponses({@ApiResponse(code = 200, message = "处理成功", response = Result.class)})
    @GetMapping("/user/{userId}")
    public Result query(@PathVariable long userId){
        log.debug("userID: {}",userId);
        return Result.success(roleService.query(userId));
    }

}
