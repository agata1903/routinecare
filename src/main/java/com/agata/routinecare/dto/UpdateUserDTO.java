package com.agata.routinecare.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;

public class UpdateUserDTO {

    @Schema(description = "User name",
            example = "Mary")
    private String name;

    @Schema(description = "User email",
            example = "user@gmail.com")
    @Email(message = "Invalid email")
    private String email;

    public UpdateUserDTO() {
    }

    public UpdateUserDTO(String name, String email) {
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
