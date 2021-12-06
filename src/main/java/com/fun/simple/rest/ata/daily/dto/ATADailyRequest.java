package com.fun.simple.rest.ata.daily.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.LowerCaseStrategy.class)
public class ATADailyRequest {
    private String themeColor = "0076D7";
    private String title;
    private String subtitle;

}
