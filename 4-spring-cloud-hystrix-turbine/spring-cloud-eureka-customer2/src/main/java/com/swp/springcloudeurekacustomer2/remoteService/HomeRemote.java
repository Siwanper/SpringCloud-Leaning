package com.swp.springcloudeurekacustomer2.remoteService;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spring.cloud.eurake.producer2" ,fallback = HomeRemoteFallBack.class)
public interface HomeRemote {

    @RequestMapping("/hello2")
    public String hello2(@RequestParam(value = "name") String name);

}
