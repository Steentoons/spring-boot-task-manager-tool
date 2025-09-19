package com.example.taskmanager.task.service;

import com.example.taskmanager.errors.ResourceNotFoundException;
import com.example.taskmanager.task.Task;
import com.example.taskmanager.task.dto.CreateTaskDTO;
import com.example.taskmanager.task.dto.TaskResponseDTO;
import com.example.taskmanager.task.dto.UpdateTaskDto;
import com.example.taskmanager.task.mapper.TaskMapper;
import com.example.taskmanager.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
        this.taskRepository = taskRepository;
    }

    public TaskResponseDTO createTask(CreateTaskDTO taskDTO) {
        Task savedTask = taskRepository.save(taskMapper.toEntity(taskDTO));
        return taskMapper.toDto(savedTask);
    }

    public List<TaskResponseDTO> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        System.out.println("=======================================================");
        tasks.forEach(System.out::println);
        return tasks.stream()
                .map(taskMapper::toDto)
                .toList();
    }

    public TaskResponseDTO getTaskById(Long id) {
        Task savedTask = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No task with id " + id + " was found"));
        return taskMapper.toDto(savedTask);
    }

    public TaskResponseDTO updateTask(Long id, UpdateTaskDto updatedTaskDto) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow();
        Task task = taskMapper.toUpdateTaskDto(updatedTaskDto, existingTask);
        Task savedTask = taskRepository.save(existingTask);
        return taskMapper.toDto(savedTask);
    }
}
