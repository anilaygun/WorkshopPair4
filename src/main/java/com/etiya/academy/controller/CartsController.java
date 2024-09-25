package com.etiya.academy.controller;

import com.etiya.academy.dto.cart.*;
import com.etiya.academy.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartsController {
    private final CartService cartService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<ListCartResponseDto> getAll() {

        return cartService.getAll();
    }

    @PostMapping()
    public ResponseEntity<CreateCartResponseDto> add(@RequestBody @Valid CreateCartRequestDto createCartRequestDto) {
        if (createCartRequestDto != null) {
            CreateCartResponseDto createCartResponseDto = cartService.add(createCartRequestDto);
            return new ResponseEntity<>(createCartResponseDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GetCartByIdResponseDto> getById(@PathVariable @Valid int id) {
        GetCartByIdResponseDto getCartByIdResponseDto = cartService.getById(id);

        if (getCartByIdResponseDto != null) {
            return new ResponseEntity<>(getCartByIdResponseDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(getCartByIdResponseDto, HttpStatus.NOT_FOUND);
    }

    @PutMapping()
    public ResponseEntity<UpdateCartResponseDto> update(@RequestBody @Valid UpdateCartRequestDto updateCartRequestDto) {
        UpdateCartResponseDto cartResponseDto = cartService.update(updateCartRequestDto);
        if (updateCartRequestDto != null) {
            return new ResponseEntity<>(cartResponseDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(cartResponseDto, HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        GetCartByIdResponseDto deletedCart = cartService.getById(id);
        if (deletedCart != null) {
            cartService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
