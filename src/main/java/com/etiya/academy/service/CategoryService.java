package com.etiya.academy.service;

import com.etiya.academy.dto.category.*;
import com.etiya.academy.dto.product.*;
import com.etiya.academy.entity.Product;

import java.util.List;

public interface CategoryService {
    List<ListCategoryResponseDto> getAll();

    CreateCategoryResponseDto add(CreateCategoryRequestDto createCategoryRequestDto);

    GetCategoryByIdResponseDto getById(int id);

    UpdateCategoryResponseDto update(UpdateCategoryRequestDto updateCategoryRequestDto);

    void delete(int id);

}

