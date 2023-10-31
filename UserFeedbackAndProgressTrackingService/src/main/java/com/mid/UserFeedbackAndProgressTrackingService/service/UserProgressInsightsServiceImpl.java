package com.mid.UserFeedbackAndProgressTrackingService.service;

import com.mid.UserFeedbackAndProgressTrackingService.dto.HealthDataCurrentDto;
import com.mid.UserFeedbackAndProgressTrackingService.dto.insightDto.*;
import com.mid.UserFeedbackAndProgressTrackingService.dto.SendHealthDataDto;
import com.mid.UserFeedbackAndProgressTrackingService.networkmanager.HealthDataFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProgressInsightsServiceImpl implements UserProgressInsightsService {

    @Autowired
    private HealthDataFeignClient healthDataFeignClient;

    @Override
    public InsightDto getHealthProgressByUser(HealthDataCurrentDto healthDataCurrentDto) {

        SendHealthDataDto healthDataDto = healthDataFeignClient.sendHealthData();
        InsightDto insightDto = new InsightDto();
        if (healthDataDto == null) {
            return null;
        }
        Double height = healthDataCurrentDto.getHeightCm();
        Double weight = healthDataCurrentDto.getWeightKg();
        Integer age = healthDataCurrentDto.getAge();
        Integer heartRate = healthDataCurrentDto.getHeartRate();
        Double bloodSugarLevel = healthDataCurrentDto.getBloodSugarLevel();

        insightDto.setWeightInsightDto(calculateWeightProgress(weight, healthDataDto));
        insightDto.setBmiInsightDto(calculateBmiProgress(height, weight, healthDataDto));
        insightDto.setHeartRateInsightDto(calculateHeartRateProgress(age, heartRate, healthDataDto));
        insightDto.setBloodSugarLevelInsightDto(calculateBloodSugarLevel(bloodSugarLevel, healthDataDto));

        return insightDto;
    }

    public WeightInsightDto calculateWeightProgress(Double weight, SendHealthDataDto healthDataDto){
        WeightInsightDto weightInsightDto = new WeightInsightDto();
        double initialWeight = healthDataDto.getWeightKg();
        double weightChange = weight - initialWeight;

        weightInsightDto.setCurrentWeight(weight);
        weightInsightDto.setPreviousWeight(initialWeight);
        weightInsightDto.setWeightChange(weightChange);
        weightInsightDto.setProgressPercentage(((weight - initialWeight) / initialWeight) * 100);

        return weightInsightDto;
    }

    public BmiInsightDto calculateBmiProgress(Double height, Double weight, SendHealthDataDto healthDataDto){

        double initialBmi = calculateBmi(healthDataDto.getHeightCm(), healthDataDto.getWeightKg());;
        double currentBmi = calculateBmi(height, weight);
        double bmiChange = currentBmi - initialBmi;

        BmiInsightDto bmiInsightDto = new BmiInsightDto();
        bmiInsightDto.setPreviousBmi(initialBmi);
        bmiInsightDto.setCurrentBmi(currentBmi);
        bmiInsightDto.setBmiChange(bmiChange);
        bmiInsightDto.setProgressPercentage(((currentBmi - initialBmi) / initialBmi) * 100);
        bmiInsightDto.setBmiImprovement(checkBmiImprovement(currentBmi,initialBmi));
        return bmiInsightDto;
    }

    private double calculateBmi(double heightCm, double weightKg) {
        double heightM = heightCm / 100.0;
        return weightKg / (heightM * heightM);
    }

    private Double checkBmiImprovement(Double currentBmi, Double initialBmi){

        if(Math.abs(22-currentBmi) < Math.abs(22-initialBmi)){
            return Math.abs(currentBmi-initialBmi);
        }
        else if(Math.abs(22-currentBmi) > Math.abs(22-initialBmi))
        {
            return Math.abs(currentBmi - initialBmi);
        }
        else {
            return 0.0;
        }
    }

    private BloodSugarLevelInsightDto calculateBloodSugarLevel(Double bloodSugarLevel, SendHealthDataDto healthDataDto){

        BloodSugarLevelInsightDto bloodSugarLevelInsightDto = new BloodSugarLevelInsightDto();
        Double initialBloodSugarLevel = healthDataDto.getBloodSugarLevel();

        bloodSugarLevelInsightDto.setPreviousBloodSugarLevel(initialBloodSugarLevel);
        bloodSugarLevelInsightDto.setCurrentBloodSugarLevel(bloodSugarLevel);
        bloodSugarLevelInsightDto.setBloodSugarLevelChange(bloodSugarLevel - initialBloodSugarLevel);
        bloodSugarLevelInsightDto.setProgressPercentage(((bloodSugarLevel - initialBloodSugarLevel) / initialBloodSugarLevel) * 100);

        if (bloodSugarLevel < 5.6) {
            bloodSugarLevelInsightDto.setStatus("You do not have diabetes");
        } else if (bloodSugarLevel >= 5.6 && bloodSugarLevel <= 6.9) {
            if (initialBloodSugarLevel < 5.6) {
                bloodSugarLevelInsightDto.setStatus("You have moved from not having diabetes to prediabetes.");
            } else if (initialBloodSugarLevel >= 5.6 && initialBloodSugarLevel <= 6.9) {
                bloodSugarLevelInsightDto.setStatus("You still have prediabetes.");
            } else {
                bloodSugarLevelInsightDto.setStatus("You have prediabetes.");
            }
        } else {
            if (initialBloodSugarLevel < 5.6) {
                bloodSugarLevelInsightDto.setStatus("You have diabetes.");
            } else if (initialBloodSugarLevel >= 5.6 && initialBloodSugarLevel <= 6.9) {
                bloodSugarLevelInsightDto.setStatus("You have moved from prediabetes to diabetes.");
            } else {
                bloodSugarLevelInsightDto.setStatus("You still have diabetes.");
            }
        }
        return bloodSugarLevelInsightDto;
    }

    public HeartRateInsightDto calculateHeartRateProgress(Integer userAge, Integer heartRate, SendHealthDataDto healthDataDto){
        Integer initialHeartRate = healthDataDto.getHeartRate();
        Integer heartRateChange = heartRate - initialHeartRate;

        HeartRateInsightDto heartRateInsightDto = new HeartRateInsightDto();
        heartRateInsightDto.setPreviousHeartRate(initialHeartRate);
        heartRateInsightDto.setCurrentHeartRate(heartRate);
        heartRateInsightDto.setHeartRateChange(heartRate - initialHeartRate);
        heartRateInsightDto.setProgressPercentage(((heartRate - initialHeartRate) / initialHeartRate) * 100);
        if(heartRateChange > 0)
        {
            heartRateInsightDto.setHeartRateChange(heartRateChange);
        }
        int lowerRange;
        int upperRange;

        if (userAge <= 1) {
            lowerRange = 80;
            upperRange = 190;
        } else if (userAge == 2) {
            lowerRange = 80;
            upperRange = 130;
        } else if (userAge == 3 || userAge == 4) {
            lowerRange = 80;
            upperRange = 120;
        } else if (userAge == 5 || userAge == 6) {
            lowerRange = 75;
            upperRange = 115;
        } else if (userAge >= 7 && userAge <= 9) {
            lowerRange = 70;
            upperRange = 110;
        } else {
            lowerRange = 60;
            upperRange = 100;
        }
        if (heartRate < lowerRange) {
            heartRateInsightDto.setStatus("Your heart rate is below the recommended range for your age. Consult a healthcare professional.");
        } else if (heartRate > upperRange) {
            heartRateInsightDto.setStatus("Your heart rate is above the recommended range for your age. Consult a healthcare professional.");
        } else {
            heartRateInsightDto.setStatus("Your heart rate is within the recommended range for your age. Keep up the good work!");
        }
        return heartRateInsightDto;
    }
}

