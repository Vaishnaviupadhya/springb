package com.hello.helloworld;

import org.springframework.boot.SpringApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Application2 {

    public static void main(String[] args) {
        SpringApplication.run(Application2.class, args);
    }

    @GetMapping("/api2")
    public String api2() {
        return "Hello from API 2!";
    }

}
