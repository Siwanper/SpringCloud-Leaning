package com.swp.cloud.sysadmin.organization.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.swp.cloud.sysadmin.organization.dao.MenuMapper;
import com.swp.cloud.sysadmin.organization.entity.param.MenuQueryParam;
import com.swp.cloud.sysadmin.organization.entity.po.Menu;
import com.swp.cloud.sysadmin.organization.service.IMenuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-06 3:01 PM
 */
@Service
public class MenuService implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public long add(Menu menu) {
        return menuMapper.insert(menu);
    }

    @Override
    public void delete(long id) {
        menuMapper.deleteById(id);
    }

    @Override
    public void update(Menu menu) {
        menuMapper.updateById(menu);
    }

    @Override
    public Menu get(long id) {
        return menuMapper.selectById(id);
    }

    @Override
    public List<Menu> query(MenuQueryParam menuQueryParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.ge(null != menuQueryParam.getCreatedTimeStart(), "created_time", menuQueryParam.getCreatedTimeStart());
        queryWrapper.le(null != menuQueryParam.getCreatedTimeEnd(), "created_time", menuQueryParam.getCreatedTimeEnd());
        queryWrapper.eq(StringUtils.isNotBlank(menuQueryParam.getName()), "name", menuQueryParam.getName());
        return menuMapper.selectList(queryWrapper);
    }

    @Override
    public List<Menu> queryByParentId(long parentId) {
        return menuMapper.selectList(new QueryWrapper<Menu>().eq("parent_id", parentId));
    }
}
