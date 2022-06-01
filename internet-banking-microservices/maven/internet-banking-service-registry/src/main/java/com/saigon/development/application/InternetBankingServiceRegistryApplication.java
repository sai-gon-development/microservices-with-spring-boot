package com.saigon.development.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaClient
@EnableEurekaServer
@SpringBootApplication
public class InternetBankingServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternetBankingServiceRegistryApplication.class, args);
	}

}
