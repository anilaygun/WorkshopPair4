package com.etiya.academy.service;

import com.etiya.academy.dto.cart.*;
import com.etiya.academy.dto.category.UpdateCategoryResponseDto;
import com.etiya.academy.entity.Cart;
import com.etiya.academy.mapper.CartMapper;
import com.etiya.academy.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    @Override
    public List<ListCartResponseDto> getAll() {
        List<Cart> carts = cartRepository.findAll();
        List<ListCartResponseDto> listCartResponseDto = CartMapper.INSTANCE.listCartResponseDto(carts);
        return listCartResponseDto;
    }

    @Override
    public CreateCartResponseDto add(CreateCartRequestDto createCartRequestDto) {
        Cart cart = CartMapper.INSTANCE.createCartRequestDto(createCartRequestDto);
        cart.setCreatedDate(new Date());
        cartRepository.save(cart);
        CreateCartResponseDto createCartResponseDto = CartMapper.INSTANCE.createCartResponseDto(cart);
        return createCartResponseDto;
    }

    @Override
    public GetCartByIdResponseDto getById(int id) {
        GetCartByIdResponseDto getResponse = CartMapper.INSTANCE.getCartByIdResponseDto(cartRepository.getReferenceById(id));
        return getResponse;
    }

    @Override
    public UpdateCartResponseDto update(UpdateCartRequestDto updateCartRequestDto) {
        Cart cart = CartMapper.INSTANCE.updateCartRequestDto(updateCartRequestDto);
        cartRepository.save(cart);

        UpdateCartResponseDto cartResponseDto = CartMapper.INSTANCE.updateCartResponseDto(cart);
        return cartResponseDto;
    }

    @Override
    public void delete(int id) {
        cartRepository.deleteById(id);
    }
}
