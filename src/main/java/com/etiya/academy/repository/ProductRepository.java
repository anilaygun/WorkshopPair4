package com.etiya.academy.repository;

import com.etiya.academy.core.repository.BaseRepository;
import com.etiya.academy.entity.Product;

import java.util.List;

public interface ProductRepository extends BaseRepository<Product> {
    List<Product> getAllByCategoryId(int categoryId);
}
