package com.agata.routinecare.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

@Entity
public class WaterIntake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double amountMl;

    @NotNull
    private LocalTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    public WaterIntake() {
    }

    public WaterIntake(Long id, Double amountMl, LocalTime createdAt, User user) {
        this.id = id;
        this.amountMl = amountMl;
        this.createdAt = createdAt;
        this.user = user;
    }

    public WaterIntake(Double amountMl, LocalTime createdAt, User user) {
        this.amountMl = amountMl;
        this.createdAt = createdAt;
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

    public LocalTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}