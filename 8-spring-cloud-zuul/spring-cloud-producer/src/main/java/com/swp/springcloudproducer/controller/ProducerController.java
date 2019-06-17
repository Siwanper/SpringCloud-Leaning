package com.swp.springcloudproducer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-06-11 11:22 AM
 */
@RestController
public class ProducerController {

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name") String name){
        return "hello " + name + " , I'm first visitor";
    }

}
