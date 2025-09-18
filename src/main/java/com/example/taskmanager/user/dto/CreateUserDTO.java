package com.example.taskmanager.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserDTO (
    @NotNull(message = "user is required")
    @NotBlank(message = "user is required")
    String Username
) {}
