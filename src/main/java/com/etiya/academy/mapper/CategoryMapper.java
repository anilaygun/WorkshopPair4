package com.etiya.academy.mapper;

import com.etiya.academy.dto.category.CreateCategoryResponseDto;
import com.etiya.academy.dto.category.*;
import com.etiya.academy.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CreateCategoryResponseDto createCategoryResponseDtoFromCategory(Category category);

    GetCategoryByIdResponseDto getCategoryResponseDtoFromCategory(Category category);

    List<ListCategoryResponseDto> listResponseDtoFromCategory(List<Category> categoryList);

    Category categoryFromCreateRequestDto(CreateCategoryRequestDto createCategoryRequestDto);

    Category categoryFromUpdateRequestDto(UpdateCategoryRequestDto updateCategoryRequestDto);

    UpdateCategoryResponseDto updateResponseDtoFromCategory(Category category);
}
