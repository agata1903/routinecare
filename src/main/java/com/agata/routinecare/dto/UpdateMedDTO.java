package com.agata.routinecare.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;

import java.time.LocalTime;

public class UpdateMedDTO {

    @Schema(description = "Medication name",
            example = "Dipirona")
    private String name;

    @Schema(description = "Medication dosage",
            example = "1g")
    @Positive(message = "Dosage must be greater than zero")
    private String dosage;

    @Schema(description = "Medication scheduled time", example = "14:00:00")
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
