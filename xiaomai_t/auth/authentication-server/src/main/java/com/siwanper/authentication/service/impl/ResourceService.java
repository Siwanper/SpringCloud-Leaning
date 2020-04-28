package com.siwanper.authentication.service.impl;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.siwanper.authentication.entity.po.Resource;
import com.siwanper.authentication.provider.ResourceProvider;
import com.siwanper.authentication.service.IResourceService;
import com.siwanper.authentication.service.NewMvcRequestMatcher;
import com.siwanper.core.entity.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 描述: 资源服务
 *
 * @outhor ios
 * @create 2020-04-28 12:23 PM
 */
@Slf4j
@Service
public class ResourceService implements IResourceService {

    @Autowired
    private HandlerMappingIntrospector handlerMappingIntrospector;

    @Autowired
    private ResourceProvider resourceProvider;

    /**
     * 系统中所有的资源权限
     *
     * RequestMatcher
     * ConfigAttribute
     */
    private Map<RequestMatcher, ConfigAttribute> resourceConfigAttribute;

    @Override
    public void saveResource(Resource resource) {
        this.resourceConfigAttribute.put(this.newMvcRequestMatcher(resource.getUrl(), resource.getMethod()), new SecurityConfig(resource.getCode()));
        log.info("resourceConfigAttribute size:{}", this.resourceConfigAttribute.size());
    }

    @Override
    public void removeResource(Resource resource) {
        this.resourceConfigAttribute.remove(this.newMvcRequestMatcher(resource.getUrl(), resource.getMethod()));
        log.info("resourceConfigAttribute size:{}", this.resourceConfigAttribute.size());
    }

    @Override
    public Map<RequestMatcher, ConfigAttribute> loadResource() {
        Set<Resource> resources = resourceProvider.resource().getData();
        this.resourceConfigAttribute = resources.stream()
                .collect(Collectors.toMap(
                        resource -> this.newMvcRequestMatcher(resource.getUrl(), resource.getMethod()),
                        resource -> new SecurityConfig(resource.getCode())
                ));
        log.info("init resourceConfigAttribute : {}", this.resourceConfigAttribute);
        return this.resourceConfigAttribute;
    }

    @Override
    public ConfigAttribute findConfigAttributeByRequest(HttpServletRequest request) {
        return this.resourceConfigAttribute.keySet().stream()
                .filter(requestMatcher -> requestMatcher.matches(request))
                .map(requestMatcher -> this.resourceConfigAttribute.get(requestMatcher))
                .peek(configAttribute -> log.info("request 在资源池中的配置: {}",configAttribute.getAttribute()))
                .findFirst()
                .orElse(new SecurityConfig("NON_EXISTE_URL"));
    }

    @Override
    @Cached(name = "resource4user_", key = "#username", cacheType = CacheType.LOCAL)
    public Set<Resource> queryResourceByUsername(String username) {
        Result<Set<Resource>> result = resourceProvider.resource(username);
        return result.getData();
    }

    /**
     * 创建RequestMatcher
     *
     * 请求对比器，matchers
     *
     * @param pattern 请求url
     * @param method 请求方法
     * @return
     */
    private NewMvcRequestMatcher newMvcRequestMatcher(String pattern, String method){
        return new NewMvcRequestMatcher(handlerMappingIntrospector, pattern, method);
    }

}
