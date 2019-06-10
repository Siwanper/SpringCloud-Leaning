package com.swp.springcloudeurekahystrixturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
public class SpringCloudEurekaHystrixTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaHystrixTurbineApplication.class, args);
	}

}
