package com.mid.mentalhealthmicroservice.dto;

import java.util.List;

public class MentalHealthRecommendationDTO {
    private String recommendation;

    private List<String> exercises;

    public MentalHealthRecommendationDTO() {
    }
    public MentalHealthRecommendationDTO(String recommendation,List<String> exercises) {
        this.recommendation = recommendation;
        this.exercises= exercises;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public List<String> getExercises() {
        return exercises;
    }

    public void setExercises(List<String> exercises) {
        this.exercises = exercises;
    }
}
