package com.agata.routinecare.controller;

import com.agata.routinecare.dto.MedicationDTO;
import com.agata.routinecare.dto.UpdateDTO;
import com.agata.routinecare.entity.Medication;
import com.agata.routinecare.entity.User;
import com.agata.routinecare.repository.MedicationRepository;
import com.agata.routinecare.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medications")
public class MedicationController {

    private final MedicationRepository medicationRepository;
    private final UserRepository userRepository;
    
    public MedicationController(MedicationRepository medicationRepository, UserRepository userRepository) {
        this.medicationRepository = medicationRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    public Medication registerMedication(@Valid @RequestBody MedicationDTO request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found"));

        Medication medication = new Medication();
        medication.setName(request.getName());
        medication.setDosage(request.getDosage());
        medication.setScheduledTime(request.getScheduledTime());
        medication.setUser(user);

        return medicationRepository.save(medication);
    }
    
    @GetMapping("/{id}")
    public Medication getMedicationById(@PathVariable Long id) {
        return medicationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medication not found"));
    }

    @GetMapping
    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeMedication(@PathVariable Long id) {
        Medication medication = medicationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medication not found"));

        medicationRepository.delete(medication);
    }

    @PatchMapping("/{id}")
    public Medication updateMedication(@PathVariable Long id, @RequestBody UpdateDTO update) {
        Medication medication = medicationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medication not found"));

        if (update.getName() != null) {
            medication.setName(update.getName());
        }

        if (update.getDosage() != null) {
            medication.setDosage(update.getDosage());
        }

        if (update.getScheduledTime() != null) {
            medication.setScheduledTime(update.getScheduledTime());
        }
        return medicationRepository.save(medication);
    }
}
