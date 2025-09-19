package com.example.taskmanager.task.dto;

public record UpdateTaskDto(
        String description,
        Boolean completed
) {
}
