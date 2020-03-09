package com.swp.nacos.nacosconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-03-09 2:55 PM
 */
@RestController
public class TestController {


    private RestTemplate restTemplate;

    @Autowired
    public TestController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String test(@PathVariable String string){
        return restTemplate.getForObject("http://nacos-provider/echo/" + string, String.class);
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "hello world";
    }

}
