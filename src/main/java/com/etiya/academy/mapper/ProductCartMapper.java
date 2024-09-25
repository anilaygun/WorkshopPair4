package com.etiya.academy.mapper;

import com.etiya.academy.dto.cart.CreateCartResponseDto;
import com.etiya.academy.dto.productCart.*;
import com.etiya.academy.entity.ProductCart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductCartMapper {

    ProductCartMapper INSTANCE = Mappers.getMapper(ProductCartMapper.class);

    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "cartId", target = "cart.id")
    ProductCart createProductCartRequestDto(CreateProductCartRequestDto createProductCartRequestDto);

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "cart.id", target = "cartId")
    CreateProductCartResponseDto createProductCartResponseDto(ProductCart productCart);

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "cart.id", target = "cartId")
    GetProductCartByIdResponseDto getProductCartByIdResponseDto(ProductCart productCart);

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "cart.id", target = "cartId")
    List<ListProductCartResponseDto> listProductCartResponseDto(List<ProductCart> productCarts);

    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "cartId", target = "cart.id")
    ProductCart updateProductCartRequestDto(UpdateProductCartRequestDto updateProductCartRequestDto);

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "cart.id", target = "cartId")
    UpdateProductCartResponseDto updateProductCartResponseDto(ProductCart productCart);
}
