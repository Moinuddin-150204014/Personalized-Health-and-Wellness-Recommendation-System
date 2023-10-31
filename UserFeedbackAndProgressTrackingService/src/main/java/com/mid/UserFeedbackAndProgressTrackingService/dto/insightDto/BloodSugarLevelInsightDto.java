package com.mid.UserFeedbackAndProgressTrackingService.dto.insightDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodSugarLevelInsightDto {
    private Double previousBloodSugarLevel;
    private Double currentBloodSugarLevel;
    private Double bloodSugarLevelChange;
    private Double progressPercentage;
    private String status;
}
