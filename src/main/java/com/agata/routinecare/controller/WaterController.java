package com.agata.routinecare.controller;

import com.agata.routinecare.dto.WaterDTO;
import com.agata.routinecare.entity.User;
import com.agata.routinecare.entity.WaterIntake;
import com.agata.routinecare.repository.UserRepository;
import com.agata.routinecare.repository.WaterRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/water")
public class WaterController {

    private final WaterRepository waterRepository;
    private final UserRepository userRepository;

    public WaterController(WaterRepository waterRepository, UserRepository userRepository) {
        this.waterRepository = waterRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<WaterIntake> getIntakes() {
        return waterRepository.findAll();
    }

    @PostMapping
    public WaterIntake registerIntake(@Valid @RequestBody WaterDTO request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User id not found!"));

        WaterIntake register = new WaterIntake();
        register.setIntakeDate(LocalDate.now());
        register.setAmountMl(request.getAmount());
        register.setIntakeTime(request.getIntakeTime());
        register.setUser(user);

        return waterRepository.save(register);
    }

}