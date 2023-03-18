package com.hello.helloworld;

import org.springframework.boot.SpringApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Application1 {
    public static void main(String[] args) {
        SpringApplication.run(Application1.class, args);
    }

    @GetMapping("/api1")
    public String api1() {
        return "Hello from API 1!";
    }

}
