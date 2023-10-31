package com.mid.UserFeedbackAndProgressTrackingService.dto.insightDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeightInsightDto {
    private Double previousWeight;
    private Double currentWeight;
    private Double weightChange;
    private Double progressPercentage;
}
