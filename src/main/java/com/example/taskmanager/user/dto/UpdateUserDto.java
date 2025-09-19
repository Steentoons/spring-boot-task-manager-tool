package com.example.taskmanager.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateUserDto(
        @NotBlank(message = "Username is required")
        @NotNull(message = "Username is required")
        String username
) {
}
