package com.mid.UserFeedbackAndProgressTrackingService.dto.insightDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeartRateInsightDto {
    private Integer previousHeartRate;
    private Integer currentHeartRate;
    private Integer heartRateChange;
    private Integer progressPercentage;
    private String status;
}
