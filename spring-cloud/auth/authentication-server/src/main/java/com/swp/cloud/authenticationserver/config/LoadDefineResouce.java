package com.swp.cloud.authenticationserver.config;

import com.swp.cloud.authenticationserver.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-29 3:30 PM
 */
@Component
public class LoadDefineResouce {

    @Autowired
    private IResourceService resourceService;

    @Bean
    public Map<RequestMatcher, ConfigAttribute> resouceConfigAttribute(){
        return resourceService.loadAllResources();
    }

}
