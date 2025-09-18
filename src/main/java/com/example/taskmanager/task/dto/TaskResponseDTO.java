package com.example.taskmanager.task.dto;

public record TaskResponseDTO (
    String description,
    Boolean completed
) {}
