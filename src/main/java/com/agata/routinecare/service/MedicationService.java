package com.agata.routinecare.service;

import com.agata.routinecare.dto.MedicationDTO;
import com.agata.routinecare.dto.UpdateMedDTO;
import com.agata.routinecare.entity.Medication;
import com.agata.routinecare.entity.User;
import com.agata.routinecare.repository.MedicationRepository;
import com.agata.routinecare.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MedicationService {

    private final MedicationRepository medicationRepository;
    private final UserRepository userRepository;

    public MedicationService(MedicationRepository medicationRepository, UserRepository userRepository) {
        this.medicationRepository = medicationRepository;
        this.userRepository = userRepository;
    }

    public Medication registerMedication(MedicationDTO request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found"));

        Medication medication = new Medication();
        medication.setName(request.getName());
        medication.setDosage(request.getDosage());
        medication.setScheduledTime(request.getScheduledTime());
        medication.setUser(user);

        return medicationRepository.save(medication);
    }

    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }

    public Medication getMedicationById(Long id) {
        return medicationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medication not found"));
    }

    public Medication updateMedication(Long id, UpdateMedDTO update) {
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

    public void removeMedication(Long id) {
        Medication medication = medicationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medication not found"));

        medicationRepository.delete(medication);
    }
}
