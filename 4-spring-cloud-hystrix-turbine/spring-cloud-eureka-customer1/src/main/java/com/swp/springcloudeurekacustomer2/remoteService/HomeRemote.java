package com.swp.springcloudeurekacustomer2.remoteService;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spring.cloud.eurake.producer" , fallback = HomeRemoteFallBack.class)
public interface HomeRemote {

    @RequestMapping("/hello1")
    public String hello1(@RequestParam(value = "name") String name);

}
