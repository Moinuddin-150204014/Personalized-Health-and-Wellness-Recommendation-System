package com.mid.maliha.nutritionmicroservice.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_information")
public class UserInformationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userId;
    private String category;
    public UserInformationEntity() {
    }

    public UserInformationEntity(Integer id, String userId, String mood, String category, LocalDate currentDate) {
        this.id = id;
        this.userId = userId;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String medicalCategory) {
        this.category = medicalCategory;
    }

}
