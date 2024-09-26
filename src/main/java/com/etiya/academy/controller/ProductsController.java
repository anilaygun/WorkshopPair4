
package com.etiya.academy.controller;

import com.etiya.academy.dto.product.*;
import com.etiya.academy.entity.Product;
import com.etiya.academy.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductService productService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<ListProductResponseDto> getAll() {

        return productService.getAll();
    }

    @GetMapping("{name}")
    public ResponseEntity<List<ListProductResponseDto>> getByName(@PathVariable String name) {
        return ResponseEntity.ok(productService.getByName(name));
    }

    @PostMapping()
    public ResponseEntity<CreateProductResponseDto> add(@RequestBody @Valid CreateProductRequestDto createProductRequest) {
        if (createProductRequest != null) {
            CreateProductResponseDto createProductResponseDto = productService.add(createProductRequest);
            return new ResponseEntity<CreateProductResponseDto>(createProductResponseDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<CreateProductResponseDto>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GetProductByIdResponseDto> getById(@PathVariable @Valid int id) {
        GetProductByIdResponseDto productByIdResponseDto = productService.getById(id);

        if (productByIdResponseDto != null) {
            return new ResponseEntity<GetProductByIdResponseDto>(productByIdResponseDto, HttpStatus.OK);
        }
        return new ResponseEntity<GetProductByIdResponseDto>(productByIdResponseDto, HttpStatus.NOT_FOUND);
    }

    @PutMapping()
    public ResponseEntity<UpdateProductResponseDto> update(@RequestBody @Valid UpdateProductRequestDto updateProductRequestDto) {
        UpdateProductResponseDto productResponseDto = productService.update(updateProductRequestDto);
        if (updateProductRequestDto != null) {
            return new ResponseEntity<>(productResponseDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(productResponseDto, HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        GetProductByIdResponseDto deletedProduct = productService.getById(id);
        if (deletedProduct != null) {
            productService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/productByCategoryId/{categoryId}")
    public ResponseEntity<List<GetProductByCategoryIdResponseDto>> getAllByCategoryId(@PathVariable @Valid int categoryId) {
        List<GetProductByCategoryIdResponseDto> products = productService.getAllByCategoryId(categoryId);
        if (products != null && !products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
