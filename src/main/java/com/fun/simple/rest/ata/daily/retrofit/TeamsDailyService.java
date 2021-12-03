package com.fun.simple.rest.ata.daily.retrofit;

import com.fun.simple.rest.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamsDailyService {

    private ApiClient apiClient;

    @Autowired
    public TeamsDailyService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public TeamsDailyApi getTeamsDailyApi() {
        return apiClient.createService(TeamsDailyApi.class);
    }


}
