package com.etiya.academy.repository;

import com.etiya.academy.entity.Cart;
import com.etiya.academy.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
