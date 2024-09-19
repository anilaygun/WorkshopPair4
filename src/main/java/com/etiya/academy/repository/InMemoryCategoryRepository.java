package com.etiya.academy.repository;

import com.etiya.academy.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCategoryRepository implements CategoryRepository {

    List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> getAll() {
        return categories;
    }

    @Override
    public Category add(Category entity) {
        categories.add(entity);
        return entity;
    }

    @Override
    public Category getById(int id) {
        return categories.stream().filter(category -> category.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Category update(Category entity) {
        Category categoryToUpdate = getById(entity.getId());
        if (categoryToUpdate != null) {
            categoryToUpdate.setName(entity.getName());
            return categoryToUpdate;
        }
        return null;
    }

    @Override
    public void delete(int id) {
        categories.removeIf(c -> c.getId() == id);
    }
}
