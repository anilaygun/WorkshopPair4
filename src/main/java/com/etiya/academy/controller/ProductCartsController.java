package com.etiya.academy.controller;

import com.etiya.academy.dto.cart.*;
import com.etiya.academy.dto.product.GetProductByIdResponseDto;
import com.etiya.academy.dto.product.UpdateProductRequestDto;
import com.etiya.academy.dto.productCart.*;
import com.etiya.academy.service.ProductCartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productCarts")
@RequiredArgsConstructor
public class ProductCartsController {
    private final ProductCartService productCartService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<ListProductCartResponseDto> getAll() {

        return productCartService.getAll();
    }

    @PostMapping()
    public ResponseEntity<CreateProductCartResponseDto> add(@RequestBody @Valid CreateProductCartRequestDto createProductCartRequestDto) {
        if (createProductCartRequestDto != null) {
            CreateProductCartResponseDto createCartResponseDto = productCartService.add(createProductCartRequestDto);
            return new ResponseEntity<>(createCartResponseDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GetProductCartByIdResponseDto> getById(@PathVariable @Valid int id) {
        GetProductCartByIdResponseDto getProductCartByIdResponseDto = productCartService.getById(id);

        if (getProductCartByIdResponseDto != null) {
            return new ResponseEntity<>(getProductCartByIdResponseDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(getProductCartByIdResponseDto, HttpStatus.NOT_FOUND);
    }

    @PutMapping()
    public ResponseEntity<UpdateProductCartResponseDto> update(@RequestBody @Valid UpdateProductCartRequestDto updateProductCartRequestDto) {
        UpdateProductCartResponseDto productCartResponseDto = productCartService.update(updateProductCartRequestDto);
        if (updateProductCartRequestDto != null) {
            return new ResponseEntity<>(productCartResponseDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(productCartResponseDto, HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        GetProductCartByIdResponseDto deletedProductCart = productCartService.getById(id);
        if (deletedProductCart != null) {
            productCartService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
