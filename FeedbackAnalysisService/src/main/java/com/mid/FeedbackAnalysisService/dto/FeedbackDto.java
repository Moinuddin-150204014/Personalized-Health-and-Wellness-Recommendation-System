package com.mid.FeedbackAnalysisService.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDto {
    private String userId;
    private String recommendationText;
    private String feedbackText;
    private LocalDate date;
    private Integer rating;
    private String satisfaction;
}
