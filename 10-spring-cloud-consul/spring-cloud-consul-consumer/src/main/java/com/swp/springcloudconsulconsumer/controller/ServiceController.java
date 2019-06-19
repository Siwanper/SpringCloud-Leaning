package com.swp.springcloudconsulconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-06-19 12:10 PM
 */
@RestController
public class ServiceController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/services")
    public Object services(){
        return discoveryClient.getInstances("service-producer");
    }

    @RequestMapping("/discover")
    public Object discover(){
        return loadBalancerClient.choose("service-producer").getUri().toString();
    }

}
