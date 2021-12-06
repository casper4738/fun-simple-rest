package com.fun.simple.rest.ata.daily.repository;

import com.fun.simple.rest.ApiClient;
import com.fun.simple.rest.ata.daily.FunGlobal;
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
        return apiClient.createService(FunGlobal.TEAMS_WEBHOOK_INCOMING, TeamsDailyApi.class);
    }


}
