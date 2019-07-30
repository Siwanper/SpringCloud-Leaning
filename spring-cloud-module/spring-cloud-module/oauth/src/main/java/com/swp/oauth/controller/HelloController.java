package com.swp.oauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-02-19 3:45 PM
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(){
        return "Hello User!";
    }

}
