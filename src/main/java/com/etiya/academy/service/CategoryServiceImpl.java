package com.etiya.academy.service;

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

    @Override
    public List<ListCategoryResponseDto> getAll() {
        List<Category> categories = categoryRepository.getAll();
        List<ListCategoryResponseDto> listCategoryResponseDtos = CategoryMapper.INSTANCE.listResponseDtoFromCategory(categories);
        return listCategoryResponseDtos;
    }

    @Override
    public CreateCategoryResponseDto add(CreateCategoryRequestDto createCategoryRequestDto) {

        Random random = new Random();
        Category category = CategoryMapper.INSTANCE.categoryFromCreateRequestDto(createCategoryRequestDto);
        category.setId(random.nextInt(1, 99999));
        categoryRepository.add(category);
        CreateCategoryResponseDto createCategoryResponseDto = CategoryMapper.INSTANCE.createCategoryResponseDtoFromCategory(category);
        return createCategoryResponseDto;
    }


    @Override
    public GetCategoryByIdResponseDto getById(int id) {
        GetCategoryByIdResponseDto getResponse = CategoryMapper.INSTANCE.getCategoryResponseDtoFromCategory(categoryRepository.getById(id));
        return getResponse;
    }

    @Override
    public UpdateCategoryResponseDto update(UpdateCategoryRequestDto updateCategoryRequestDto) {
        Category category = CategoryMapper.INSTANCE.categoryFromUpdateRequestDto(updateCategoryRequestDto);
        Category updatedCategory = categoryRepository.update(category);

        UpdateCategoryResponseDto updateCategoryResponseDto = CategoryMapper.INSTANCE.updateResponseDtoFromCategory(updatedCategory);
        return updateCategoryResponseDto;


    }

    @Override
    public void delete(int id) {
        categoryRepository.delete(id);
    }
}
