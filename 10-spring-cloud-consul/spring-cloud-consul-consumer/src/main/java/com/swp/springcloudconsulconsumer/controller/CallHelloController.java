package com.swp.springcloudconsulconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-06-19 2:03 PM
 */
@RestController
public class CallHelloController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/call")
    public String call(){
        ServiceInstance instance = loadBalancerClient.choose("service-producer");
        System.out.println("服务地址： " + instance.getUri());
        System.out.println("服务名称： " + instance.getServiceId());

        String object = new RestTemplate().getForObject(instance.getUri().toString() + "/hello", String.class);
        return object;
    }

}
