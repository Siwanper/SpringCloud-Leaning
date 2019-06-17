package com.swp.springcloudproducer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * DESCRIPTION：   ${DESCRIPTION}
 *
 * @ProjectName: spring-cloud-producer
 * @Package: com.swp.springcloudproducer.controller
 * @Author: Siwanper
 * @CreateDate: 2019/6/15 下午4:33
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
@RestController
public class ProducerController {

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name") String name){
        return "hello " + name + ", it's first producer";
    }

}
