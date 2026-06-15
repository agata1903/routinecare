package com.agata.routinecare.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class WaterIntake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double amountMl;

    @NotNull
    private LocalDate intakeDate;

    @NotNull
    private LocalTime intakeTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    public WaterIntake() {
    }

    public WaterIntake(Long id, Double amountMl, LocalDate intakeDate, LocalTime intakeTime, User user) {
        this.id = id;
        this.amountMl = amountMl;
        this.intakeDate = intakeDate;
        this.intakeTime = intakeTime;
        this.user = user;
    }

    public WaterIntake(Double amountMl, LocalDate intakeDate, LocalTime intakeTime, User user) {
        this.amountMl = amountMl;
        this.intakeDate = intakeDate;
        this.intakeTime = intakeTime;
        this.user = user;
    }
    
    public Long getId() {
        return id;
    }

    public Double getAmountMl() {
        return amountMl;
    }

    public void setAmountMl(Double amountMl) {
        this.amountMl = amountMl;
    }

    public LocalDate getIntakeDate() {
        return intakeDate;
    }

    public void setIntakeDate(LocalDate intakeDate) {
        this.intakeDate = intakeDate;
    }

    public LocalTime getIntakeTime() {
        return intakeTime;
    }

    public void setIntakeTime(LocalTime intakeTime) {
        this.intakeTime = intakeTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}