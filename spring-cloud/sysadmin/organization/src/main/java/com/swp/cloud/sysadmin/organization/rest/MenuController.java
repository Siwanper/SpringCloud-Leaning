package com.swp.cloud.sysadmin.organization.rest;

import com.swp.cloud.common.core.entity.vo.Result;
import com.swp.cloud.sysadmin.organization.entity.form.MenuForm;
import com.swp.cloud.sysadmin.organization.entity.form.MenuQueryForm;
import com.swp.cloud.sysadmin.organization.entity.param.MenuQueryParam;
import com.swp.cloud.sysadmin.organization.entity.po.Menu;
import com.swp.cloud.sysadmin.organization.service.impl.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 描述: 菜单控制器
 *
 * @outhor ios
 * @create 2019-09-06 3:06 PM
 */
@Api("menu")
@Slf4j
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "添加菜单", notes = "添加菜单信息")
    @ApiImplicitParam(name = "menuForm" ,value = "菜单表单信息", required = true, dataType = "MenuForm")
    @PostMapping
    public Result add(@Valid @RequestBody MenuForm menuForm){
        log.debug("add menu:{}", menuForm);
        Menu menu = menuForm.toPo(Menu.class);
        return Result.success(menuService.add(menu));
    }

    @ApiOperation(value = "删除菜单", notes = "根据菜单Id删除菜单")
    @ApiImplicitParam(name = "id", value = "菜单ID", required = true, dataType = "long", paramType = "path" )
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable long id){
        log.debug("delete menu:{}",id);
        menuService.delete(id);
        return Result.success();
    }

    @ApiOperation(value = "更新菜单", notes = "根据菜单ID更新菜单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "菜单ID", dataType = "long", required = true, paramType = "path"),
            @ApiImplicitParam(name = "menuForm", value = "用户组信息", dataType = "MenuForm", required = true)})
    @PutMapping("/{id}")
    public Result update(@PathVariable long id, @Valid @RequestBody MenuForm menuForm) {
        log.debug("update resource id:{}, menuForm:{}", id, menuForm);
        Menu menu = menuForm.toPo(Menu.class);
        menu.setId(id);
        menuService.update(menu);
        return Result.success();
    }

    @ApiOperation(value = "获取菜单", notes = "根据菜单Id获取菜单")
    @ApiImplicitParam(name = "id", value = "菜单Id", required = true, dataType = "long", paramType = "path")
    @GetMapping("/{id}")
    public Result get(@PathVariable long id){
        log.debug("get menu:{}", id);
        return Result.success(menuService.get(id));
    }

    @ApiOperation(value = "查询菜单", notes = "根据菜单名称获取菜单")
    @ApiImplicitParam(name = "name", value = "菜单名", required = true, dataType = "String", paramType = "Query")
    @GetMapping
    public Result query(@RequestParam String name){
        MenuQueryParam menuQueryParam = new MenuQueryParam();
        menuQueryParam.setName(name);
        return Result.success(menuService.query(menuQueryParam));
    }

    @ApiOperation(value = "查找菜单")
    @ApiImplicitParam(name = "menuQueryForm", value = "查询条件", required = true, dataType = "MenuQueryForm")
    @PostMapping("/conditions")
    public Result search(@Valid @RequestBody MenuQueryForm menuQueryForm) {
        log.debug("search conditions:{}",menuQueryForm);
        return Result.success(menuService.query(menuQueryForm.toParam(MenuQueryParam.class)));
    }

    @ApiOperation(value = "获取子菜单", notes = "根据菜单父Id获取子菜单")
    @ApiImplicitParam(name = "id", value = "菜单父Id", required = true, dataType = "long", paramType = "path")
    @GetMapping("/parent/{id}")
    public Result search(@PathVariable long id){
        log.debug("search parentId:{}", id);
        return Result.success(menuService.queryByParentId(id));
    }

}
