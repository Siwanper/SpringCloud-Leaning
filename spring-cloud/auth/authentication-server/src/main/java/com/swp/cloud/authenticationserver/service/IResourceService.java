package com.swp.cloud.authenticationserver.service;

import com.swp.cloud.authenticationserver.entity.po.Resource;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Set;

public interface IResourceService {

    /**
     * 获取所有的资源信息
     * @return
     */
    Map<RequestMatcher, ConfigAttribute> loadAllResources();

    /**
     * 根据请求信息查找资源
     * @param request
     * @return
     */
    ConfigAttribute findAttributeByUrl(HttpServletRequest request);

    /**
     * 根据请求的用户，获取对应的资源
     * @param username
     * @return
     */
    Set<Resource> queryResouceByUsername(String username);

}
