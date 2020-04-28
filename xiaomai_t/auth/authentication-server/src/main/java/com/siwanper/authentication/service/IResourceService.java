package com.siwanper.authentication.service;

import com.siwanper.authentication.entity.po.Resource;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Set;

public interface IResourceService {

    /**
     * 添加资源
     * @param resource
     */
    void saveResource(Resource resource);

    /**删除资源
     * @param resource
     */
    void removeResource(Resource resource);

    /**
     * 加载系统资源权限
     *
     * @return
     */
    Map<RequestMatcher, ConfigAttribute> loadResource();

    /**
     * 根据网络请求中的url 和 method，获取资源
     *
     * @param request
     * @return
     */
    ConfigAttribute findConfigAttributeByRequest(HttpServletRequest request);

    /**
     * 根据用户名获取资源权限
     * @param username
     * @return
     */
    Set<Resource> queryResourceByUsername(String username);


}
