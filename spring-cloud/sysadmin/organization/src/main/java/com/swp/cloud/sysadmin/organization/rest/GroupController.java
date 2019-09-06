package com.swp.cloud.sysadmin.organization.rest;

import com.netflix.discovery.converters.Auto;
import com.swp.cloud.common.core.entity.vo.Result;
import com.swp.cloud.sysadmin.organization.entity.form.GroupForm;
import com.swp.cloud.sysadmin.organization.entity.form.GroupQueryForm;
import com.swp.cloud.sysadmin.organization.entity.param.GroupQueryParam;
import com.swp.cloud.sysadmin.organization.entity.po.Group;
import com.swp.cloud.sysadmin.organization.service.impl.GroupService;
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
 *
 * @outhor ios
 * @create 2019-09-06 11:17 AM
 */
@Api("group")
@Slf4j
@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @ApiOperation(value = "添加用户组", notes = "添加用户组信息")
    @ApiImplicitParam(name = "groupForm" ,value = "用户组表单信息", required = true, dataType = "GroupForm")
    @PostMapping
    public Result add(@Valid @RequestBody GroupForm groupForm){
        log.debug("add group:{}", groupForm);
        Group group = groupForm.toPo(Group.class);
        return Result.success(groupService.add(group));
    }

    @ApiOperation(value = "删除用户组", notes = "根据用户组Id删除用户组")
    @ApiImplicitParam(name = "id", value = "用户组ID", required = true, dataType = "long", paramType = "path" )
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable long id){
        log.debug("delete group:{}",id);
        groupService.delete(id);
        return Result.success();
    }

    @ApiOperation(value = "更新用户组", notes = "根据用户组ID更新用户组信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户组ID", dataType = "long", required = true, paramType = "path"),
            @ApiImplicitParam(name = "groupForm", value = "用户组信息", dataType = "GroupForm", required = true)})
    @PutMapping("/{id}")
    public Result update(@PathVariable long id, @Valid @RequestBody GroupForm groupForm) {
        log.debug("update resource id:{}, groupForm:{}", id, groupForm);
        Group group = groupForm.toPo(Group.class);
        group.setId(id);
        groupService.update(group);
        return Result.success();
    }

    @ApiOperation(value = "获取用户组", notes = "根据用户组Id获取用户组")
    @ApiImplicitParam(name = "id", value = "用户组Id", required = true, dataType = "long", paramType = "path")
    @GetMapping("/{id}")
    public Result get(@PathVariable long id){
        log.debug("get group:{}", id);
        return Result.success(groupService.get(id));
    }

    @ApiOperation(value = "查询用户组", notes = "根据用户组名称获取用户组")
    @ApiImplicitParam(name = "name", value = "用户组名", required = true, dataType = "String", paramType = "Query")
    @GetMapping
    public Result query(@RequestParam String name){
        GroupQueryParam groupQueryParam = new GroupQueryParam();
        groupQueryParam.setName(name);
        return Result.success(groupService.query(groupQueryParam));
    }

    @ApiOperation(value = "查找用户组")
    @ApiImplicitParam(name = "groupQueryForm", value = "查询条件", required = true, dataType = "GroupQueryForm")
    @PostMapping("/conditions")
    public Result search(@Valid @RequestBody GroupQueryForm groupQueryForm) {
        log.debug("search conditions:{}",groupQueryForm);
        return Result.success(groupService.query(groupQueryForm.toParam(GroupQueryParam.class)));
    }

    @ApiOperation(value = "获取子用户组", notes = "根据用户组父Id获取子用户组")
    @ApiImplicitParam(name = "id", value = "用户组父Id", required = true, dataType = "long", paramType = "path")
    @GetMapping("/parent/{id}")
    public Result search(@PathVariable long id){
        log.debug("search parentId:{}", id);
        return Result.success(groupService.queryByParentId(id));
    }


}
