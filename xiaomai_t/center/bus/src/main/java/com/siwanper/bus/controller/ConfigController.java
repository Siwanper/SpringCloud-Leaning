package com.siwanper.bus.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * DESCRIPTION：
 *
 * @ProjectName: cloud
 * @Package: com.siwanper.bus.controller
 * @Author: Siwanper
 * @CreateDate: 2020/3/23 下午11:09
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2020</p>
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @Value(("${name:111}"))
    private String name;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public boolean get(){
        return useLocalCache;
    }

    @RequestMapping(value = "/name")
    public String name(){
        return name;
    }

}
