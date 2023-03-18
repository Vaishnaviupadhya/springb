package com.hello.helloworld;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestControllerd {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/trigger")
    public String trigger() {

        // First synchronous call
        HttpHeaders headers1 = new HttpHeaders();
        headers1.set("Content-Type", "application/json");
        HttpEntity<String> requestEntity1 = new HttpEntity<String>(headers1);
        ResponseEntity<String> responseEntity1 = restTemplate.exchange("http://localhost:8081/api1", HttpMethod.GET,
                requestEntity1, String.class);
        String responseBody1 = responseEntity1.getBody();

        // Second synchronous call
        HttpHeaders headers2 = new HttpHeaders();
        headers2.set("Content-Type", "application/json");
        HttpEntity<String> requestEntity2 = new HttpEntity<String>(headers2);
        ResponseEntity<String> responseEntity2 = restTemplate.exchange("http://localhost:8082/api2", HttpMethod.GET,
                requestEntity2, String.class);
        String responseBody2 = responseEntity2.getBody();

        // Asynchronous call
        CompletableFuture.supplyAsync(() -> {
            HttpHeaders headers3 = new HttpHeaders();
            headers3.set("Content-Type", "application/json");
            HttpEntity<String> requestEntity3 = new HttpEntity<String>(headers3);
            ResponseEntity<String> responseEntity3 = restTemplate.exchange("http://localhost:8083/api3", HttpMethod.GET,
                    requestEntity3, String.class);
            String responseBody3 = responseEntity3.getBody();
            return responseBody3;
        }).thenAccept(System.out::println);
        return "Response 1: " + responseBody1 + "\nResponse 2: " + responseBody2;
    }

    @Async
    private CompletableFuture<String> callApi3Async() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8083/api3", HttpMethod.GET,
                requestEntity, String.class);
        return CompletableFuture.completedFuture(responseEntity.getBody());
    }
}
