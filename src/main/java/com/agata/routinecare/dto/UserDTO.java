package com.agata.routinecare.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@JsonPropertyOrder({"name", "email"})
public class UserDTO {

    @Schema(description = "User name",
            example = "Mary")
    @NotBlank(message = "Name is required")
    private String name;

    @Schema(description = "User email",
            example = "user@gmail.com")
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;

    public UserDTO() {
    }

    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
