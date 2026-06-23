package com.agata.routinecare.controller;

import com.agata.routinecare.dto.UpdateWaterDTO;
import com.agata.routinecare.dto.WaterDTO;
import com.agata.routinecare.entity.User;
import com.agata.routinecare.entity.WaterIntake;
import com.agata.routinecare.repository.UserRepository;
import com.agata.routinecare.repository.WaterRepository;
import com.agata.routinecare.service.WaterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/water")
public class WaterController {

    private final WaterService waterService;

    public WaterController(WaterService waterService) {
        this.waterService = waterService;
    }

    @GetMapping
    public List<WaterIntake> getAllIntakes() {
        return waterService.getIntakes();
    }

    @PostMapping
    public WaterIntake registerIntake(@RequestBody WaterDTO request) {
        return waterService.registerIntake(request);
    }

    @PatchMapping("/{id}")
    public WaterIntake updateIntake(@PathVariable Long id, @RequestBody UpdateWaterDTO dataChanges) {
        return waterService.updateIntake(id, dataChanges);
    }
}