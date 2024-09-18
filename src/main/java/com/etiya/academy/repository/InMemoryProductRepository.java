package com.etiya.academy.repository;

import com.etiya.academy.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product add(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product getById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Product update(Product product) {
        Product productToUpdate = getById(product.getId());
        if (productToUpdate != null) {
            productToUpdate.setName(product.getName());
            productToUpdate.setUnitPrice(product.getUnitPrice());
            productToUpdate.setUnitsInStock(product.getUnitsInStock());
            return productToUpdate;
        }
        return null;
    }

    @Override
    public void delete(int id) {
        products.removeIf(p -> p.getId() == id);
    }
}
