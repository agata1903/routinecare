package com.agata.routinecare.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

@Entity
public class MedicationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medication_id")
    @NotNull
    private Medication medication;

    @NotNull
    private LocalTime takenAt;

    public MedicationRecord() {
    }

    public MedicationRecord(Long id, Medication medication, LocalTime takenAt) {
        this.id = id;
        this.medication = medication;
        this.takenAt = takenAt;
    }

    public MedicationRecord(Medication medication, LocalTime takenAt) {
        this.medication = medication;
        this.takenAt = takenAt;
    }

    public Long getId() {
        return id;
    }

    public LocalTime getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(LocalTime takenAt) {
        this.takenAt = takenAt;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

}
