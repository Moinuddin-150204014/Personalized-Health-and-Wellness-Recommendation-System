package com.mid.FeedbackAnalysisService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackEntity {

    private String userId;
    private String feedbackText;
    private String recommendationText;
    private LocalDate date;
    private Integer rating;
    private String satisfaction;
}
