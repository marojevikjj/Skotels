package com.skotels.cloudgateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootTest
@EnableEurekaClient
@EnableHystrix
class CloudGatewayApplicationTests {

    @Test
    void contextLoads() {
    }

}
