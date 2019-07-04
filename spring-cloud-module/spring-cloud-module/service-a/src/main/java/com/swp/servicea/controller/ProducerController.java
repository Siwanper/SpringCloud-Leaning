package com.swp.servicea.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-07-01 6:08 PM
 */
@RefreshScope
@RestController
public class ProducerController {

    @Value("${msg}")
    private String msg;

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name") String name){
        return "hello " + name + ", " + msg + "'m first producer";
    }

}
