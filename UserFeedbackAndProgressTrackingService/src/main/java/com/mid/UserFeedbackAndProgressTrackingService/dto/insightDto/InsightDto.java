package com.mid.UserFeedbackAndProgressTrackingService.dto.insightDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsightDto {
    private WeightInsightDto weightInsightDto;
    private BmiInsightDto bmiInsightDto;
    private HeartRateInsightDto heartRateInsightDto;
    private BloodSugarLevelInsightDto bloodSugarLevelInsightDto;
}
