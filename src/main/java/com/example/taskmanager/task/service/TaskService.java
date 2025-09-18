package com.example.taskmanager.task.service;

import com.example.taskmanager.errors.ResourceNotFoundException;
import com.example.taskmanager.task.Task;
import com.example.taskmanager.task.dto.CreateTaskDTO;
import com.example.taskmanager.task.dto.TaskResponseDTO;
import com.example.taskmanager.task.mapper.TaskMapper;
import com.example.taskmanager.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    public final TaskRepository taskRepository;
    private TaskMapper taskMapper;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponseDTO createTask(CreateTaskDTO taskDTO) {
        Task savedTask = taskRepository.save(taskMapper.toEntity(taskDTO));
        return taskMapper.toDto(savedTask);
    }

    public List<TaskResponseDTO> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(task -> taskMapper.toDto(task))
                .toList();
    }

    public TaskResponseDTO getTaskById(Long id) {
        Task savedTask = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No task with id " + id + " was found"));
        return taskMapper.toDto(savedTask);
    }

    public TaskResponseDTO updateTask(Long id, CreateTaskDTO updatedTaskDto) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow();
        Task task = taskMapper.toEntity(updatedTaskDto);
        existingTask.setCompleted(task.isCompleted());
        existingTask.setDescription(task.getDescription());
        Task savedTask = taskRepository.save(existingTask);
        return taskMapper.toDto(savedTask);
    }
}
