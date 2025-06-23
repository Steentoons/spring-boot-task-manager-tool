package com.example.taskmanager.task.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskDTO {
    @NotBlank(message = "description is required")
    @NotNull(message = "description is required")
    private String description;

    @NotNull(message = "completed is required")
    private Boolean completed;
}
