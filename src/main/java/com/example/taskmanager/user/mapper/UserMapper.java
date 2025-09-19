package com.example.taskmanager.user.mapper;

import com.example.taskmanager.user.User;
import com.example.taskmanager.user.dto.CreateUserDTO;
import com.example.taskmanager.user.dto.UpdateUserDto;
import com.example.taskmanager.user.dto.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(CreateUserDTO createUserDTO);

    UserResponseDTO toUserResponseDto (User user);
    User toUpdateUserDto(UpdateUserDto updateUserDto, @MappingTarget User user);
}
