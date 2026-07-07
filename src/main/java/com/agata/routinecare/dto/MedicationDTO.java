package com.agata.routinecare.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalTime;

public class MedicationDTO {

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Dosage is required")
    @Positive(message = "Dosage must be greater than zero")
    private String dosage;

    @NotNull(message = "Scheduled time is required")
    private LocalTime scheduledTime;
    private Long userId;

    public MedicationDTO() {
    }

    public MedicationDTO(String name, String dosage, LocalTime scheduledTime, Long userId) {
        this.name = name;
        this.dosage = dosage;
        this.scheduledTime = scheduledTime;
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

    public LocalTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}