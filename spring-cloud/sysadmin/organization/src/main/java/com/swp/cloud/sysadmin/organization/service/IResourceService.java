package com.swp.cloud.sysadmin.organization.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swp.cloud.sysadmin.organization.entity.param.ResourceQueryParam;
import com.swp.cloud.sysadmin.organization.entity.po.Resource;

import java.util.List;

public interface IResourceService {

    /**
     * 添加资源
     * @param resource
     * @return
     */
    long add(Resource resource);

    /**
     * 删除资源
     * @param id
     */
    void delete(long id);

    /**
     * 修改资源
     * @param resource
     */
    void update(Resource resource);

    /**
     * 查询资源
     * @param id
     * @return
     */
    Resource get(long id);

    /**
     * 分页查询资源
     * @param page
     * @return
     */
    IPage<Resource> queryPage(Page page, ResourceQueryParam resourceQueryParam);

    /**
     * 根据条件查询
     * @return
     */
    List<Resource> query(ResourceQueryParam resourceQueryParam);

    /**
     * 获取用户所拥有的资源
     * @param username
     * @return
     */
    List<Resource> query(String username);


}
