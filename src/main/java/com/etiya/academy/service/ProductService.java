package com.etiya.academy.service;

import com.etiya.academy.dto.product.*;
import com.etiya.academy.entity.Product;

import java.util.List;

public interface ProductService {
    // TODO: DTO!
    List<ListProductResponseDto> getAll();

    CreateProductResponseDto add(CreateProductRequestDto createProductRequest);

    GetProductByIdResponseDto getById(int id);

    UpdateProductResponseDto update(UpdateProductRequestDto updateProductRequestDto);

    void delete(int id);

}
