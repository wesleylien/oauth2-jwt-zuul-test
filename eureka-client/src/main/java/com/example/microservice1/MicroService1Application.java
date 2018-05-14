package com.example.microservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroService1Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroService1Application.class, args);
	}
}
