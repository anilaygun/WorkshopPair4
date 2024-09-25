package com.etiya.academy.service;

import com.etiya.academy.dto.productCart.*;
import com.etiya.academy.entity.ProductCart;
import com.etiya.academy.mapper.CartMapper;
import com.etiya.academy.mapper.ProductCartMapper;
import com.etiya.academy.repository.ProductCartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductCartServiceImpl implements ProductCartService {
    private final ProductCartRepository productCartRepository;

    @Override
    public List<ListProductCartResponseDto> getAll() {
        List<ProductCart> productCarts = productCartRepository.findAll();
        List<ListProductCartResponseDto> listProductCartResponseDto = ProductCartMapper.INSTANCE.listProductCartResponseDto(productCarts);
        return listProductCartResponseDto;
    }

    @Override
    public CreateProductCartResponseDto add(CreateProductCartRequestDto createProductCartRequestDto) {
        ProductCart productCart = ProductCartMapper.INSTANCE.createProductCartRequestDto(createProductCartRequestDto);
        productCartRepository.save(productCart);

        CreateProductCartResponseDto productCartResponseDto = ProductCartMapper.INSTANCE.createProductCartResponseDto(productCart);
        return productCartResponseDto;
    }

    @Override
    public GetProductCartByIdResponseDto getById(int id) {
        GetProductCartByIdResponseDto responseDto = ProductCartMapper.INSTANCE.getProductCartByIdResponseDto(productCartRepository.getReferenceById(id));
        return responseDto;
    }

    @Override
    public UpdateProductCartResponseDto update(UpdateProductCartRequestDto updateProductCartRequestDto) {
        ProductCart productCart = ProductCartMapper.INSTANCE.updateProductCartRequestDto(updateProductCartRequestDto);
        productCartRepository.save(productCart);

        UpdateProductCartResponseDto responseDto = ProductCartMapper.INSTANCE.updateProductCartResponseDto(productCart);
        return responseDto;
    }

    @Override
    public void delete(int id) {
        productCartRepository.deleteById(id);
    }
}
