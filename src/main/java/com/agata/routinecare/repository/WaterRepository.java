package com.agata.routinecare.repository;

import com.agata.routinecare.entity.WaterIntake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaterRepository extends JpaRepository <WaterIntake, Long> {
}
