package com.mid.FeedbackAnalysisService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImprovementRecommendationDto {
    private String userId;
    private String improvementStatus;
    private String recommendationText;
}
