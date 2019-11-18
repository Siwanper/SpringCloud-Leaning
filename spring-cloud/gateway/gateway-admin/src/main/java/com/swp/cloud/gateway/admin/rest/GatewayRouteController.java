package com.swp.cloud.gateway.admin.rest;

import com.swp.cloud.common.core.entity.vo.Result;
import com.swp.cloud.gateway.admin.entity.form.GatewayRouteForm;
import com.swp.cloud.gateway.admin.entity.form.GatewayRouteQueryForm;
import com.swp.cloud.gateway.admin.entity.param.GatewayRouteQueryParam;
import com.swp.cloud.gateway.admin.entity.po.GatewayRoute;
import com.swp.cloud.gateway.admin.entity.vo.GatewayRouteVo;
import com.swp.cloud.gateway.admin.service.IGatewayRouteService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-11-13 5:11 PM
 */
@RestController
@RequestMapping("/gateway/routes")
@Api("gateway routes")
@Slf4j
public class GatewayRouteController {

    @Autowired
    private IGatewayRouteService gatewayRouteService;

    @ApiOperation(value = "添加网关", notes = "添加网关信息")
    @ApiImplicitParam(name = "gatewayRouteForm", value = "新增网关路由form信息", required = true, dataType = "GatewayRouteForm")
    @PostMapping("/add")
    public Result add(@Valid @RequestBody GatewayRouteForm gatewayRouteForm) {
        log.info("add gateway route " + gatewayRouteForm);
        return Result.success(gatewayRouteService.add(gatewayRouteForm.toPo(GatewayRoute.class)));
    }

    @ApiOperation(value = "删除网关信息", notes = "根据id删除网关信息")
    @ApiImplicitParam(name = "id", value = "网关ID" ,required = true, paramType = "Path", dataType = "long")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable long id) {
        log.info("delete gate id" + id);
        gatewayRouteService.delete(id);
        return Result.success();
    }

    @ApiOperation(value = "修改网关信息", notes = "根据id修改网关信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "网关ID" ,required = true, paramType = "Path", dataType = "long"),
            @ApiImplicitParam(name = "gatewayRouteForm", value = "修改网关的信息" ,required = true, dataType = "GatewayRouteForm")
            })
    @PutMapping("/{id}")
    public Result update(@PathVariable long id,@Valid @RequestBody GatewayRouteForm gatewayRouteForm) {
        GatewayRoute gatewayRoute = gatewayRouteForm.toPo(GatewayRoute.class);
        gatewayRoute.setId(id);
        gatewayRouteService.update(gatewayRoute);
        return Result.success();
    }

    @ApiOperation(value = "获取网关信息", notes = "根据id获取网关信息")
    @ApiImplicitParam(name = "id", value = "网关ID" ,required = true, paramType = "Path", dataType = "long")
    @GetMapping("/{id}")
    public Result get(@PathVariable long id) {
        log.info("get id : " + id);
        return Result.success(gatewayRouteService.get(id));
    }

    @ApiOperation(value = "获取网关信息", notes = "根据uri获取网关信息")
    @ApiImplicitParam(name = "uri", value = "路由地址" ,required = true, paramType = "query", dataType = "string")
    @GetMapping
    public Result getByUri(@RequestParam String uri) {
        List<GatewayRouteVo> routeVos = gatewayRouteService.query(new GatewayRouteQueryParam(uri)).stream().map(GatewayRouteVo::new).collect(Collectors.toList());
        return Result.success(routeVos.stream().findFirst());
    }

    @ApiOperation(value = "查询网关", notes = "查询网关信息")
    @ApiImplicitParam(name = "gatewayRouteQueryForm", value = "查询网关信息的条件", required = true, dataType = "gatewayRouteQueryForm")
    @PostMapping("/conditions")
    public Result search(@Valid @RequestBody GatewayRouteQueryForm gatewayRouteQueryForm){
        log.info("conditions " + gatewayRouteQueryForm);
        GatewayRouteQueryParam queryParam = gatewayRouteQueryForm.toParam(GatewayRouteQueryParam.class);
        List<GatewayRoute> routes = gatewayRouteService.query(queryParam);
        List<GatewayRouteVo> routeVos = routes.stream().map(GatewayRouteVo::new).collect(Collectors.toList());
        return Result.success(routeVos);
    }

    @ApiOperation(value = "重新加载网关", notes = "将网关信息重新加载到redis中")
    @ApiResponses({
             @ApiResponse(code = 200, message = "加载成功", response = Result.class)
            })
    @PostMapping("/overload")
    public Result overload(){
        return Result.success(gatewayRouteService.overload());
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello gateway-web";
    }

}
