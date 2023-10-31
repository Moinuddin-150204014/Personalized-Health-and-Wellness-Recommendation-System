package com.mid.FeedbackAnalysisService.controller;

import com.mid.FeedbackAnalysisService.dto.FeedbackDto;
import com.mid.FeedbackAnalysisService.dto.ImprovementRecommendationDto;
import com.mid.FeedbackAnalysisService.dto.ProgressDto;
import com.mid.FeedbackAnalysisService.entity.FeedbackEntity;
import com.mid.FeedbackAnalysisService.exception.NotFoundCustomException;
import com.mid.FeedbackAnalysisService.service.FeedbackService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class FeedbackAnalysisController {

    @Autowired
    private FeedbackService feedbackService;
    @GetMapping("/feedback/{userId}")
    public ResponseEntity<List<FeedbackEntity>> getUserFeedback(@PathVariable String userId) throws NotFoundCustomException{
        List<FeedbackEntity> feedbackEntities = feedbackService.getUserFeedback(userId);
        if (feedbackEntities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(feedbackEntities, HttpStatus.OK);
    }

    @GetMapping("/progress/{userId}")
    public ResponseEntity<List<ProgressDto>> getProgressDataByUserId(@PathVariable String userId) throws NotFoundCustomException {
        List<ProgressDto> progressData = feedbackService.getProgressDataByUserId(userId);
        if (progressData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(progressData, HttpStatus.OK);
    }

    @GetMapping("/recommendations/{userId}")
    public ImprovementRecommendationDto getRecommendationDataByUserId(@PathVariable String userId) throws NotFoundCustomException {
        return feedbackService.getUserFeedbackImprovement(userId);
    }
}
