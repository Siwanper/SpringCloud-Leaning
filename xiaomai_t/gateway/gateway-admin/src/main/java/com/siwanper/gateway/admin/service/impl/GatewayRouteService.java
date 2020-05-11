package com.siwanper.gateway.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.siwanper.gateway.admin.dao.GatewayRouteMapper;
import com.siwanper.gateway.admin.entity.param.GatewayRouteQueryParam;
import com.siwanper.gateway.admin.entity.po.GatewayRoute;
import com.siwanper.gateway.admin.entity.vo.GatewayRouteVo;
import com.siwanper.gateway.admin.service.IGatewayRouteService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述:
 * 网关路由服务
 *
 * @outhor ios
 * @create 2020-05-11 3:42 PM
 */
@Service
public class GatewayRouteService extends ServiceImpl<GatewayRouteMapper, GatewayRoute> implements IGatewayRouteService {

    @Override
    public boolean add(GatewayRoute gatewayRoute) {
        return this.save(gatewayRoute);
    }

    @Override
    public boolean delete(String id) {
        return this.removeById(id);
    }

    @Override
    public boolean update(GatewayRoute gatewayRoute) {
        return this.updateById(gatewayRoute);
    }

    @Override
    public GatewayRoute get(String id) {
        return this.getById(id);
    }

    @Override
    public List<GatewayRouteVo> query(GatewayRouteQueryParam queryParam) {
        QueryWrapper<GatewayRoute> queryWrapper = queryParam.build();
        queryWrapper.eq(StringUtils.isNotBlank(queryParam.getUri()), "uri", queryParam.getUri());
        List<GatewayRoute> list = this.list(queryWrapper);
        return list.stream().map(GatewayRouteVo::new).collect(Collectors.toList());
    }
}
