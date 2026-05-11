package com.agata.routinecare.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private String dosage;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    public Medication() {
    }

    public Medication(Long id, String name, String dosage, User user) {
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.user = user;
    }

    public Medication(String name, String dosage, User user) {
        this.name = name;
        this.dosage = dosage;
        this.user = user;
    }

    public Long getId() {
        return id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}