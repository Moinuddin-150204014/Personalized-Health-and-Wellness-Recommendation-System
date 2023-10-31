package com.mid.maliha.nutritionmicroservice.repository;

import com.mid.maliha.nutritionmicroservice.entity.CategoryBasedNutritionEntity;
import com.mid.maliha.nutritionmicroservice.entity.FoodInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryNutritionRepository extends JpaRepository<CategoryBasedNutritionEntity,Integer> {

    Optional<CategoryBasedNutritionEntity> findByCategory(String string);
}
