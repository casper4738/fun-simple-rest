package com.rnd.fun.simple.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.rnd.sample.unittest"})
public class FunSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FunSimpleApplication.class);
    }

}
