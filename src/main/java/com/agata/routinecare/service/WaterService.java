package com.agata.routinecare.service;

import com.agata.routinecare.dto.UpdateWaterDTO;
import com.agata.routinecare.dto.WaterDTO;
import com.agata.routinecare.entity.User;
import com.agata.routinecare.entity.WaterIntake;
import com.agata.routinecare.repository.UserRepository;
import com.agata.routinecare.repository.WaterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class WaterService {

    private final WaterRepository waterRepository;
    private final UserRepository userRepository;

    public WaterService(WaterRepository waterRepository, UserRepository userRepository) {
        this.waterRepository = waterRepository;
        this.userRepository = userRepository;
    }

    public List<WaterIntake> getIntakes() {
        return waterRepository.findAll();
    }

    public WaterIntake registerIntake(WaterDTO request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User id not found!"));

        WaterIntake register = new WaterIntake();
        register.setIntakeDate(LocalDate.now());
        register.setAmountMl(request.getAmountMl());
        register.setIntakeTime(request.getIntakeTime());
        register.setUser(user);

        return waterRepository.save(register);
    }

    public WaterIntake updateIntake(Long id,UpdateWaterDTO dataChanges) {
        WaterIntake intake = waterRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Register not found"));

        if (dataChanges.getAmountMl() != null) {
            intake.setAmountMl(dataChanges.getAmountMl());
        }

        if (dataChanges.getIntakeTime() != null) {
            intake.setIntakeTime(dataChanges.getIntakeTime());
        }

        return waterRepository.save(intake);
    }
}
