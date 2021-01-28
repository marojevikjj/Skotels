package com.skotels.hotelsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HotelsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelsServiceApplication.class, args);
    }

}
