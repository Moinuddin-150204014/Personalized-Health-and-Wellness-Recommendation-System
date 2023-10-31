package com.mid.FeedbackAnalysisService.service;

import com.mid.FeedbackAnalysisService.dto.ImprovementRecommendationDto;
import com.mid.FeedbackAnalysisService.dto.ProgressDto;
import com.mid.FeedbackAnalysisService.entity.FeedbackEntity;
import com.mid.FeedbackAnalysisService.exception.NotFoundCustomException;
import com.mid.FeedbackAnalysisService.networkmanager.HealthDataFeignClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private HealthDataFeignClient healthDataFeignClient;

    @Override
    public List<FeedbackEntity> getUserFeedback(String userId) throws NotFoundCustomException {
        try {
            return healthDataFeignClient.getUserFeedback(userId);
        } catch (FeignException.NotFound ex) {
            throw new NotFoundCustomException("User not found.");
        }
    }

    @Override
    public List<ProgressDto> getProgressDataByUserId(String userId) throws NotFoundCustomException {
        try {
            return healthDataFeignClient.getProgressDataByUserId(userId);
        } catch (FeignException.NotFound ex) {
            throw new NotFoundCustomException("User not found.");
        }
    }

    @Override
    public ImprovementRecommendationDto getUserFeedbackImprovement(String userId) throws NotFoundCustomException {
        List<FeedbackEntity> returned = healthDataFeignClient.getUserFeedback(userId);
        if (returned.isEmpty()) {
            throw new NotFoundCustomException("User not found.");
        }
        ImprovementRecommendationDto improvementRecommendationDto = new ImprovementRecommendationDto();
        improvementRecommendationDto.setUserId(userId);
        improvementRecommendationDto.setImprovementStatus(checkImprovement(returned));
        improvementRecommendationDto.setRecommendationText(returned.get(0).getRecommendationText());
        return improvementRecommendationDto;
    }

    public String checkImprovement(List<FeedbackEntity> returned) {
        String improvement = "";
        Integer rating = returned.get(0).getRating();
        if (rating == 5) {
            improvement += "Perfect Recommendation. Do not need to improve.";
        } else if (rating >= 4) {
            improvement += "Good Recommendation. Slight improvement needed.";
        } else if (rating >= 2) {
            improvement += "Massive Improvement needed.";
        } else {
            improvement += "Very bad recommendation. Full improvement needed.";
        }
        return improvement;
    }

}
