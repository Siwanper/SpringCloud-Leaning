package com.siwanper.organization.rest;

import com.siwanper.core.entity.vo.Result;
import com.siwanper.organization.entity.form.ResourceForm;
import com.siwanper.organization.entity.form.ResourceQueryForm;
import com.siwanper.organization.entity.form.ResourceUpdateForm;
import com.siwanper.organization.entity.param.ResourceQueryParam;
import com.siwanper.organization.entity.po.Resource;
import com.siwanper.organization.service.IResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 描述:
 * 资源控制器
 *
 * @outhor ios
 * @create 2020-04-17 10:42 AM
 */
@Api(value = "资源管理")
@RestController
@RequestMapping(value = "/resource")
public class ResourceController {

    @Autowired
    private IResourceService resourceService;

    @ApiOperation(value = "添加资源")
    @ApiImplicitParam(name = "resourceForm", value = "资源信息", required = true, dataType = "ResourceForm")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result addResource(@Valid @RequestBody ResourceForm resourceForm) {
        return Result.success(resourceService.add(resourceForm.toPo(Resource.class)));
    }

    @ApiOperation(value = "根据资源Id删除资源")
    @ApiImplicitParam(name = "id", value = "资源Id", required = true, paramType = "path", dataType = "string")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public Result deleteResource(@PathVariable String id){
        return Result.success(resourceService.delete(id));
    }

    @ApiOperation(value = "更新资源")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "资源id", required = true, paramType = "path", dataType = "string"),
            @ApiImplicitParam(name = "resourceUpdateForm", value = "资源更新信息", required = true, dataType = "ResourceUpdateForm")
    })
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Result updateResource(@PathVariable String id, @Valid @RequestBody ResourceUpdateForm resourceUpdateForm){
        Resource resource = resourceUpdateForm.toPo(Resource.class);
        resource.setId(id);
        return Result.success(resourceService.update(resource));
    }

    @ApiOperation(value = "根据资源Id查询资源")
    @ApiImplicitParam(name = "id", value = "资源Id", required = true, paramType = "path", dataType = "string")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result get(@PathVariable String id){
        return Result.success(resourceService.get(id));
    }

    @ApiOperation(value = "获取所有资源")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Result getAll(){
        return Result.success(resourceService.getAll());
    }

    @ApiOperation(value = "条件查询资源")
    @ApiImplicitParam(name = "resourceQueryForm", value = "查询条件", required = true, dataType = "ResourceQueryForm")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result search(@Valid @RequestBody ResourceQueryForm resourceQueryForm){
        return Result.success(resourceService.query(resourceQueryForm.getPage(), resourceQueryForm.toParam(ResourceQueryParam.class)));
    }

    @ApiOperation(value = "根据用户Id查询资源")
    @ApiImplicitParam(name = "userId", value = "用户Id", required = true, paramType = "path", dataType = "string")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public Result queryByUserId(@PathVariable String userId){
        return Result.success(resourceService.queryByUserId(userId));
    }

}
