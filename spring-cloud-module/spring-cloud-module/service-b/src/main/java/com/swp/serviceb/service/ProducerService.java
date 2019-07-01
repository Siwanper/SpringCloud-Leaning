package com.swp.serviceb.service;


import com.swp.serviceb.service.hystrix.ProducerServiceCallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-a", fallback = ProducerServiceCallBack.class)
public interface ProducerService {

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name") String name);

}
