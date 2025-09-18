package com.example.taskmanager.user.mapper;

import com.example.taskmanager.user.User;
import com.example.taskmanager.user.dto.CreateUserDTO;
import com.example.taskmanager.user.dto.UserResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(CreateUserDTO createUserDTO);
    UserResponseDTO toUserResponseDto (User user);
}
