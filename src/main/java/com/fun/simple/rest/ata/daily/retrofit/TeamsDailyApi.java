package com.fun.simple.rest.ata.daily.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TeamsDailyApi {

    @POST("09a2a87a-c42a-43a7-a67f-39e9e02b0670@59daf140-4aee-4b77-80f4-4ea8bec86c2e/IncomingWebhook/9feadc214b6c4958859a1962f0f8605f/60f381ba-197c-43a6-a2a2-259f67ae0a8e")
    Call<Integer> botDaily(@Body DailyWebhookRequest dailyWebhookRequest);

}
