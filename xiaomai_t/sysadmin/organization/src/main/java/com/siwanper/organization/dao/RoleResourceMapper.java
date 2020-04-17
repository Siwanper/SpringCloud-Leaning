package com.siwanper.organization.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.siwanper.organization.entity.po.RoleResource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoleResourceMapper extends BaseMapper<RoleResource>{
}
