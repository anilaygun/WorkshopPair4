package com.etiya.academy.service;

import com.etiya.academy.entity.Product;

import java.util.List;

public interface ProductService {
    // TODO: DTO!
    List<Product> getAll();

    void add(Product product);

    Product getById(int id);

    void update(Product product);

    void delete(int id);

}
