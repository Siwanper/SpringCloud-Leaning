package com.siwanper.organization.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.siwanper.organization.entity.po.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * DESCRIPTION：   角色Mapper
 *
 * @ProjectName: cloud
 * @Package: com.siwanper.organization.dao
 * @Author: Siwanper
 * @CreateDate: 2020/4/14 下午10:06
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2020</p>
 */
@Repository
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}
