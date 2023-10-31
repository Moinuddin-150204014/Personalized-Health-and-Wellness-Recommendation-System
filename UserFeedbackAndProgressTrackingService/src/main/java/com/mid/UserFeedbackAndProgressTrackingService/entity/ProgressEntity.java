package com.mid.UserFeedbackAndProgressTrackingService.entity;

import com.mid.UserFeedbackAndProgressTrackingService.dto.progressDto.ProgressDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_progress")
public class ProgressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long progressId;
    private String userId;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BloodSugarLevelProgressEntity bloodSugarLevelProgressEntity;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private WeightProgressEntity weightProgressEntity;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BmiProgressEntity bmiProgressEntity;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private HeartRateProgressEntity heartRateProgressEntity;
    private LocalDate presentDate;

    public ProgressDto convertToDto() {
        ProgressDto dto = new ProgressDto();
        dto.setProgressId(this.getProgressId());
        dto.setUserId(this.getUserId());
        dto.setBloodSugarLevelProgressDto(this.getBloodSugarLevelProgressEntity().convertToDto());
        dto.setBmiProgressDto(this.getBmiProgressEntity().convertToDto());
        dto.setHeartRateProgressDto(this.getHeartRateProgressEntity().convertToDto());
        dto.setWeightProgressDto(this.getWeightProgressEntity().convertToDto());
        dto.setPresentDate(this.getPresentDate());
        return dto;
    }
}
