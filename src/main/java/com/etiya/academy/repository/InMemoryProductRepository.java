package com.etiya.academy.repository;

import com.etiya.academy.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product add(Product entity) {
        products.add(entity);
        return entity;
    }

    @Override
    public Product getById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Product update(Product entity) {
        Product productToUpdate = getById(entity.getId());
        if (productToUpdate != null) {
            productToUpdate.setName(entity.getName());
            productToUpdate.setUnitPrice(entity.getUnitPrice());
            productToUpdate.setUnitsInStock(entity.getUnitsInStock());
            return productToUpdate;
        }
        return null;
    }

    @Override
    public void delete(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    @Override
    public List<Product> getAllByCategoryId(int categoryId) {
        return products.stream()
                .filter(product -> product.getCategory() != null && product.getCategory().getId() == categoryId)
                .collect(Collectors.toList());
    }
}
