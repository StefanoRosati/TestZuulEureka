package com.example.routingtest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
 
@EnableDiscoveryClient 
//abilito il client come Netflix Eureka Discovery Client 
//esitono altre implemtazioni per altri Service register (Hashicorp's, Consul, Apache Zookeeper)
@SpringBootApplication
public class Routingtest2Application {

	public static void main(String[] args) {
		SpringApplication.run(Routingtest2Application.class, args);
	}

}
