package com.siwanper.gateway.admin;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.config.GatewayClassPathWarningAutoConfiguration;

/**
 * GatewayClassPathWarningAutoConfiguration
 * 同时引入spring-boot-starter-web和spring-cloud-gateway-core会有warning
 */
@SpringBootApplication(exclude = GatewayClassPathWarningAutoConfiguration.class)
@EnableDiscoveryClient
@EnableCircuitBreaker // 开启断路器功能
@EnableMethodCache(basePackages = "com.siwanper.gateway")
@EnableCreateCacheAnnotation
public class GatewayAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayAdminApplication.class, args);
	}

}
