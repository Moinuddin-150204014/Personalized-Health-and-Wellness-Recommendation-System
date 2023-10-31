package com.mid.UserFeedbackAndProgressTrackingService.entity;

import com.mid.UserFeedbackAndProgressTrackingService.dto.progressDto.BloodSugarLevelProgressDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "blood_sugar_level")
public class BloodSugarLevelProgressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bloodSugarLevelId;
    private Double previousBloodSugarLevel;
    private LocalDate previousDate;
    private Double currentBloodSugarLevel;
    private LocalDate presentDate;
    private String status;
    public BloodSugarLevelProgressDto convertToDto() {
        BloodSugarLevelProgressDto dto = new BloodSugarLevelProgressDto();
        dto.setPreviousBloodSugarLevel(this.getPreviousBloodSugarLevel());
        dto.setPreviousDate(this.getPreviousDate());
        dto.setCurrentBloodSugarLevel(this.getCurrentBloodSugarLevel());
        dto.setPresentDate(this.getPresentDate());
        dto.setStatus(this.getStatus());
        return dto;
    }
}
