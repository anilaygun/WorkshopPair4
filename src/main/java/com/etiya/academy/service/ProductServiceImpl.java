package com.etiya.academy.service;

import com.etiya.academy.dto.product.*;
import com.etiya.academy.entity.Product;
import com.etiya.academy.mapper.ProductMapper;
import com.etiya.academy.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<ListProductResponseDto> getAll() {
        List<Product> products = productRepository.getAll();
        List<ListProductResponseDto> listProductResponseDtos = ProductMapper.INSTANCE.listResponseDtoFromProduct(products);
        return listProductResponseDtos;
    }

    @Override
    public CreateProductResponseDto add(CreateProductRequestDto createProductRequest) {

        Random random = new Random();
        Product product = ProductMapper.INSTANCE.productFromCreateRequestDto(createProductRequest);
        product.setId(random.nextInt(1, 99999));
        productRepository.add(product);
        CreateProductResponseDto createProductResponseDto = ProductMapper.INSTANCE.createProductResponseDtoFromProduct(product);
        return createProductResponseDto;
    }


    @Override
    public GetProductByIdResponseDto getById(int id) {
        GetProductByIdResponseDto getResponse = ProductMapper.INSTANCE.getProductResponseDtoFromProduct(productRepository.getById(id));
        return getResponse;
    }

    @Override
    public UpdateProductResponseDto update(UpdateProductRequestDto updateProductRequestDto) {
        Product product = ProductMapper.INSTANCE.productFromUpdateRequestDto(updateProductRequestDto);
        Product updatedProduct = productRepository.update(product);

        UpdateProductResponseDto productResponseDto = ProductMapper.INSTANCE.updateResponseDtoFromProduct(updatedProduct);
        return productResponseDto;


    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }
}
