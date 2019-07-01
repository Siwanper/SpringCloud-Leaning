package com.swp.servicea.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-07-01 6:08 PM
 */
@RestController
public class ProducerController {

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name") String name){
        return "hello " + name + ", i'm first producer";
    }

}
