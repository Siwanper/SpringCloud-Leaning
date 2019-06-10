package com.swp.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-06-10 11:56 AM
 */
@RestController
@RefreshScope
public class HelloController {

    @Value("${swp.name}")
    private String environment;

    @RequestMapping("/hello")
    public String hello(){
        return this.environment;
    }

}
