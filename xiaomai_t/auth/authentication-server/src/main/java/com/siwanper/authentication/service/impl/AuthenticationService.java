package com.siwanper.authentication.service.impl;

import com.siwanper.authentication.entity.po.Resource;
import com.siwanper.authentication.service.IAuthenticationService;
import com.siwanper.authentication.service.IResourceService;
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
 * 资源认证服务
 *
 * @outhor ios
 * @create 2020-04-28 3:54 PM
 */
@Slf4j
@Service
public class AuthenticationService implements IAuthenticationService{

    @Autowired
    private IResourceService resourceService;

    @Override
    public boolean decide(HttpServletRequest request) {
        // 请求url和method对应的资源权限
        ConfigAttribute attribute = resourceService.findConfigAttributeByRequest(request);
        if ("NON_EXISTE_URL".equals(attribute.getAttribute())){
            log.error("请求url未在资源配置中找到！");
        }
        // 获取用户认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 获取此用户所有的资源权限信息
        Set<Resource> resources = resourceService.queryResourceByUsername(authentication.getName());
        log.info("user:{}, resource:{}", authentication.getName(),resources);
        // 判断此用户是否有当前请求url和method对应的资源权限信息
        boolean result = resources.stream().anyMatch(resource -> resource.getCode().equals(attribute.getAttribute()));
        return result;
    }

}
