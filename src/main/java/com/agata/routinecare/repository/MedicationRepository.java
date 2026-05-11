package com.agata.routinecare.repository;

import com.agata.routinecare.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository <Medication, Long> {
}
