package com.etiya.academy.service;

import com.etiya.academy.entity.Product;
import com.etiya.academy.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public void add(Product product) {
        List<Product> products = productRepository.getAll();
        boolean exists = products.stream().anyMatch(p -> p.getId() == product.getId());

        if (exists) {
            throw new RuntimeException("ID'si " + product.getId() + " olan ürün listede var.");
        } else {
            productRepository.add(product);
        }
    }

    @Override
    public Product getById(int id) {
        return productRepository.getById(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }
}
