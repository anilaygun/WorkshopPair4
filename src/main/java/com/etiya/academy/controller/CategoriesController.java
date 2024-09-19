package com.etiya.academy.controller;

import com.etiya.academy.dto.category.*;
import com.etiya.academy.dto.product.*;
import com.etiya.academy.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoriesController {
    private final CategoryService categoryService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<ListCategoryResponseDto> getAll() {

        return categoryService.getAll();
    }

    @PostMapping()
    public ResponseEntity<CreateCategoryResponseDto> add(@RequestBody @Valid CreateCategoryRequestDto createCategoryRequestDto) {
        if (createCategoryRequestDto != null) {
            CreateCategoryResponseDto createCategoryResponseDto = categoryService.add(createCategoryRequestDto);
            return new ResponseEntity<CreateCategoryResponseDto>(createCategoryResponseDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<CreateCategoryResponseDto>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GetCategoryByIdResponseDto> getById(@PathVariable @Valid int id) {
        GetCategoryByIdResponseDto categoryByIdResponseDto = categoryService.getById(id);

        if (categoryByIdResponseDto != null) {
            return new ResponseEntity<GetCategoryByIdResponseDto>(categoryByIdResponseDto, HttpStatus.OK);
        }
        return new ResponseEntity<GetCategoryByIdResponseDto>(categoryByIdResponseDto, HttpStatus.NOT_FOUND);
    }

    @PutMapping()
    public ResponseEntity<UpdateCategoryResponseDto> update(@RequestBody @Valid UpdateCategoryRequestDto updateCategoryRequestDto) {
        UpdateCategoryResponseDto updateCategoryResponseDto = categoryService.update(updateCategoryRequestDto);
        if (updateCategoryRequestDto != null) {
            return new ResponseEntity<>(updateCategoryResponseDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(updateCategoryResponseDto, HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        GetCategoryByIdResponseDto deletedCategory = categoryService.getById(id);
        if (deletedCategory != null) {
            categoryService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
