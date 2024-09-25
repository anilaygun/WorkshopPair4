package com.etiya.academy.service;

import com.etiya.academy.dto.user.*;
import com.etiya.academy.entity.User;
import com.etiya.academy.mapper.UserMapper;
import com.etiya.academy.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<ListUserResponseDto> getAll() {
        List<User> users = userRepository.findAll();
        List<ListUserResponseDto> listUserResponseDto = UserMapper.INSTANCE.listUserResponseDto(users);
        return listUserResponseDto;
    }

    @Override
    public CreateUserResponseDto add(CreateUserRequestDto createUserRequestDto) {
        User user = UserMapper.INSTANCE.createUserRequestDto(createUserRequestDto);
        userRepository.save(user);
        CreateUserResponseDto responseDto = UserMapper.INSTANCE.createUserResponseDto(user);
        return responseDto;
    }

    @Override
    public GetUserByIdResponseDto getById(int id) {
        GetUserByIdResponseDto getResponse = UserMapper.INSTANCE.getUserByIdResponseDto(userRepository.getReferenceById(id));
        return getResponse;
    }

    @Override
    public UpdateUserResponseDto update(UpdateUserRequestDto updateUserRequestDto) {
        User user = UserMapper.INSTANCE.updateUserRequestDto(updateUserRequestDto);
        User updatedUser=userRepository.save(user);

        UpdateUserResponseDto responseDto = UserMapper.INSTANCE.updateUserResponseDto(updatedUser);
        return responseDto;
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
