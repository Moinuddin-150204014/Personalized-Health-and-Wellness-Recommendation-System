package com.mid.UserFeedbackAndProgressTrackingService.repository;

import com.mid.UserFeedbackAndProgressTrackingService.entity.ProgressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProgressRepository extends JpaRepository<ProgressEntity, Long> {
    /*@Query("SELECT p FROM ProgressEntity p " +
            "LEFT JOIN FETCH p.bloodSugarLevelProgressEntity " +
            "LEFT JOIN FETCH p.weightProgressEntity " +
            "LEFT JOIN FETCH p.bmiProgressEntity " +
            "LEFT JOIN FETCH p.heartRateProgressEntity " +
            "WHERE p.userId = :userId")*/
    List<ProgressEntity> findByUserId(String userId);
}
