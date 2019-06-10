package com.swp.springcloudeurekaproducer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudEurekaProducer1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaProducer1Application.class, args);
	}

}
