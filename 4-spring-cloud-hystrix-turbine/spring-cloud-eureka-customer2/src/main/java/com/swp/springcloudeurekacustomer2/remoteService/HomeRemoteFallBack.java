package com.swp.springcloudeurekacustomer2.remoteService;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-06-06 5:06 PM
 */
@Component
public class HomeRemoteFallBack implements HomeRemote {


    @Override
    public String hello2(@RequestParam String name) {
        return "hello2 " + name + " it's failure request";
    }
}
