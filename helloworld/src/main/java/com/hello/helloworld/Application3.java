package com.hello.helloworld;

import org.springframework.boot.SpringApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Application3 {

    public static void main(String[] args) {
        SpringApplication.run(Application3.class, args);
    }

    @GetMapping("/api3")
    public String api2() {
        return "Hello from API 3!";
    }

}
