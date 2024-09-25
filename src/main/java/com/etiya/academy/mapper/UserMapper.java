package com.etiya.academy.mapper;

import com.etiya.academy.dto.user.*;
import com.etiya.academy.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    User createUserRequestDto(CreateUserRequestDto createUserRequestDto);

    CreateUserResponseDto createUserResponseDto(User user);

    GetUserByIdResponseDto getUserByIdResponseDto(User user);

    List<ListUserResponseDto> listUserResponseDto(List<User> user);

    User updateUserRequestDto(UpdateUserRequestDto updateUserRequestDto);

    UpdateUserResponseDto updateUserResponseDto(User user);


}
