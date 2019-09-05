package com.swp.cloud.sysadmin.organization.rest;

import com.swp.cloud.common.core.entity.vo.Result;
import com.swp.cloud.sysadmin.organization.entity.form.ResourceForm;
import com.swp.cloud.sysadmin.organization.entity.form.ResourceQueryForm;
import com.swp.cloud.sysadmin.organization.entity.param.ResourceQueryParam;
import com.swp.cloud.sysadmin.organization.entity.po.Resource;
import com.swp.cloud.sysadmin.organization.service.impl.ResourceService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-05 5:15 PM
 */
@RestController
@RequestMapping("/resource")
@Slf4j
@Api("resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ApiOperation(value = "添加资源", notes = "添加资源信息")
    @ApiImplicitParam(name = "resourceForm", value = "资源信息", required = true, dataType = "ResourceForm")
    @PostMapping
    public Result add(@Valid @RequestBody ResourceForm resourceForm){
        log.debug("add resource:{}",resourceForm);
        Resource resource = resourceForm.toPo(Resource.class);
        return Result.success(resourceService.add(resource));
    }

    @ApiOperation(value = "删除资源", notes = "根据资源ID删除资源")
    @ApiImplicitParam(name = "id", value = "资源ID", dataType = "long", required = true, paramType = "path")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable long id){
        log.debug("delete resource id:{}",id);
        resourceService.delete(id);
        return Result.success();
    }

    @ApiOperation(value = "更新资源", notes = "根据资源ID更新资源信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "资源ID", dataType = "long", required = true, paramType = "path"),
            @ApiImplicitParam(name = "resourceForm", value = "资源信息", dataType = "ResourceForm", required = true)})
    @PutMapping("/{id}")
    public Result update(@PathVariable long id, @Valid @RequestBody ResourceForm resourceForm) {
        log.debug("update resource id:{}, resourceForm:{}", id, resourceForm);
        Resource resource = resourceForm.toPo(Resource.class);
        resource.setId(id);
        resourceService.update(resource);
        return Result.success();
    }

    @ApiOperation(value = "获取资源", notes = "根据资源Id获取资源")
    @ApiImplicitParam(name = "id", value = "资源Id", required = true, dataType = "long", paramType = "path")
    @GetMapping("/{id}")
    public Result get(@PathVariable long id){
        return Result.success(resourceService.get(id));
    }

    @ApiOperation(value = "搜索资源", notes = "根据条件搜索资源")
    @ApiImplicitParam(name = "resourceQueryForm", value = "搜索的资源条件", dataType = "ResourceQueryForm", required = true)
    @ApiResponses({@ApiResponse(code = 200, message = "处理成功", response = Result.class)})
    @PostMapping("/conditions")
    public Result search(@Valid @RequestBody ResourceQueryForm resourceQueryForm) {
        log.debug("search resource conditions:{}",resourceQueryForm);
        return Result.success(resourceService.queryPage(resourceQueryForm.getPage(), resourceQueryForm.toParam(ResourceQueryParam.class)));
    }

    @ApiOperation(value = "获取所有用户资源", notes = "获取所有用户资源")
    @ApiResponses({@ApiResponse(code = 200, message = "处理成功", response = Result.class)})
    @GetMapping("/all")
    public Result query(){
        return Result.success(resourceService.query(new ResourceQueryParam()));
    }

    @ApiOperation(value = "获取用户资源", notes = "根据用户名获取用户的资源")
    @ApiImplicitParam(name = "username", value = "用户名", dataType = "String", required = true, paramType = "path")
    @ApiResponses({@ApiResponse(code = 200, message = "处理成功", response = Result.class)})
    @GetMapping("/user/{username}")
    public Result query(@PathVariable String username){
        log.debug("username :{}",username);
        return Result.success(resourceService.query(username));
    }

}
