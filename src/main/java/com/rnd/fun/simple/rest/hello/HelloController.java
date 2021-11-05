package com.rnd.fun.simple.rest.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @Value("${name}")
    private String name;

    @GetMapping
    public ResponseEntity<String> hello(@RequestParam(defaultValue = "test") String name) {
        return new ResponseEntity<>(
                "Hello " + name,
                HttpStatus.OK);
    }

    @GetMapping("test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>(
                "Hello Test " + name,
                HttpStatus.OK);
    }

}
