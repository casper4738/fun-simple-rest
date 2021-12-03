package com.fun.simple.rest.ata.daily.controller;

import com.fun.simple.rest.ata.daily.dto.LoginRequest;
import com.fun.simple.rest.ata.daily.service.ATADailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/login")
public class ATADailyController {

    @Autowired
    private ATADailyService loginService;

    @PostMapping
    public ResponseEntity<Boolean> login(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(
                loginService.login(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                ),
                HttpStatus.OK);
    }

}
