package com.etiya.academy.repository;

import com.etiya.academy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> getAllByCategoryId(int categoryId);

    List<Product> findByNameLikeIgnoreCase(String name);

    Optional<Product> findByNameIgnoreCase(String name);
}
