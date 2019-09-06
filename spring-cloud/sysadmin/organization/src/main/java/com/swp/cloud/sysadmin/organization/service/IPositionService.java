package com.swp.cloud.sysadmin.organization.service;

import com.swp.cloud.sysadmin.organization.entity.param.PositionQueryParam;
import com.swp.cloud.sysadmin.organization.entity.po.Position;

import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-06 2:16 PM
 */
public interface IPositionService {


    /**
     * 添加用户组
     * @param position
     * @return
     */
    long add(Position position);

    /**
     * 删除用户组
     * @param id
     */
    void delete(long id);

    /**
     * 修改用户组
     * @param position
     */
    void update(Position position);

    /**
     * 获取用户组
     * @param id
     * @return
     */
    Position get(long id);

    /**
     * 查询用户组
     * @param positionQueryParam
     * @return
     */
    List<Position> query(PositionQueryParam positionQueryParam);

}
