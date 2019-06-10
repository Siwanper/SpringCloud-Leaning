package com.swp.springcloudeurekacustomer2.remoteService;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "spring.cloud.customer")
public interface HomeRemote {

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable(value = "name") String name);

}
