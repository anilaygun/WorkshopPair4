package com.etiya.academy.core.repository;

import com.etiya.academy.core.entity.Entity;
import com.etiya.academy.entity.Product;

import java.util.List;

public interface BaseRepository<T extends Entity> {

    List<T> getAll();

    T add(T entity);

    T getById(int id);

    T update(T entity);

    void delete(int id);

}
