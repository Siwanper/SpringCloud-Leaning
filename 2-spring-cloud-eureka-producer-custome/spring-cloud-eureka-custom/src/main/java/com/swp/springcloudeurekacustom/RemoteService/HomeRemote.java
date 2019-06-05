package com.swp.springcloudeurekacustom.RemoteService;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spring.cloud.eurake.producer")
public interface HomeRemote {
    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name") String name);
}
