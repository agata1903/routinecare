package com.agata.routinecare.dto;

import java.time.LocalTime;

public class UpdateWaterDTO {

    private Double amountMl;
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
