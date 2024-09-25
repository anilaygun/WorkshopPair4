package com.etiya.academy.mapper;

import com.etiya.academy.dto.product.*;
import com.etiya.academy.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "category.id", target = "categoryId")
    CreateProductResponseDto createProductResponseDtoFromProduct(Product product);

    @Mapping(source = "category.id", target = "categoryId")
    GetProductByIdResponseDto getProductResponseDtoFromProduct(Product product);

    @Mapping(source = "category.id", target = "categoryId")
    GetProductByCategoryIdResponseDto getProductByCategoryIdResponseDtoFromProduct(Product product);

    @Mapping(source = "category.id", target = "categoryId")
    List<GetProductByCategoryIdResponseDto> getProductByCategoryIdResponseDtos(List<Product> products);

    @Mapping(source = "category.id", target = "categoryId")
    List<ListProductResponseDto> listResponseDtoFromProduct(List<Product> productList);

    @Mapping(source = "categoryId", target = "category.id")
    Product productFromCreateRequestDto(CreateProductRequestDto createProductRequestDto);

    @Mapping(source = "categoryId", target = "category.id")
    Product productFromUpdateRequestDto(UpdateProductRequestDto updateProductRequestDto);

    @Mapping(source = "category.id", target = "categoryId")
    UpdateProductResponseDto updateResponseDtoFromProduct(Product product);
}
