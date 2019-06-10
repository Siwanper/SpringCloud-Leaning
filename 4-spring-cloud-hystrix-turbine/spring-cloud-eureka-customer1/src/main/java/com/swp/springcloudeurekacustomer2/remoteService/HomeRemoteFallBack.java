package com.swp.springcloudeurekacustomer2.remoteService;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-06-06 4:59 PM
 */
@Component
public class HomeRemoteFallBack implements HomeRemote {

    @Override
    public String hello1(@RequestParam String name) {
        return "hello1 " + name + " , it's failure request";
    }
}
