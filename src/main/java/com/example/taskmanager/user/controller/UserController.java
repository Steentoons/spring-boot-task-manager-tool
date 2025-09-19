package com.example.taskmanager.user.controller;

import com.example.taskmanager.user.User;
import com.example.taskmanager.user.dto.CreateUserDTO;
import com.example.taskmanager.user.dto.UpdateUserDto;
import com.example.taskmanager.user.dto.UserResponseDTO;
import com.example.taskmanager.user.repository.UserRepository;
import com.example.taskmanager.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    public UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create_user")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody CreateUserDTO userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/fetch_all_users")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/get_user_by_id/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/update_user/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UpdateUserDto updatedUser) {
        return new ResponseEntity<>(userService.updateUser(id, updatedUser), HttpStatus.OK);
    }
}
