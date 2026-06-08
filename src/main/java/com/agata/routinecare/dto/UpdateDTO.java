package com.agata.routinecare.dto;

import java.time.LocalTime;

public class UpdateDTO {

    private String name;
    private String dosage;
    private LocalTime scheduledTime;

    public UpdateDTO() {
    }

    public UpdateDTO(String name, String dosage, LocalTime scheduledTime) {
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
