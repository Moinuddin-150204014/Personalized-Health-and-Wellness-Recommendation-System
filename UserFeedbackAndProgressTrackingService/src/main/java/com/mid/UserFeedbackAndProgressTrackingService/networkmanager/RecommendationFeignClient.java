package com.mid.UserFeedbackAndProgressTrackingService.networkmanager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "recommendation-service", configuration = FeignClientConfiguration.class)
public interface RecommendationFeignClient {
    @GetMapping("/recommendations/get-recommendation-text")
    String getRecommendationText();
}
