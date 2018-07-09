package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UaaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UaaServiceApplication.class, args);
    }
}
