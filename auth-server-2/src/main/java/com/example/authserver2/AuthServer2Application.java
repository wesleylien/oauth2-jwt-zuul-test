package com.example.authserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthServer2Application {

	public static void main(String[] args) {
		SpringApplication.run(AuthServer2Application.class, args);
	}
}
