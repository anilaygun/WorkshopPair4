package com.etiya.academy.service;

import com.etiya.academy.dto.cart.*;
import com.etiya.academy.dto.user.*;

import java.util.List;

public interface UserService {

    List<ListUserResponseDto> getAll();

    CreateUserResponseDto add(CreateUserRequestDto createUserRequestDto);

    GetUserByIdResponseDto getById(int id);

    UpdateUserResponseDto update(UpdateUserRequestDto updateUserRequestDto);

    void delete(int id);
}
