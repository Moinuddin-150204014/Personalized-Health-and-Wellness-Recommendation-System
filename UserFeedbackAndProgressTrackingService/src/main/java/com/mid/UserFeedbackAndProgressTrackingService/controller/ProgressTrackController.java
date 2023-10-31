package com.mid.UserFeedbackAndProgressTrackingService.controller;

import com.mid.UserFeedbackAndProgressTrackingService.dto.HealthDataCurrentDto;
import com.mid.UserFeedbackAndProgressTrackingService.dto.insightDto.InsightDto;
import com.mid.UserFeedbackAndProgressTrackingService.dto.progressDto.ProgressDto;
import com.mid.UserFeedbackAndProgressTrackingService.dto.progressDto.TotalProgressDto;
import com.mid.UserFeedbackAndProgressTrackingService.entity.ProgressEntity;
import com.mid.UserFeedbackAndProgressTrackingService.exception.NotFoundCustomException;
import com.mid.UserFeedbackAndProgressTrackingService.service.UserProgressInsightsService;
import com.mid.UserFeedbackAndProgressTrackingService.service.UserProgressTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progress")
public class ProgressTrackController {

    @Autowired
    private UserProgressTrackService userProgressTrackService;
    @Autowired
    private UserProgressInsightsService userProgressInsightsService;
    @GetMapping("/insights")
    public InsightDto insightProgress(@RequestBody HealthDataCurrentDto healthDataCurrentDto) {
        return userProgressInsightsService.getHealthProgressByUser(healthDataCurrentDto);
    }

    @GetMapping("/track")
    public TotalProgressDto trackProgress(@RequestBody HealthDataCurrentDto healthDataCurrentDto) {
        return userProgressTrackService.getHealthProgressByUser(healthDataCurrentDto);
    }

    @GetMapping("/getByUserId/{userId}")
    public List<ProgressDto> getProgressDataByUserId(@PathVariable String userId) throws NotFoundCustomException {
        return userProgressTrackService.getAllProgressDataByUserId(userId);
    }
}
