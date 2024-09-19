package com.etiya.academy.service;

import com.etiya.academy.core.exception.type.BusinessException;
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

    @Override
    public List<ListProductResponseDto> getAll() {
        List<Product> products = productRepository.getAll();
        List<ListProductResponseDto> listProductResponseDtos = ProductMapper.INSTANCE.listResponseDtoFromProduct(products);
        return listProductResponseDtos;
    }

    @Override
    public CreateProductResponseDto add(CreateProductRequestDto createProductRequest) {

        boolean productWithSameName = productRepository.getAll()
                .stream()
                .anyMatch(product -> product.getName().equals(createProductRequest.getName()));

        if (productWithSameName)
            throw new BusinessException("Böyle bir ürün zaten var.");
        //
        int maxStockLimit = 1000;
        if (createProductRequest.getUnitsInStock() > maxStockLimit)
            throw new BusinessException("Stok limiti aşılamaz. Maksimum stok limiti: " + maxStockLimit);
        //
        String regex = "^[a-zA-Z0-9]+$";
        boolean isValidProductName = Pattern.compile(regex).matcher(createProductRequest.getName()).matches();
        if (!isValidProductName)
            throw new BusinessException("Ürün isminde özel karakter bulunamaz");
        //

        Product product = ProductMapper.INSTANCE.productFromCreateRequestDto(createProductRequest);
        Random random = new Random();
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

        Product existingProduct = productRepository.getById(updateProductRequestDto.getId());
        if (existingProduct == null) {
            throw new BusinessException("Güncellenmek istenen ürün bulunamadı.");
        }
        //
        boolean productWithSameName = productRepository.getAll()
                .stream()
                .anyMatch(p -> p.getName().equals(updateProductRequestDto.getName()));

        if (productWithSameName) {
            throw new BusinessException("Bu isimde başka bir ürün zaten mevcut.");
        }
        //
        String regex = "^[a-zA-Z0-9]+$";
        boolean isValidProductName = Pattern.compile(regex).matcher(updateProductRequestDto.getName()).matches();
        if (!isValidProductName)
            throw new BusinessException("Ürün isminde özel karakter bulunamaz");
        //

        Product product = ProductMapper.INSTANCE.productFromUpdateRequestDto(updateProductRequestDto);
        Product updatedProduct = productRepository.update(product);

        UpdateProductResponseDto productResponseDto = ProductMapper.INSTANCE.updateResponseDtoFromProduct(updatedProduct);
        return productResponseDto;


    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public List<GetProductByCategoryIdResponseDto> getAllByCategoryId(int categoryId) {
        List<Product> products = productRepository.getAllByCategoryId(categoryId);
        return ProductMapper.INSTANCE.getProductByCategoryIdResponseDtos(products);
    }


}
