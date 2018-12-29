package com.xiaolc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages= {"com.xiaolc"})
@ComponentScan("com.xiaolc")
public class JihConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(JihConsumerApp.class, args);
    }
}
