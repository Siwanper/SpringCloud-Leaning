package com.swp.springcloudeurekacustom.RemoteService;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-06-06 3:11 PM
 */
@Component
public class HomeRemoteHystrixFallBack implements HomeRemote {

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "hello, " + name +"it's a failure request";
    }
}
