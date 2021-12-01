package com.eurekapandhuta.discovery.PandhutaEurekaDiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PandhutaEurekaDiscoveryApplication {
	public static void main(String[] args) {
		SpringApplication.run(PandhutaEurekaDiscoveryApplication.class, args);
	}
}
