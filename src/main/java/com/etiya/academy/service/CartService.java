package com.etiya.academy.service;

import com.etiya.academy.dto.cart.*;
import com.etiya.academy.dto.category.*;

import java.util.List;

public interface CartService {

    List<ListCartResponseDto> getAll();

    CreateCartResponseDto add(CreateCartRequestDto createCartRequestDto);

    GetCartByIdResponseDto getById(int id);

    UpdateCartResponseDto update(UpdateCartRequestDto updateCartRequestDto);

    void delete(int id);

}
