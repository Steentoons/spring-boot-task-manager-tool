package com.example.taskmanager.user.mapper;

import com.example.taskmanager.user.User;
import com.example.taskmanager.user.dto.CreateUserDTO;
import com.example.taskmanager.user.dto.UserResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public interface UserMapper {
    public static User toEntity(CreateUserDTO userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        return user;
    }

    public static UserResponseDTO toDTO(User user) {
        return new UserResponseDTO(user.getUsername());
    }

    public static List<UserResponseDTO> toDTO(List<User> users) {
        return users.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }
}
