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
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(CreateUserDTO userDto) {
        User user = userMapper.toEntity(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.toUserResponseDto(savedUser);
    }

    public List<UserResponseDTO> getAllUsers() {
        List<User> fetchedUsers = userRepository.findAll();
        return fetchedUsers.stream()
                .map(user -> userMapper.toUserResponseDto(user))
                .toList();
    }

    public UserResponseDTO getUserById(Long id) {
        User userById = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No user was found with the id" + id));

        return userMapper.toUserResponseDto(userById);
    }

    public UserResponseDTO updateUser(Long id, CreateUserDTO updatedUserDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No user was found with the id " + id));

        User userToUpdate = userMapper.toEntity(updatedUserDto);
        existingUser.setUsername(userToUpdate.getUsername());
        User savedUser = userRepository.save(existingUser);
        return userMapper.toUserResponseDto(savedUser);
    }
}
