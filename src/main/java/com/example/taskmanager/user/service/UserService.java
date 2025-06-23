package com.example.taskmanager.user.service;

import com.example.taskmanager.user.User;
import com.example.taskmanager.user.dto.CreateUserDTO;
import com.example.taskmanager.user.dto.UserResponseDTO;
import com.example.taskmanager.user.mapper.UserMapper;
import com.example.taskmanager.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(CreateUserDTO userDto) {
        User user = UserMapper.toEntity(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.toDTO(savedUser);
    }

    public List<UserResponseDTO> getAllUsers() {
        return UserMapper.toDTO(userRepository.findAll());
    }

    public UserResponseDTO getUserById(Long id) {
        User userById = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No user was found with the id" + id));

        return UserMapper.toDTO(userById);
    }

    public UserResponseDTO updateUser(Long id, CreateUserDTO updatedUserDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No user was found with the id " + id));

        existingUser.setUsername(updatedUserDto.getUsername());
        User savedUser = userRepository.save(existingUser);
        return UserMapper.toDTO(savedUser);
    }
}
