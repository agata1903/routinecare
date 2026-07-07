package com.agata.routinecare.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalTime;

public class UpdateWaterDTO {

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than zero")
    private Double amountMl;

    @NotNull(message = "Intake time is required")
    private LocalTime intakeTime;

    public UpdateWaterDTO() {
    }

    public UpdateWaterDTO(Double amountMl, LocalTime intakeTime) {
        this.amountMl = amountMl;
        this.intakeTime = intakeTime;
    }

    public Double getAmountMl() {
        return amountMl;
    }

    public void setAmountMl(Double amountMl) {
        this.amountMl = amountMl;
    }

    public LocalTime getIntakeTime() {
        return intakeTime;
    }

    public void setIntakeTime(LocalTime intakeTime) {
        this.intakeTime = intakeTime;
    }
}
