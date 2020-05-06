package com.example.ribbonclientmsaugusto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RibbonClientMsAugustoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonClientMsAugustoApplication.class, args);
	}

}
