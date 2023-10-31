package com.mid.UserFeedbackAndProgressTrackingService.service;

import com.mid.UserFeedbackAndProgressTrackingService.dto.HealthDataCurrentDto;
import com.mid.UserFeedbackAndProgressTrackingService.dto.insightDto.InsightDto;

public interface UserProgressInsightsService {

    InsightDto getHealthProgressByUser(HealthDataCurrentDto healthDataCurrentDto);
}
