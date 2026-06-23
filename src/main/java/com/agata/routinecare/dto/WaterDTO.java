package com.agata.routinecare.dto;

import java.time.LocalTime;

public class WaterDTO {

    private Double amountMl;
    private LocalTime intakeTime;
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
