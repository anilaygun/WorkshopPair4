package com.etiya.academy.service;

import com.etiya.academy.core.rules.CategoryBusinessRules;
import com.etiya.academy.dto.category.*;
import com.etiya.academy.dto.product.*;
import com.etiya.academy.entity.Category;
import com.etiya.academy.entity.Product;
import com.etiya.academy.mapper.CategoryMapper;
import com.etiya.academy.mapper.ProductMapper;
import com.etiya.academy.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryBusinessRules categoryBusinessRules;

    @Override
    public List<ListCategoryResponseDto> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<ListCategoryResponseDto> listCategoryResponseDtos = CategoryMapper.INSTANCE.listResponseDtoFromCategory(categories);
        return listCategoryResponseDtos;
    }

    @Override
    public CreateCategoryResponseDto add(CreateCategoryRequestDto createCategoryRequestDto) {
        categoryBusinessRules.categoryWithSameNameShouldNotExist(createCategoryRequestDto.getName());

        Category category = CategoryMapper.INSTANCE.categoryFromCreateRequestDto(createCategoryRequestDto);
        categoryRepository.save(category);

        CreateCategoryResponseDto createCategoryResponseDto = CategoryMapper.INSTANCE.createCategoryResponseDtoFromCategory(category);
        return createCategoryResponseDto;
    }


    @Override
    public GetCategoryByIdResponseDto getById(int id) {
        GetCategoryByIdResponseDto getResponse = CategoryMapper.INSTANCE.getCategoryResponseDtoFromCategory(categoryRepository.getReferenceById(id));
        return getResponse;
    }

    @Override
    public UpdateCategoryResponseDto update(UpdateCategoryRequestDto updateCategoryRequestDto) {
        Category category = CategoryMapper.INSTANCE.categoryFromUpdateRequestDto(updateCategoryRequestDto);
        Category updatedCategory = categoryRepository.save(category);

        UpdateCategoryResponseDto updateCategoryResponseDto = CategoryMapper.INSTANCE.updateResponseDtoFromCategory(updatedCategory);
        return updateCategoryResponseDto;


    }

    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }
}
