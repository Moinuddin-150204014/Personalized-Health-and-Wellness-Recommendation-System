package com.mid.UserFeedbackAndProgressTrackingService.service;

import com.mid.UserFeedbackAndProgressTrackingService.dto.HealthDataCurrentDto;
import com.mid.UserFeedbackAndProgressTrackingService.dto.progressDto.ProgressDto;
import com.mid.UserFeedbackAndProgressTrackingService.dto.progressDto.TotalProgressDto;
import com.mid.UserFeedbackAndProgressTrackingService.exception.NotFoundCustomException;

import java.util.List;

public interface UserProgressTrackService {

    TotalProgressDto getHealthProgressByUser(HealthDataCurrentDto healthDataCurrentDto);


    List<ProgressDto> getAllProgressDataByUserId(String userId) throws NotFoundCustomException;
}
