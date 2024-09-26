package com.etiya.academy.service;

import com.etiya.academy.core.exception.type.BusinessException;
import com.etiya.academy.core.rules.ProductBusinessRules;
import com.etiya.academy.dto.product.*;
import com.etiya.academy.entity.Product;
import com.etiya.academy.mapper.ProductMapper;
import com.etiya.academy.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductBusinessRules productBusinessRules;

    @Override
    public List<ListProductResponseDto> getAll() {
        List<Product> products = productRepository.findAll();
        List<ListProductResponseDto> listProductResponseDtos = ProductMapper.INSTANCE.listResponseDtoFromProduct(products);
        return listProductResponseDtos;
    }

    @Override
    public CreateProductResponseDto add(CreateProductRequestDto createProductRequest) {
        productBusinessRules.productWithSameNameShouldNotExist(createProductRequest.getName());
        //
        Product product = ProductMapper.INSTANCE.productFromCreateRequestDto(createProductRequest);
        //  Random random = new Random();
        //  product.setId(random.nextInt(1, 99999));
        productRepository.save(product);
        CreateProductResponseDto createProductResponseDto = ProductMapper.INSTANCE.createProductResponseDtoFromProduct(product);
        return createProductResponseDto;
    }


    @Override
    public GetProductByIdResponseDto getById(int id) {
        GetProductByIdResponseDto getResponse = ProductMapper.INSTANCE.getProductResponseDtoFromProduct(productRepository.getReferenceById(id));
        return getResponse;
    }

    @Override
    public UpdateProductResponseDto update(UpdateProductRequestDto updateProductRequestDto) {

        Product product = ProductMapper.INSTANCE.productFromUpdateRequestDto(updateProductRequestDto);
        productRepository.save(product);

        UpdateProductResponseDto productResponseDto = ProductMapper.INSTANCE.updateResponseDtoFromProduct(product);
        return productResponseDto;


    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ListProductResponseDto> getByName(String name) {
        List<Product> products = productRepository.findByNameLikeIgnoreCase("%" + name + "%");
        List<ListProductResponseDto> listProductResponseDto = ProductMapper.INSTANCE.listResponseDtoFromProduct(products);
        return listProductResponseDto;

    }

    @Override
    public List<GetProductByCategoryIdResponseDto> getAllByCategoryId(int categoryId) {
        List<Product> products = productRepository.getAllByCategoryId(categoryId);
        return ProductMapper.INSTANCE.getProductByCategoryIdResponseDtos(products);
    }


}
