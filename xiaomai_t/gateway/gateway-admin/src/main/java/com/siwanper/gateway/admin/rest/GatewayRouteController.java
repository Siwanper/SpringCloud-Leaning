package com.siwanper.gateway.admin.rest;

import com.siwanper.core.entity.vo.Result;
import com.siwanper.gateway.admin.entity.form.GatewayRouteForm;
import com.siwanper.gateway.admin.entity.form.GatewayRouteQueryFrom;
import com.siwanper.gateway.admin.entity.form.GatewayRouteUpdateForm;
import com.siwanper.gateway.admin.entity.param.GatewayRouteQueryParam;
import com.siwanper.gateway.admin.entity.po.GatewayRoute;
import com.siwanper.gateway.admin.service.IGatewayRouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-05-11 3:44 PM
 */
@Slf4j
@RestController
@RequestMapping(value = "/gateway/routes")
public class GatewayRouteController {

    @Autowired
    private IGatewayRouteService gatewayRouteService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result addGatewayRoute(@Valid @RequestBody GatewayRouteForm gatewayRouteForm){
        log.info("add gateway route :{}", gatewayRouteForm);
        GatewayRoute gatewayRoute = gatewayRouteForm.toPo(GatewayRoute.class);
        return Result.success(gatewayRouteService.add(gatewayRoute));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public Result deleteGatewayRoute(@PathVariable String id){
        return Result.success(gatewayRouteService.delete(id));
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Result updateGatewayRoute(@PathVariable String id,@Valid @RequestBody GatewayRouteUpdateForm updateForm){
        GatewayRoute gatewayRoute = updateForm.toPo(GatewayRoute.class);
        gatewayRoute.setId(id);
        return Result.success(gatewayRouteService.update(gatewayRoute));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getGatewayRoute(@PathVariable String id){
        return Result.success(gatewayRouteService.get(id));
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result search(@RequestBody GatewayRouteQueryFrom queryFrom){
        return Result.success(gatewayRouteService.query(queryFrom.toParam(GatewayRouteQueryParam.class)));
    }

}
