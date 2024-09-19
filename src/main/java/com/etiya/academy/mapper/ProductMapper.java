package com.etiya.academy.mapper;

import com.etiya.academy.dto.product.*;
import com.etiya.academy.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    CreateProductResponseDto createProductResponseDtoFromProduct(Product product);

    GetProductByIdResponseDto getProductResponseDtoFromProduct(Product product);

//    List<GetProductByCategoryIdResponseDto> getProductByCategoryIdResponseDto(List<Product> product);
GetProductByCategoryIdResponseDto getProductByCategoryIdResponseDtoFromProduct(Product product);

    List<GetProductByCategoryIdResponseDto> getProductByCategoryIdResponseDtos(List<Product> products);


    List<ListProductResponseDto> listResponseDtoFromProduct(List<Product> productList);

    Product productFromCreateRequestDto(CreateProductRequestDto createProductRequestDto);

    Product productFromUpdateRequestDto(UpdateProductRequestDto updateProductRequestDto);

    UpdateProductResponseDto updateResponseDtoFromProduct(Product product);
}
