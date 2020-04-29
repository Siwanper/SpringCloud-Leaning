package com.siwanper.authentication.provider;

import com.siwanper.organization.entity.po.Resource;
import com.siwanper.core.entity.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@FeignClient(name = "organization" ,fallback = ResourceProviderFallback.class)
public interface ResourceProvider {

    /**
     * 获取所有的资源
     * @return
     */
    @RequestMapping(value = "/resource/all", method = RequestMethod.GET)
    Result<Set<Resource>> resource();

    /**
     * 根据用户名获取资源
     * @param username
     * @return
     */
    @RequestMapping(value = "/resource/user/{username}", method = RequestMethod.GET)
    Result<Set<Resource>> resource(@PathVariable(value = "username") String username);

}
