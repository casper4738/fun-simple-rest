package com.fun.simple.rest.index;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {


    @GetMapping
    public String index() {
        return "Hello there! I'm running.";
    }


}
