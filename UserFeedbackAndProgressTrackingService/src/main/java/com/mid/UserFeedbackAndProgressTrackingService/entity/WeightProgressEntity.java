package com.mid.UserFeedbackAndProgressTrackingService.entity;

import com.mid.UserFeedbackAndProgressTrackingService.dto.progressDto.WeightProgressDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "weight")
public class WeightProgressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long weightId;
    private Double previousWeight;
    private LocalDate previousDate;
    private Double currentWeight;
    private LocalDate presentDate;
    private String status;

    public WeightProgressDto convertToDto() {
        WeightProgressDto dto = new WeightProgressDto();
        dto.setPreviousWeight(this.getPreviousWeight());
        dto.setPreviousDate(this.getPreviousDate());
        dto.setCurrentWeight(this.getCurrentWeight());
        dto.setPresentDate(this.getPresentDate());
        dto.setStatus(this.getStatus());
        return dto;
    }
}
