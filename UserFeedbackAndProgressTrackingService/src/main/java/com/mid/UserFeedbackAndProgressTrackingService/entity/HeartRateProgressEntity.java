package com.mid.UserFeedbackAndProgressTrackingService.entity;

import com.mid.UserFeedbackAndProgressTrackingService.dto.progressDto.BmiProgressDto;
import com.mid.UserFeedbackAndProgressTrackingService.dto.progressDto.HeartRateProgressDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "heart_rate")
public class HeartRateProgressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long heartRateId;
    private Integer previousHeartRate;
    private LocalDate previousDate;
    private Integer currentHeartRate;
    private LocalDate presentDate;
    private String status;

    public HeartRateProgressDto convertToDto() {
        HeartRateProgressDto dto = new HeartRateProgressDto();
        dto.setPreviousHeartRate(this.getPreviousHeartRate());
        dto.setPreviousDate(this.getPreviousDate());
        dto.setCurrentHeartRate(this.getCurrentHeartRate());
        dto.setPresentDate(this.getPresentDate());
        dto.setStatus(this.getStatus());
        return dto;
    }
}
