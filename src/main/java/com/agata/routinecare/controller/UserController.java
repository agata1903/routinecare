package com.agata.routinecare.controller;

import com.agata.routinecare.dto.UpdateUserDTO;
import com.agata.routinecare.dto.UserDTO;
import com.agata.routinecare.entity.User;
import com.agata.routinecare.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User registerUser(@RequestBody UserDTO userData) {
        return userService.registerUser(userData);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PatchMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UpdateUserDTO userChanges) {
        return  userService.updateUser(id, userChanges);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}