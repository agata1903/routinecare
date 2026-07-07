package com.agata.routinecare.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalTime;

public class UpdateMedDTO {

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Dosage is required")
    @Positive(message = "Dosage must be greater than zero")
    private String dosage;

    @NotNull(message = "Schedule time is required")
    private LocalTime scheduledTime;

    public UpdateMedDTO() {
    }

    public UpdateMedDTO(String name, String dosage, LocalTime scheduledTime) {
        this.name = name;
        this.dosage = dosage;
        this.scheduledTime = scheduledTime;
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
}
