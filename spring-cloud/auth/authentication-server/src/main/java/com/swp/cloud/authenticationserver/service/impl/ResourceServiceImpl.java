package com.swp.cloud.authenticationserver.service.impl;

import com.swp.cloud.authenticationserver.entity.po.Resource;
import com.swp.cloud.authenticationserver.provider.ResourceProvider;
import com.swp.cloud.authenticationserver.service.IResourceService;
import com.swp.cloud.authenticationserver.service.NewMvcRequestMatcher;
import com.swp.cloud.common.core.entity.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-29 11:16 AM
 */
@Slf4j
@Service
public class ResourceServiceImpl implements IResourceService {

    private static final String NONEXISTENT_URL = "NONEXISTENT_URL";

    @Autowired
    private HandlerMappingIntrospector handlerMappingIntrospector;

    @Autowired
    private ResourceProvider resourceProvider;

    Map<RequestMatcher, ConfigAttribute> resourceConfigAttributes;

    @Override
    public Map<RequestMatcher, ConfigAttribute> loadAllResources() {
        this.resourceConfigAttributes = resourceProvider.resources().getData().stream().
                collect(Collectors.toMap(
                        resource -> this.requestMatcher(resource.getUrl(), resource.getMethod()),
                        resource -> new SecurityConfig(resource.getCode())
                ));
        log.info("resourceConfigAttributes:{}", this.resourceConfigAttributes);
        return this.resourceConfigAttributes;
    }

    @Override
    public ConfigAttribute findAttributeByUrl(HttpServletRequest request) {
        if (Objects.isNull(this.resourceConfigAttributes)) {
            log.info("暂无可用资源");
        }
        ConfigAttribute attribute = this.resourceConfigAttributes.keySet().stream()
                .filter(requestMatcher -> requestMatcher.matches(request))
                .map(requestMatcher -> this.resourceConfigAttributes.get(requestMatcher))
                .peek(configAttribute -> log.info("url在资源中的配置：{}", configAttribute.getAttribute()))
                .findFirst()
                .orElse(new SecurityConfig(NONEXISTENT_URL));
        return attribute;
    }

    @Override
    public Set<Resource> queryResouceByUsername(String username) {
        Result<Set<Resource>> resources = resourceProvider.resources(username);
        return resources.getData();
    }

    public MvcRequestMatcher requestMatcher(String url, String method){
        return new NewMvcRequestMatcher(handlerMappingIntrospector, url, method);
    }


}
