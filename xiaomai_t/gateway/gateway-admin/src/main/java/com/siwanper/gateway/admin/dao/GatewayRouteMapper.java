package com.siwanper.gateway.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.siwanper.gateway.admin.entity.po.GatewayRoute;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface GatewayRouteMapper extends BaseMapper<GatewayRoute> {
}
