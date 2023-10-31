package com.mid.FeedbackAnalysisService.service;

import com.mid.FeedbackAnalysisService.dto.ImprovementRecommendationDto;
import com.mid.FeedbackAnalysisService.dto.ProgressDto;
import com.mid.FeedbackAnalysisService.entity.FeedbackEntity;
import com.mid.FeedbackAnalysisService.exception.NotFoundCustomException;
import org.aspectj.weaver.ast.Not;

import java.util.List;

public interface FeedbackService {

    List<FeedbackEntity> getUserFeedback(String userId) throws NotFoundCustomException;

    List<ProgressDto> getProgressDataByUserId(String userId) throws NotFoundCustomException;

    ImprovementRecommendationDto getUserFeedbackImprovement(String userId) throws NotFoundCustomException;
}
