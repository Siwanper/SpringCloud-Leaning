package com.swp.cloud.sysadmin.organization.rest;

import com.swp.cloud.common.core.entity.vo.Result;
import com.swp.cloud.sysadmin.organization.entity.form.GroupForm;
import com.swp.cloud.sysadmin.organization.entity.form.GroupQueryForm;
import com.swp.cloud.sysadmin.organization.entity.form.PositionForm;
import com.swp.cloud.sysadmin.organization.entity.form.PositionQueryForm;
import com.swp.cloud.sysadmin.organization.entity.param.GroupQueryParam;
import com.swp.cloud.sysadmin.organization.entity.param.PositionQueryParam;
import com.swp.cloud.sysadmin.organization.entity.po.Group;
import com.swp.cloud.sysadmin.organization.entity.po.Position;
import com.swp.cloud.sysadmin.organization.service.impl.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 描述: 岗位控制器
 *
 * @outhor ios
 * @create 2019-09-06 2:23 PM
 */
@Api("position")
@Slf4j
@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @ApiOperation(value = "添加岗位", notes = "添加岗位信息")
    @ApiImplicitParam(name = "positionForm" ,value = "岗位表单信息", required = true, dataType = "PositionForm")
    @PostMapping
    public Result add(@Valid @RequestBody PositionForm positionForm){
        log.debug("add position:{}", positionForm);
        Position position = positionForm.toPo(Position.class);
        return Result.success(positionService.add(position));
    }

    @ApiOperation(value = "删除岗位", notes = "根据岗位Id删除岗位")
    @ApiImplicitParam(name = "id", value = "岗位ID", required = true, dataType = "long", paramType = "path" )
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable long id){
        log.debug("delete position:{}",id);
        positionService.delete(id);
        return Result.success();
    }

    @ApiOperation(value = "更新岗位", notes = "根据岗位ID更新岗位信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "岗位ID", dataType = "long", required = true, paramType = "path"),
            @ApiImplicitParam(name = "positionForm", value = "岗位信息", dataType = "PositionForm", required = true)})
    @PutMapping("/{id}")
    public Result update(@PathVariable long id, @Valid @RequestBody PositionForm positionForm) {
        log.debug("update position id:{}, positionForm:{}", id, positionForm);
        Position position = positionForm.toPo(Position.class);
        position.setId(id);
        positionService.update(position);
        return Result.success();
    }

    @ApiOperation(value = "获取岗位", notes = "根据岗位Id获取岗位")
    @ApiImplicitParam(name = "id", value = "岗位Id", required = true, dataType = "long", paramType = "path")
    @GetMapping("/{id}")
    public Result get(@PathVariable long id){
        log.debug("get position:{}", id);
        return Result.success(positionService.get(id));
    }

    @ApiOperation(value = "查询岗位", notes = "根据岗位名称获取岗位")
    @ApiImplicitParam(name = "name", value = "岗位名", required = true, dataType = "String", paramType = "Query")
    @GetMapping
    public Result query(@RequestParam String name){
        PositionQueryParam positionQueryParam = new PositionQueryParam();
        positionQueryParam.setName(name);
        return Result.success(positionService.query(positionQueryParam));
    }

    @ApiOperation(value = "查找岗位")
    @ApiImplicitParam(name = "groupQueryForm", value = "查询条件", required = true, dataType = "GroupQueryForm")
    @PostMapping("/conditions")
    public Result search(@Valid @RequestBody PositionQueryForm positionQueryForm) {
        log.debug("search conditions:{}",positionQueryForm);
        return Result.success(positionService.query(positionQueryForm.toParam(PositionQueryParam.class)));
    }

}
