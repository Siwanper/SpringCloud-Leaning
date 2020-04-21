package com.siwanper.authorization.provider;

import com.siwanper.authorization.entity.po.Role;
import com.siwanper.authorization.entity.po.User;
import com.siwanper.core.entity.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "organization", fallback = OrganizationProviderFallBack.class)
public interface OrganizationProvider {

    /**
     * 根据用户的唯一标识获取用户信息
     * @param uniqueId
     * @return
     */
    @GetMapping(value = "/user")
    Result<User> getUserByUniqueId(@RequestParam(value = "uniqueId") String uniqueId);

    /**
     * 根据用户的ID，获取用户的角色信息
     * @param userId
     * @return
     */
    @GetMapping(value = "/role/user/{userId}")
    Result<List<Role>> getRolesByUserId(@PathVariable(value = "userId") String userId);

}
