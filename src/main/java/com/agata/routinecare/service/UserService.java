package com.agata.routinecare.service;

import com.agata.routinecare.dto.UpdateUserDTO;
import com.agata.routinecare.dto.UserDTO;
import com.agata.routinecare.entity.Medication;
import com.agata.routinecare.entity.User;
import com.agata.routinecare.repository.MedicationRepository;
import com.agata.routinecare.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final MedicationRepository medicationRepository;

    public UserService(UserRepository userRepository, MedicationRepository medicationRepository) {
        this.userRepository = userRepository;
        this.medicationRepository = medicationRepository;
    }

    public User registerUser(UserDTO request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<Medication> getByUser(Long userId) {
        return medicationRepository.findByUserId(userId);
    }

    public User updateUser(Long id,UpdateUserDTO requestData) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        if (requestData.getName() != null) {
            user.setName(requestData.getName());
        }
        if (requestData.getEmail() != null) {
            user.setEmail(requestData.getEmail());
        }

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        userRepository.delete(user);
    }
}
