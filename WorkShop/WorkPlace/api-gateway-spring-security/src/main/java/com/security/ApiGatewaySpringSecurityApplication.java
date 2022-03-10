package com.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewaySpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewaySpringSecurityApplication.class, args);
	}

}
