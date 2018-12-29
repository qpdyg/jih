package com.xiaolc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication
@MapperScan(value = "com.xiaolc.mapper")
@ServletComponentScan("com.xiaolc.config")
@EnableSwagger2
public class Jih_ManagerApp {
    public static void main(String[] args) {
        SpringApplication.run(Jih_ManagerApp.class, args);
    }
}
