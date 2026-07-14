package com.agata.routinecare.controller;

import com.agata.routinecare.dto.UpdateWaterDTO;
import com.agata.routinecare.dto.WaterDTO;
import com.agata.routinecare.entity.WaterIntake;
import com.agata.routinecare.service.WaterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Water intake", description = "Operations related to water intake")
@RestController
@RequestMapping("/water")
public class WaterController {

    private final WaterService waterService;

    public WaterController(WaterService waterService) {
        this.waterService = waterService;
    }

    @Operation(summary = "List all intakes")
    @GetMapping
    public List<WaterIntake> getAllIntakes() {
        return waterService.getIntakes();
    }

    @Operation(summary = "Register a new water intake")
    @PostMapping
    public WaterIntake registerIntake(@Valid @RequestBody WaterDTO request) {
        return waterService.registerIntake(request);
    }

    @Operation(summary = "Change an intake information")
    @PatchMapping("/{id}")
    public WaterIntake updateIntake(@PathVariable("id") Long id, @Valid @RequestBody UpdateWaterDTO dataChanges) {
        return waterService.updateIntake(id, dataChanges);
    }
}