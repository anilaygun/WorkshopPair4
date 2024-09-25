package com.etiya.academy.mapper;

import com.etiya.academy.dto.cart.*;
import com.etiya.academy.dto.user.UpdateUserResponseDto;
import com.etiya.academy.entity.Cart;
import com.etiya.academy.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CartMapper {

    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    @Mapping(source = "userId", target = "user.id")
    Cart createCartRequestDto(CreateCartRequestDto createCartRequestDto);

    @Mapping(source = "user.id", target = "userId")
    CreateCartResponseDto createCartResponseDto(Cart cart);

    @Mapping(source = "user.id", target = "userId")
    GetCartByIdResponseDto getCartByIdResponseDto(Cart cart);

    @Mapping(source = "user.id", target = "userId")
    List<ListCartResponseDto> listCartResponseDto(List<Cart> cart);

    @Mapping(source = "userId", target = "user.id")
    Cart updateCartRequestDto(UpdateCartRequestDto updateCartRequestDto);

    @Mapping(source = "user.id", target = "userId")
    UpdateCartResponseDto updateCartResponseDto(Cart cart);
}
