package com.swp.springcloudconsulproducer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-06-19 11:48 AM
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello consul2";
    }

}
