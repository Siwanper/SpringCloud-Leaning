package com.swp.springcloudeurekacustomer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SpringCloudEurekaCustomer2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaCustomer2Application.class, args);
	}

}
