package com.etiya.academy.repository;

import com.etiya.academy.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findByNameIgnoreCase(String name);

}
