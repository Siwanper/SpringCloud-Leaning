package com.swp.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-07-23 4:23 PM
 */
@RefreshScope
@RestController
public class GatewayController {

    @Value("${msg}")
    private String msg;

    @RequestMapping("/hello")
    public String hello(){
        return msg;
    }

}
