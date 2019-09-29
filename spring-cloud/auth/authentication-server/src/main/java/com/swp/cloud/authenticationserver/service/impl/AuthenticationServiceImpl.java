package com.swp.cloud.authenticationserver.service.impl;

import com.swp.cloud.authenticationserver.entity.po.Resource;
import com.swp.cloud.authenticationserver.service.IAuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-29 2:36 PM
 */
@Slf4j
@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    private static final String NONEXISTENT_URL = "NONEXISTENT_URL";

    @Autowired
    private ResourceServiceImpl resourceService;

    @Override
    public boolean decide(HttpServletRequest request) {
        log.info("url : {}, method : {}", request.getServletPath(), request.getMethod());
        // 获取请求用户的授权信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 获取请求的资源信息
        ConfigAttribute attribute = resourceService.findAttributeByUrl(request);
        if (NONEXISTENT_URL.equals(attribute.getAttribute())) {
            log.debug("请求资源无效");
        }
        // 获取请求用户的所有资源
        Set<Resource> resources = this.findResourceByUsername(authentication.getName());

        return isMatch(attribute, resources);
    }

    private boolean isMatch(ConfigAttribute attribute, Set<Resource> resources) {
        return resources.stream().anyMatch(resource -> resource.getCode().equals(attribute.getAttribute()));
    }

    private Set<Resource> findResourceByUsername(String username) {
        Set<Resource> resources = resourceService.queryResouceByUsername(username);
        if (log.isDebugEnabled()) {
            log.debug("用户被授权的资源个数：{}, 用户的资源合集：{}", resources.size(), resources);
        }
        return resources;
    }

}
