package com.agata.routinecare.controller;

import com.agata.routinecare.dto.MedicationDTO;
import com.agata.routinecare.dto.UpdateMedDTO;
import com.agata.routinecare.entity.Medication;
import com.agata.routinecare.service.MedicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medications")
public class MedicationController {

   private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @PostMapping
    public Medication registerMedication(@RequestBody MedicationDTO medicationData) {
        return medicationService.registerMedication(medicationData);
    }

    @GetMapping
    public List<Medication> getAllMedications() {
        return medicationService.getAllMedications();
    }

    @GetMapping("/{id}")
    public Medication getMedById(@PathVariable Long id) {
        return medicationService.getMedicationById(id);
    }

    @PatchMapping("/{id}")
    public Medication updateMedication(@PathVariable Long id, @RequestBody UpdateMedDTO medChanges) {
        return medicationService.updateMedication(id, medChanges);
    }

    @DeleteMapping("/{id}")
    public void deleteMedication(@PathVariable Long id) {
        medicationService.removeMedication(id);
    }
}
