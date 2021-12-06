package com.fun.simple.rest.ata.daily.controller;

import com.fun.simple.rest.ata.daily.dto.ATADailyInput;
import com.fun.simple.rest.ata.daily.dto.ATADailyRequest;
import com.fun.simple.rest.ata.daily.dto.ATADailyResponse;
import com.fun.simple.rest.ata.daily.service.ATADailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.http.Body;

@RestController
@RequestMapping("/api/ata")
public class ATADailyController {

	private final ATADailyService service;

	@Autowired
	public ATADailyController(ATADailyService service) {
		this.service = service;
	}

	@PostMapping("daily/teams")
	public ResponseEntity<ATADailyResponse> dailyTeams(@Body ATADailyRequest request) {
		return new ResponseEntity<>(
				ATADailyResponse.builder()
						.result(service.dailyTeams(ATADailyInput.builder()
								.themeColor(request.getThemeColor())
								.title(request.getTitle())
								.subtitle(request.getSubtitle())
								.build()) ? "success" : "failed")
						.build(),
				HttpStatus.OK);

	}

}
