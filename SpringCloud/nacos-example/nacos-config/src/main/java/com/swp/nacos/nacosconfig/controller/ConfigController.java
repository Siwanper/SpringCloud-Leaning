package com.swp.nacos.nacosconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-03-09 3:38 PM
 */
@RestController
@RequestMapping(value = "/config")
@RefreshScope
public class ConfigController {

    @Value("${userLocalCache:false}")
    private boolean userLocalCache;

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public boolean get(){
        return userLocalCache;
    }

}
