package com.fun.simple.rest.ata.daily.repository;

import com.fun.simple.rest.ata.daily.FunGlobal;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TeamsDailyApi {

    @POST(FunGlobal.CHANNEL.DAILY_UPDATES)
    Call<Integer> botDaily(@Body DailyWebhookRequest dailyWebhookRequest);

}
