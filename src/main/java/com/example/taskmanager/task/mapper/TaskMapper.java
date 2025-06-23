package com.example.taskmanager.task.mapper;

import com.example.taskmanager.task.Task;
import com.example.taskmanager.task.dto.CreateTaskDTO;
import com.example.taskmanager.task.dto.TaskResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public interface TaskMapper {
    public static Task toEntity(CreateTaskDTO dto) {
        Task task = new Task();
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.getCompleted());
        return task;
    }

    public static TaskResponseDTO toDTO(Task task) {
        TaskResponseDTO responseDTO = new TaskResponseDTO();
        responseDTO.setDescription(task.getDescription());
        responseDTO.setCompleted(String.valueOf(task.isCompleted()));
        return responseDTO;
    }

    public static List<TaskResponseDTO> toDTO(List<Task> tasks) {
        return tasks.stream()
                .map(TaskMapper::toDTO)
                .collect(Collectors.toList());
    }
}
