package com.swp.serviceb.controller;

import com.swp.serviceb.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/hello")
    public String hello(){
        return producerService.hello();
    }

}
