package com.fun.simple.rest.index;

import com.fun.simple.rest.ata.daily.retrofit.DailyWebhookRequest;
import com.fun.simple.rest.ata.daily.retrofit.TeamsDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;

import java.util.Arrays;

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private TeamsDailyService teamsDailyService;

    @GetMapping
    public String index() {
        return "Hello there! I'm running.";
    }

    @GetMapping("hello")
    public ResponseEntity<String> hello(@RequestParam(defaultValue = "test") String name) {

        Call<Integer> callService = teamsDailyService.getTeamsDailyApi().botDaily(
                DailyWebhookRequest.builder()
                        .themeColor("0076D7")
                        .summary("DAILY UPDATE - 04-12-2021")
                        .sections(Arrays.asList(
                                DailyWebhookRequest.Section.builder()
                                        .activityTitle("TESTING FROM RETROFIT")
                                        .activitySubtitle("Finish What You Start")
                                        .build()
                        ))
                        .build()
        );

        // https://howtodoinjava.com/retrofit2/retrofit-sync-async-calls/
        /*
        callService.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.isSuccessful()) {
                    Integer apiResponse = response.body();
                    System.out.println("Request onResponse success :: " + apiResponse);
                } else {
                    System.out.println("Request onResponse Error :: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                System.out.println("Network Error :: " + t.getLocalizedMessage());
            }
        });*/


        try {
            Response<Integer> response = callService.execute();
            Integer apiResponse = response.body();

            //API response
            return new ResponseEntity<>(
                    "Hello xxx apiResponse :: " + apiResponse,
                    HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("FANNN Exception "+ex);
            ex.printStackTrace();
        }

        return new ResponseEntity<>(
                "Hello " + name,
                HttpStatus.OK);
    }

}
