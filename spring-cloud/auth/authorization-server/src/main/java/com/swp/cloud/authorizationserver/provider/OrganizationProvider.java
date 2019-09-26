package com.swp.cloud.authorizationserver.provider;

import com.swp.cloud.authorizationserver.entity.Role;
import com.swp.cloud.authorizationserver.entity.User;
import com.swp.cloud.common.core.entity.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(name = "organization" ,fallback = OrganizationProviderFallback.class)
public interface OrganizationProvider {

    @RequestMapping("/user")
    Result<User> getByUniqueId(@RequestParam("unique") String unique);

    @RequestMapping("/role/user/{userId}")
    Result<Set<Role>> getRoleByUserId(@PathVariable("userId") long userId);

}
