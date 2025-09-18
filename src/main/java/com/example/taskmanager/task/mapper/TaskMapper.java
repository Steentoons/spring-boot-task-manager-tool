package com.example.taskmanager.task.mapper;

import com.example.taskmanager.task.Task;
import com.example.taskmanager.task.dto.CreateTaskDTO;
import com.example.taskmanager.task.dto.TaskResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toEntity(CreateTaskDTO createTaskDTO);
    TaskResponseDTO toDto(Task task);
}
