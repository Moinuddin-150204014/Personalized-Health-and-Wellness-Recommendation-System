package com.mid.FeedbackAnalysisService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeartRateProgressDto {
    private Integer previousHeartRate;
    private LocalDate previousDate;
    private Integer currentHeartRate;
    private LocalDate presentDate;
    private String status;
}
