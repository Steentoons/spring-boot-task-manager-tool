package com.example.taskmanager.task.mapper;

import com.example.taskmanager.task.Task;
import com.example.taskmanager.task.dto.CreateTaskDTO;
import com.example.taskmanager.task.dto.TaskResponseDTO;
import com.example.taskmanager.task.dto.UpdateTaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toEntity(CreateTaskDTO createTaskDTO);
    TaskResponseDTO toDto(Task task);
    Task toUpdateTaskDto(UpdateTaskDto updateTaskDto, @MappingTarget Task task);
}
