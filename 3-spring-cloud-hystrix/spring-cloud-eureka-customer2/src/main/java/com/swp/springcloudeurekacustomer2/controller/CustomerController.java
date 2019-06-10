package com.swp.springcloudeurekacustomer2.controller;

import com.swp.springcloudeurekacustomer2.remoteService.HomeRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-06-06 3:24 PM
 */
@RestController
public class CustomerController {

    @Autowired
    private HomeRemote homeRemote;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable(value = "name") String name){
        return homeRemote.hello(name);
    }

}
