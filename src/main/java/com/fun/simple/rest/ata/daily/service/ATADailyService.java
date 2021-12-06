package com.fun.simple.rest.ata.daily.service;

import com.fun.simple.rest.ata.daily.dto.ATADailyInput;
import com.fun.simple.rest.ata.daily.repository.DailyWebhookRequest;
import com.fun.simple.rest.ata.daily.repository.TeamsDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class ATADailyService {

    private final TeamsDailyService teamsDailyService;

    @Autowired
    public ATADailyService(TeamsDailyService teamsDailyService) {
        this.teamsDailyService = teamsDailyService;
    }

    public boolean dailyTeams(ATADailyInput input) {
        try {
            Call<Integer> callService = teamsDailyService.getTeamsDailyApi().botDaily(
                DailyWebhookRequest.builder()
                    .themeColor(input.getThemeColor())
                    .summary(input.getTitle())
                    .sections(Arrays.asList(
                        DailyWebhookRequest.Section.builder()
                            .activityTitle(input.getTitle())
                            .activitySubtitle(input.getSubtitle())
                            .build()
                    ))
                    .build()
            );

            Response<Integer> response = callService.execute();
            Integer bodyResponse = response.body();
            return bodyResponse == 1;
        } catch (Exception ex) {
            return false;
        }

    }

}
