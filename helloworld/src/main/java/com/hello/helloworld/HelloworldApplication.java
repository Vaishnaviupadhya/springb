package com.hello.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = { "com.hello.helloworld" })
public class HelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);

	}

	@GetMapping("/")
	public String home() {
		return "This is main";
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
