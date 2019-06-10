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
@RefreshScope // 会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中
public class HelloController {

    @Value("${swp.name}")
    private String environment;

    @RequestMapping("/hello")
    public String hello(){
        return this.environment;
    }

}
