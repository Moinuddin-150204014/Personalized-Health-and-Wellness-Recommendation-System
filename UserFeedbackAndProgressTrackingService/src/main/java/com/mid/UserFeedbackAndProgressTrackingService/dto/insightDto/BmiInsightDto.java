package com.mid.UserFeedbackAndProgressTrackingService.dto.insightDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BmiInsightDto {
    private Double previousBmi;
    private Double currentBmi;
    private Double bmiChange;
    private Double bmiImprovement;
    private Double progressPercentage;
}
