package com.agata.routinecare.controller;

import com.agata.routinecare.dto.UpdateUserDTO;
import com.agata.routinecare.dto.UserDTO;
import com.agata.routinecare.entity.User;
import com.agata.routinecare.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Users", description = "Operations related to users")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Register a new user")
    @PostMapping
    public User registerUser(@Valid @RequestBody UserDTO userData) {
        return userService.registerUser(userData);
    }

    @Operation(summary = "List all users")
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Search an user by its id")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @Operation(summary = "Change an user information")
    @PatchMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @Valid @RequestBody UpdateUserDTO userChanges) {
        return  userService.updateUser(id, userChanges);
    }

    @Operation(summary = "Delete an user")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}