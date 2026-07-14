package com.agata.routinecare.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalTime;

public class WaterDTO {

    @Schema(description = "Water amount in milimeters",
            example = "200.0")
    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than zero")
    private Double amountMl;

    @Schema(description = "Water intake time",
            example = "05:00:00")
    @NotNull(message = "Intake time is required")
    private LocalTime intakeTime;

    @NotNull(message = "User id is required")
    private Long userId;

    public WaterDTO() {
    }

    public WaterDTO(Double amount, LocalTime intakeTime, Long userId) {
        this.amountMl = amount;
        this.intakeTime = intakeTime;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
