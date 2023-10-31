package com.mid.FeedbackAnalysisService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgressDto {
    private Long progressId;
    private String userId;
    private BloodSugarLevelProgressDto bloodSugarLevelProgressDto;
    private WeightProgressDto weightProgressDto;
    private BmiProgressDto bmiProgressDto;
    private HeartRateProgressDto heartRateProgressDto;
    private LocalDate presentDate;
}
