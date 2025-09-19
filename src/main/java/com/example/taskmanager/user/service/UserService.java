package com.example.taskmanager.user.service;

import com.example.taskmanager.user.User;
import com.example.taskmanager.user.dto.CreateUserDTO;
import com.example.taskmanager.user.dto.UpdateUserDto;
import com.example.taskmanager.user.dto.UserResponseDTO;
import com.example.taskmanager.user.mapper.UserMapper;
import com.example.taskmanager.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDTO createUser(CreateUserDTO userDto) {
        User user = userMapper.toEntity(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.toUserResponseDto(savedUser);
    }

    public List<UserResponseDTO> getAllUsers() {
        List<User> fetchedUsers = userRepository.findAll();
        return fetchedUsers.stream()
                .map(userMapper::toUserResponseDto)
                .toList();
    }

    public UserResponseDTO getUserById(Long id) {
        User userById = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No user was found with the id" + id));

        return userMapper.toUserResponseDto(userById);
    }

    public UserResponseDTO updateUser(Long id, UpdateUserDto updatedUserDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No user was found with the id " + id));

        User userToUpdate = userMapper.toUpdateUserDto(updatedUserDto, existingUser);
//        existingUser.setUsername(userToUpdate.getUsername());
        User savedUser = userRepository.save(userToUpdate);
        return userMapper.toUserResponseDto(savedUser);
    }
}
