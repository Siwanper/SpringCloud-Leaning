package com.swp.serviceb.controller;

import com.swp.serviceb.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-07-01 6:09 PM
 */
@RestController
public class CustomerController {

    @Autowired
    private ProducerService producerService;

    @Value("${msg}")
    private String msg;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable(value = "name") String name){
        return msg + " " + producerService.hello(name);
    }

}
