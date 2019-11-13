package com.swp.cloud.gateway.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swp.cloud.gateway.admin.entity.po.GatewayRoute;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GatewayRouteMapper extends BaseMapper<GatewayRoute> {
}
