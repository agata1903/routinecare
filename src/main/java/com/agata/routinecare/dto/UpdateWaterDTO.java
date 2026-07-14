package com.agata.routinecare.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;

import java.time.LocalTime;

public class UpdateWaterDTO {

    @Schema(description = "Water amount in milimeters",
            example = "200.0")
    @Positive(message = "Amount must be greater than zero")
    private Double amountMl;

    @Schema(description = "Water intake time",
            example = "05:00:00")
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
