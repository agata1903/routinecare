package com.agata.routinecare.controller;

import com.agata.routinecare.dto.MedicationDTO;
import com.agata.routinecare.dto.UpdateMedDTO;
import com.agata.routinecare.entity.Medication;
import com.agata.routinecare.service.MedicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Medication", description = "Operations related to medications")
@RestController
@RequestMapping("/medications")
public class MedicationController {

   private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @Operation(summary = "Register a new medication")
    @PostMapping
    public Medication registerMedication(@Valid @RequestBody MedicationDTO medicationData) {
        return medicationService.registerMedication(medicationData);
    }

    @Operation(summary = "List all medications")
    @GetMapping
    public List<Medication> getAllMedications() {
        return medicationService.getAllMedications();
    }

    @Operation(summary = "Search a medication by its id")
    @GetMapping("/{id}")
    public Medication getMedById(@PathVariable Long id) {
        return medicationService.getMedicationById(id);
    }

    @Operation(summary = "Change a medication information")
    @PatchMapping("/{id}")
    public Medication updateMedication(@PathVariable("id") Long id, @Valid @RequestBody UpdateMedDTO medChanges) {
        return medicationService.updateMedication(id, medChanges);
    }

    @Operation(summary = "Delete a medication information")
    @DeleteMapping("/{id}")
    public void deleteMedication(@PathVariable("id") Long id) {
        medicationService.removeMedication(id);
    }
}
