package com.agata.routinecare.dto;

import com.agata.routinecare.entity.User;

public class MedicationDTO {

    private String name;
    private String dosage;
    private Long userId;

    public MedicationDTO() {
    }

    public MedicationDTO(String name, String dosage, Long userId) {
        this.name = name;
        this.dosage = dosage;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}