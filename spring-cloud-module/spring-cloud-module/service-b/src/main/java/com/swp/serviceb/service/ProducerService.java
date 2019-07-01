package com.swp.serviceb.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "service-a")
public interface ProducerService {

    @RequestMapping("/hello")
    public String hello();

}
