package com.siwanper.organization.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.siwanper.organization.entity.param.ResourceQueryParam;
import com.siwanper.organization.entity.po.Resource;

import java.util.List;

public interface IResourceService {

    /**
     * 添加资源
     * @param resource
     * @return
     */
    boolean add(Resource resource);

    /**
     * 删除资源
     * @param id 资源id
     * @return
     */
    boolean delete(String id);

    /**
     * 修改资源
     * @param resource
     * @return
     */
    boolean update(Resource resource);

    /**
     * 根据资源ID查询资源
     * @param id
     * @return
     */
    Resource get(String id);

    /**
     * 获取所有资源
     * @return
     */
    List<Resource> getAll();

    /**
     * 分页查询资源
     * @param page
     * @param resourceQueryParam
     * @return
     */
    IPage<Resource> query(Page page, ResourceQueryParam resourceQueryParam);

    /**
     * 查询用户所拥有的所有资源
     * @param username
     * @return
     */
    List<Resource> queryByUsername(String username);

}
