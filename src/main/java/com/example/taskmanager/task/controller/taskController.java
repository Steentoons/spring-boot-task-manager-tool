package com.example.taskmanager.task.controller;

import com.example.taskmanager.task.Task;
import com.example.taskmanager.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class taskController {
    private final TaskRepository taskRepository;

    @Autowired
    public taskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        System.out.print(task);
        Task savedTask = taskRepository.save(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        List<Task> fetchedTasks = taskRepository.findAll();
        return new ResponseEntity<>(fetchedTasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task fetchedTasks = taskRepository.findById(id)
                .orElseThrow();
        return new ResponseEntity<>(fetchedTasks, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task updatedTask, @PathVariable Long id) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow();
        existingTask.setCompleted(updatedTask.isCompleted());
        existingTask.setDescription(updatedTask.getDescription());
        Task savedTask = taskRepository.save(existingTask);
        return new ResponseEntity<Task>(savedTask, HttpStatus.OK);
    }
}
