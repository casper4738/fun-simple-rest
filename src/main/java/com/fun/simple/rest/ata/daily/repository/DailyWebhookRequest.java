package com.fun.simple.rest.ata.daily.repository;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.LowerCaseStrategy.class)
public class DailyWebhookRequest {
    private String themeColor;
    private String summary;
    private List<Section> sections;

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategy.LowerCaseStrategy.class)
    static public class Section {
        private String activityTitle;
        private String activitySubtitle;
    }

}
