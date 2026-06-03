package com.agata.routinecare.controller;

import com.agata.routinecare.dto.UserDTO;
import com.agata.routinecare.entity.Medication;
import com.agata.routinecare.entity.User;
import com.agata.routinecare.repository.MedicationRepository;
import com.agata.routinecare.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final MedicationRepository medicationRepository;

    public UserController(UserRepository userRepository, MedicationRepository medicationRepository) {
        this.userRepository = userRepository;
        this.medicationRepository = medicationRepository;
    }

    @PostMapping
    public User registerUser(@Valid @RequestBody UserDTO request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @GetMapping("/{userId}")
    public List<Medication> getByUser(@PathVariable Long userId) {
        return medicationRepository.findByUserId(userId);
    }

}