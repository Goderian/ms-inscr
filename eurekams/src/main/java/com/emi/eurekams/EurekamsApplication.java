package com.emi.eurekams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekamsApplication.class, args);
	}

}
