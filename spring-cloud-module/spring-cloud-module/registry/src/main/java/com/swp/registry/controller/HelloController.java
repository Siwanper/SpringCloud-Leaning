package com.swp.registry.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-06-26 2:45 PM
 */
@RestController
public class HelloController {

    @RequestMapping("/index")
    public String hello(){
        return "hello";
    }

}
