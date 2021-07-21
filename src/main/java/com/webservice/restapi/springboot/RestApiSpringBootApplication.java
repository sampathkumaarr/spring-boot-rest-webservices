package com.webservice.restapi.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.webservice.restapi.controller")
public class RestApiSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiSpringBootApplication.class);
    }
}
