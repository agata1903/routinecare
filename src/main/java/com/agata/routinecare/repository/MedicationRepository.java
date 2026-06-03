package com.agata.routinecare.repository;

import com.agata.routinecare.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationRepository extends JpaRepository <Medication, Long> {

    List<Medication> findByUserId(Long userId);
}
