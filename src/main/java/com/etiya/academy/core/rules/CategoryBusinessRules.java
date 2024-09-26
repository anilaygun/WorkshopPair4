package com.etiya.academy.core.rules;

import com.etiya.academy.core.exception.type.BusinessException;
import com.etiya.academy.entity.Category;
import com.etiya.academy.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CategoryBusinessRules {
    private final CategoryRepository categoryRepository;


    public void categoryWithSameNameShouldNotExist(String name) {
        Optional<Category> category = categoryRepository.findByNameIgnoreCase(name);
        if (category.isPresent()) {
            throw new BusinessException("Böyle bir kategori zaten var.");
        }
    }
}
