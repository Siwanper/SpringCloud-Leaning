package com.siwanper.authentication.config;

import com.siwanper.authentication.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 描述: 系统资源加载
 *
 * @outhor ios
 * @create 2020-04-28 4:48 PM
 */
@Component
public class LoadResources {

    @Autowired
    private IResourceService resourceService;

    @Bean
    public Map<RequestMatcher, ConfigAttribute> loadResource(){
        return resourceService.loadResource();
    }

}
