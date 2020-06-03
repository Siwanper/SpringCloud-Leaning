package com.siwanper.gateway.web;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker // 开启断路器功能
@EnableMethodCache(basePackages = "com.siwanper.gateway")
@EnableCreateCacheAnnotation
public class GatewayWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayWebApplication.class, args);
    }
}
