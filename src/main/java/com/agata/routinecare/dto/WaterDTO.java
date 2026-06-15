package com.agata.routinecare.dto;

import java.time.LocalTime;

public class WaterDTO {

    private Double amount;
    private LocalTime intakeTime;
    private Long userId;

    public WaterDTO() {
    }

    public WaterDTO(Double amount, LocalTime intakeTime, Long userId) {
        this.amount = amount;
        this.intakeTime = intakeTime;
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
