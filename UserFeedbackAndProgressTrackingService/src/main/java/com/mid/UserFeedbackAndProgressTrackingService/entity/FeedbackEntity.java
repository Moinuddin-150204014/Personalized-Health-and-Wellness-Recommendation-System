package com.mid.UserFeedbackAndProgressTrackingService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "feedback")
public class FeedbackEntity {
    @Id
    private String userId;
    private String recommendationText;
    private String feedbackText;
    private LocalDate date;
    private Integer rating;
    private String satisfaction;

}
