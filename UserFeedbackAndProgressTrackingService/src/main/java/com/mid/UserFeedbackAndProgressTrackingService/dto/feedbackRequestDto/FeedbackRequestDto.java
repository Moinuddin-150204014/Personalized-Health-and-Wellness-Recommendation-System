package com.mid.UserFeedbackAndProgressTrackingService.dto.feedbackRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackRequestDto {

    private String userId;
    private String recommendationText;
    private String feedbackText;
    private LocalDate date;
    private Integer rating;
    private String satisfaction;
}
