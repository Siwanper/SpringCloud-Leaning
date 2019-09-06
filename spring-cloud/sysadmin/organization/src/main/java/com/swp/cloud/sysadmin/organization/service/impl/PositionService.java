package com.swp.cloud.sysadmin.organization.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.swp.cloud.sysadmin.organization.dao.PositionMapper;
import com.swp.cloud.sysadmin.organization.entity.param.PositionQueryParam;
import com.swp.cloud.sysadmin.organization.entity.po.Position;
import com.swp.cloud.sysadmin.organization.service.IPositionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-06 2:19 PM
 */
@Service
public class PositionService implements IPositionService {

    @Autowired
    private PositionMapper positionMapper;


    @Override
    public long add(Position position) {
        return positionMapper.insert(position);
    }

    @Override
    @CacheEvict(value = "position", key = "#root.targetClass.name"+"+#id")
    public void delete(long id) {
        positionMapper.deleteById(id);
    }

    @Override
    @CacheEvict(value = "position", key = "#root.targetClass.name"+"+#position.id")
    public void update(Position position) {
        positionMapper.updateById(position);
    }

    @Override
    @Cacheable(value = "position", key = "#root.targetClass.name"+"+#id")
    public Position get(long id) {
        return positionMapper.selectById(id);
    }

    @Override
    public List<Position> query(PositionQueryParam positionQueryParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.ge(null != positionQueryParam.getCreatedTimeStart(), "created_time", positionQueryParam.getCreatedTimeStart());
        queryWrapper.le(null != positionQueryParam.getCreatedTimeEnd(), "created_time", positionQueryParam.getCreatedTimeEnd());
        queryWrapper.eq(StringUtils.isNotBlank(positionQueryParam.getName()), "name", positionQueryParam.getName());
        return positionMapper.selectList(queryWrapper);
    }
}


