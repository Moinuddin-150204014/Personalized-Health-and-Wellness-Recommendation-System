package com.mid.maliha.nutritionmicroservice.service;

import com.mid.maliha.nutritionmicroservice.dto.*;
import com.mid.maliha.nutritionmicroservice.entity.CategoryBasedNutritionEntity;
import com.mid.maliha.nutritionmicroservice.entity.FoodInformationEntity;
import com.mid.maliha.nutritionmicroservice.entity.UserInformationEntity;
import com.mid.maliha.nutritionmicroservice.exception.FoodNotFound;
import com.mid.maliha.nutritionmicroservice.networkmanager.UserFeignClient;
import com.mid.maliha.nutritionmicroservice.repository.CategoryNutritionRepository;
import com.mid.maliha.nutritionmicroservice.repository.FoodInformationRepository;
import com.mid.maliha.nutritionmicroservice.repository.UserInformationRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NutritionService {
    @Autowired
    private FoodInformationRepository foodInformationRepository;

    @Autowired
    private CategoryNutritionRepository categoryNutritionRepository;

    @Autowired
    private UserInformationRepository userInformationRepository;

    @Autowired
    private UserFeignClient userFeignClient;



    public List<FoodRecipeDTO> getAllFoodRecipe(){
        List<FoodRecipeDTO> foodRecipeDTOList=new ArrayList<>();
        for(FoodInformationEntity foodInformationEntity:foodInformationRepository.findAll()){
            foodRecipeDTOList.add(new ModelMapper().map(foodInformationEntity,FoodRecipeDTO.class));
        }
        return foodRecipeDTOList.stream()
                .sorted(Comparator.comparing(FoodRecipeDTO::getFood))
                .collect(Collectors.toList());
    }

    public FoodRecipeDTO getFoodRecipe (String food) throws FoodNotFound {
        if(foodInformationRepository.existsByFood(food)){
            return new ModelMapper().map(foodInformationRepository.findByFood(food).get(),FoodRecipeDTO.class);
        }
        throw new FoodNotFound();
    }
    public List<FoodNutritionDTO> getAllFoodNutrition(){
        List<FoodNutritionDTO> foodNutritionDTOList=new ArrayList<>();
        for(FoodInformationEntity foodInformationEntity:foodInformationRepository.findAll()){
            foodNutritionDTOList.add(new ModelMapper().map(foodInformationEntity, FoodNutritionDTO.class));
        }
        return foodNutritionDTOList.stream()
                .sorted(Comparator.comparing(FoodNutritionDTO::getFood))
                .collect(Collectors.toList());
    }
    public FoodNutritionDTO getFoodNutrition (String food) throws FoodNotFound {
        if(foodInformationRepository.existsByFood(food)){
            return new ModelMapper().map(foodInformationRepository.findByFood(food).orElseThrow(() -> new NullPointerException("No exercise")),FoodNutritionDTO.class);
        }
        throw new FoodNotFound();
    }
    public FoodNutritionDTO getFoodNutritionById (Integer foodId) throws FoodNotFound {
        if(foodInformationRepository.existsById(foodId)){
            return new ModelMapper().map(foodInformationRepository.findById(foodId).orElseThrow(() -> new NullPointerException("No exercise")),FoodNutritionDTO.class);
        }
        throw new FoodNotFound();
    }

    public Boolean setCategory(MedicalConditionDTO medicalConditionDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        String userId=userFeignClient.getUserByEmail(userEmail).getId();
        if(userInformationRepository.existsByUserId(userId)){
            return false;
        }
        SendHealthDataDto healthDataDto=userFeignClient.sendHealthData();
        UserInformationEntity userInformationEntity=new UserInformationEntity();
        userInformationEntity.setUserId(userId);

        Double blood_sugar=healthDataDto.getBloodSugarLevel();
        Integer highBloodPressure=0;
        if (medicalConditionDTO.getBpLow()<=85 && medicalConditionDTO.getBpLow()<=125){
            highBloodPressure=0;
        }
        else {
            highBloodPressure=1;
        }
        if(medicalConditionDTO.getAllergy()==0 && blood_sugar<=7 && highBloodPressure==0){
            userInformationEntity.setCategory("Normal");
            userInformationRepository.save(userInformationEntity);
        }
        else if(medicalConditionDTO.getAllergy()==0 && blood_sugar<=7 && highBloodPressure==1){
            userInformationEntity.setCategory("HighBP");
            userInformationRepository.save(userInformationEntity);
        }
        else if(medicalConditionDTO.getAllergy()==0 && blood_sugar>7 && highBloodPressure==0){
            userInformationEntity.setCategory("Diabetic");
            userInformationRepository.save(userInformationEntity);
        }
        else if(medicalConditionDTO.getAllergy()==1 && blood_sugar<=7 && highBloodPressure==0){
            userInformationEntity.setCategory("Allergy");
            userInformationRepository.save(userInformationEntity);
        }
        else if(medicalConditionDTO.getAllergy()==0 && blood_sugar>7 && highBloodPressure==1){
            userInformationEntity.setCategory("Diabetic & HighBP");
            userInformationRepository.save(userInformationEntity);
        }
        else if(medicalConditionDTO.getAllergy()==1 && blood_sugar>7 && highBloodPressure==0){
            userInformationEntity.setCategory("Allergy & Diabetic");
            userInformationRepository.save(userInformationEntity);
        }

        else if(medicalConditionDTO.getAllergy()==1 && blood_sugar<=7 && highBloodPressure==1){
            userInformationEntity.setCategory("Allergy & HighBP");
            userInformationRepository.save(userInformationEntity);
        }

        else if(medicalConditionDTO.getAllergy()==1 && blood_sugar>7 && highBloodPressure==1){
            userInformationEntity.setCategory("Allergy, Diabetic & HighBP");
            userInformationRepository.save(userInformationEntity);
        }
        return true;
    }
    public CategoryBasedNutritionDTO categoryBasedMenu(Integer categoryId) throws FoodNotFound{
        CategoryBasedNutritionEntity categoryBasedNutritionEntity=categoryNutritionRepository.findById(categoryId).get();
        List<FoodNutritionDTO> foodNutritionDTOList=new ArrayList<>();
        for (FoodInformationEntity foodInformationEntity:categoryBasedNutritionEntity.getFoodNutritionEntityList())
            foodNutritionDTOList.add(new ModelMapper().map(foodInformationEntity,FoodNutritionDTO.class));
        CategoryBasedNutritionDTO categoryBasedNutritionDTO=new ModelMapper().map(categoryBasedNutritionEntity,CategoryBasedNutritionDTO.class);
        categoryBasedNutritionDTO.setMenuList(foodNutritionDTOList);
        return categoryBasedNutritionDTO;

    }
    public NutritionRecommendationDTO categoryBasedRecommendation() throws FoodNotFound{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        String userId=userFeignClient.getUserByEmail(userEmail).getId();
        if(userInformationRepository.existsByUserId(userId)){
            CategoryBasedNutritionEntity categoryBasedNutritionEntity=categoryNutritionRepository.findByCategory(userInformationRepository.findByUserId(userId).get().getCategory()).get();
            return new ModelMapper().map(categoryBasedNutritionEntity,NutritionRecommendationDTO.class);
        }
        throw new FoodNotFound();
    }
    public CategoryBasedNutritionDTO categoryBasedNutrition(String category) throws FoodNotFound{
        CategoryBasedNutritionEntity categoryBasedNutritionEntity=categoryNutritionRepository.findByCategory(category).get();
        List<FoodNutritionDTO> foodNutritionDTOList=new ArrayList<>();
        for (FoodInformationEntity foodInformationEntity:categoryBasedNutritionEntity.getFoodNutritionEntityList())
            foodNutritionDTOList.add(new ModelMapper().map(foodInformationEntity,FoodNutritionDTO.class));
        CategoryBasedNutritionDTO categoryBasedNutritionDTO=new ModelMapper().map(categoryBasedNutritionEntity,CategoryBasedNutritionDTO.class);
        categoryBasedNutritionDTO.setMenuList(foodNutritionDTOList);
        return categoryBasedNutritionDTO;

    }

}
