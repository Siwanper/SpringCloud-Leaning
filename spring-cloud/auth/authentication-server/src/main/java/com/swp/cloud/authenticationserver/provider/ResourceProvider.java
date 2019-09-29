package com.swp.cloud.authenticationserver.provider;

import com.swp.cloud.authenticationserver.entity.po.Resource;
import com.swp.cloud.common.core.entity.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@FeignClient(value = "organization" ,fallback = ResourceProvidreFallback.class)
public interface ResourceProvider {

    @GetMapping("/resource/all")
    Result<Set<Resource>> resources();

    @GetMapping("/resource/user/{username}")
    Result<Set<Resource>> resources(@PathVariable(value = "username") String username);

}
