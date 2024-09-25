package com.etiya.academy.service;

import com.etiya.academy.dto.cart.*;
import com.etiya.academy.dto.product.ListProductResponseDto;
import com.etiya.academy.dto.productCart.*;

import java.util.List;

public interface ProductCartService {
    List<ListProductCartResponseDto> getAll();

    CreateProductCartResponseDto add(CreateProductCartRequestDto createProductCartRequestDto);

    GetProductCartByIdResponseDto getById(int id);

    UpdateProductCartResponseDto update(UpdateProductCartRequestDto updateProductCartRequestDto);

    void delete(int id);
}
