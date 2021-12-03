package com.fun.simple.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.fun.simple.rest"})
public class FunSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FunSimpleApplication.class);
    }

}
