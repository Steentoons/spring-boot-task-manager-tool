package com.example.taskmanager.task.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTaskDTO (
    @NotBlank(message = "description is required")
    @NotNull(message = "description is required")
    String description,

    @NotNull(message = "completed is required")
    @NotNull(message = "completed is required")
    Boolean completed
) {}
