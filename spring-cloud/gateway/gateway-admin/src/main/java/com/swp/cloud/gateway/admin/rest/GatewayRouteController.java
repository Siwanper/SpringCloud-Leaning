package com.swp.cloud.gateway.admin.rest;

import com.swp.cloud.common.core.entity.vo.Result;
import com.swp.cloud.gateway.admin.entity.form.GatewayRouteForm;
import com.swp.cloud.gateway.admin.entity.po.GatewayRoute;
import com.swp.cloud.gateway.admin.service.IGatewayRouteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    @PostMapping
    public Result add(@Valid @RequestBody GatewayRouteForm gatewayRouteForm) {
       return Result.success(gatewayRouteService.add(gatewayRouteForm.toPo(GatewayRoute.class)));
    }

    @ApiOperation(value = "获取网关信息", notes = "根据id获取网关信息")
    @ApiImplicitParam(name = "id", value = "网关ID" ,required = true, paramType = "Path", dataType = "long")
    @GetMapping("/{id}")
    public Result get(@PathVariable long id) {
        log.info("get id : " + id);
        return Result.success(gatewayRouteService.get(id));
    }

}
