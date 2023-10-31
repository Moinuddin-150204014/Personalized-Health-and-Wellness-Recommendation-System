package com.mid.UserFeedbackAndProgressTrackingService.entity;

import com.mid.UserFeedbackAndProgressTrackingService.dto.progressDto.BloodSugarLevelProgressDto;
import com.mid.UserFeedbackAndProgressTrackingService.dto.progressDto.BmiProgressDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bmi")
public class BmiProgressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bmiId;
    private Double previousBmi;
    private LocalDate previousDate;
    private Double currentBmi;
    private LocalDate presentDate;
    private String status;

    public BmiProgressDto convertToDto() {
        BmiProgressDto dto = new BmiProgressDto();
        dto.setPreviousBmi(this.getPreviousBmi());
        dto.setPreviousDate(this.getPreviousDate());
        dto.setCurrentBmi(this.getCurrentBmi());
        dto.setPresentDate(this.getPresentDate());
        dto.setStatus(this.getStatus());
        return dto;
    }
}
