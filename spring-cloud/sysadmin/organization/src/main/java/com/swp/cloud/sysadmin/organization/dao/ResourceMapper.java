package com.swp.cloud.sysadmin.organization.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swp.cloud.sysadmin.organization.entity.po.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-05 4:21 PM
 */
@Repository
@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {



}
